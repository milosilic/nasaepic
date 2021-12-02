package com.nasa.epic.command;

import com.nasa.epic.builder.UrlBuilder;
import com.nasa.epic.model.Epic;
import com.nasa.epic.shell.ShellHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.shell.standard.ShellOption.NULL;

@ShellComponent
public class NasaEpicCommand {

    @Autowired
    ShellHelper shellHelper;

    private static String baseURL = "https://api.nasa.gov/EPIC/api/natural/date/";

    @ShellMethod("Retrieve images from NASA API")
    public void getImage(@ShellOption({"-K", "--key"}) String key, @ShellOption({"-P", "--path"}) String path, @ShellOption(defaultValue = NULL) String date) {

        String urlWithKey = null;
        //Validation
        if (date != null) {
            boolean isValidDate = GenericValidator.isDate(date, "yyyy-MM-dd", true);
            if (!isValidDate) {
                shellHelper.printError("Error: invalid date provided");
                return;
            }

            urlWithKey = new UrlBuilder().setBaseUrl(baseURL).setDate(date).setKey(key).buildUrl();
        } else {
            urlWithKey = new UrlBuilder().setKey(key).buildUrlWithoutDate();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        URL urlObject = null;
        //String urlWithKey = baseURL + date + "?api_key=" + key;

        System.out.println(urlWithKey);

        Epic[] imageObjects = null;
        try {
            urlObject = new URL(urlWithKey);
            imageObjects = objectMapper.readValue(urlObject, Epic[].class);
            if(date == null) {
                date = imageObjects[0].getDate();

            }
        } catch (IOException e) {
            shellHelper.printError(e.getMessage());
            return;
        }

        SimpleDateFormat urlTargetFormat = new SimpleDateFormat("yyyy/MM/dd");
        String urlFormattedDate = null;//2021-11-29
        String folderDateFormat = null;//20211129
        try {
            Date simpleDateObject = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            urlFormattedDate = urlTargetFormat.format(simpleDateObject);
            folderDateFormat = new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
//                System.out.println(date1.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String pathWithDate = path + "/" + folderDateFormat;
        makeFolderIfNotExists(pathWithDate);
        //ImageObject imageObject = objectMapper.readValue(url, ImageObject.class);
        for (Epic imageObject : imageObjects) {
            String urlImage = new UrlBuilder().setBaseUrl("https://api.nasa.gov/EPIC/archive/natural/").
                setDate(urlFormattedDate).
                setImageName(imageObject.getImage()).
                setKey(key).
                buildUrlToGetImage();
            shellHelper.printInfo(urlImage);
            try {
                saveImage(urlImage, pathWithDate + "/" + imageObject.getImage() + ".jpg");
            } catch (IOException e) {
                shellHelper.printError(e.getMessage());
                return;
            }
            shellHelper.printSuccess("Saved : " + imageObject.getImage());

        }


        String output = shellHelper.getSuccessMessage("Finished");
        output.concat("The script has finished");
    }

    /**
     * @param path
     */
    private void makeFolderIfNotExists(String path) {
        File theDir = new File(path);
        if (!theDir.exists()) {

            shellHelper.printInfo("Folder was created on path : " + path);
            theDir.mkdirs();
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

}
