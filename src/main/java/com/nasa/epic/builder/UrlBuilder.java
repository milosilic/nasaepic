package com.nasa.epic.builder;


public class UrlBuilder {

    private String baseUrl;
    private String date;
    private String imageName;
    private String key;

    public UrlBuilder setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public UrlBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public UrlBuilder setImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    public UrlBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public String buildUrlToGetImage()  {
        return  baseUrl + date + "/jpg/" + imageName +".jpg?api_key="+ key;
    }

    public String buildUrlNoDate() {
        return "";
        //return  "https://api.nasa.gov/EPIC/archive/natural/" + formatedDate + "/jpg/" + imageObject.getImage()+".jpg?api_key="+ key;
    }


    /**
     *
     * @return
     */
    public String buildUrl() {
        return baseUrl + date + "?api_key=" + key;
    }

    /**
     *
     * @return
     */
    public String buildUrlWithoutDate() {
        return "https://api.nasa.gov/EPIC/api/natural?api_key=" + key;
    }
}
