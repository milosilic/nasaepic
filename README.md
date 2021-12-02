# NASA EPIC API
The EPIC API provides information on the daily imagery collected by DSCOVR's Earth Polychromatic Imaging Camera (EPIC) instrument. Uniquely positioned at the Earth-Sun Lagrange point, EPIC provides full disc imagery of the Earth and captures unique perspectives of certain astronomical events such as lunar transits using a 2048x2048 pixel CCD (Charge Coupled Device) detector coupled to a 30-cm aperture Cassegrain telescope.

Image metadata and key information are provided by the JSON API and can be requested by date and for the most recent available date. A listing of all available dates can also be retrieved via the API for more granular control.

Development of the EPIC API began in 2015, and is supported by the web development team for the Laboratory for Atmospheres in the Earth Sciences Division of the Goddard Space Flight Center. More information regarding the API and retrieval of the imagery for download can be found on the EPIC website.

Retrievable Metadata
The following information is available for every image in the collection:

 - Image [name]
 - Date
 - Caption
 - centroid_coordinates
 - dscovr_j2000_position
 - lunar_j2000_position
 - sun_j2000_position
 - attitude_quaternions

## SpringShell NASA API EPIC CLI Demo

The shell program  retrieves all images of a given day from the NASA EPIC API and add
them to a given folder.

A subfolder (of target folder) per date shall be created to store the images in it.

## How to use this repository?

```
./gradlew clean build

java -jar build/libs/nasa-api-0.0.1-SNAPSHOT.jar

```

```

nasa-api:>help get-image



NAME
	get-image - Retrieve images from NASA API

SYNOPSYS
	get-image [-K] string  [-P] string  [[--date] string]  

OPTIONS
	-K or --key  string
		
		[Mandatory]

	-P or --path  string
		
		[Mandatory]

	--date  string
		
		[Optional, default = <none>]

 

```

## Examples :

Invocation of the command without date parameter will result in fetching images of the last available day.
So for instance, if we execute  the following command on the 2nd December 2021:  
```
nasa-api:>get-image -K DEMO_KEY -P nasa_images
```

The following images would be downloaded to the folder on path specified with argument -P or --path:  
```
images/
└── 20211130
    ├── epic_1b_20211130003633.jpg
    ├── epic_1b_20211130022436.jpg
    ├── epic_1b_20211130041238.jpg
    ├── epic_1b_20211130060040.jpg
    ├── epic_1b_20211130074843.jpg
    ├── epic_1b_20211130093645.jpg
    ├── epic_1b_20211130112448.jpg
    ├── epic_1b_20211130131250.jpg
    └── epic_1b_20211130150053.jpg
```

If we would like to download all images on specific date, for instance on October 10th 2021. 

```

nasa-api:>get-image -K DEMO_KEY -P images --date 2021-10-01
```
Invocation of the previous command would  download the following images: 
```
images/
└── 20211001
    ├── epic_1b_20211001002713.jpg
    ├── epic_1b_20211001040318.jpg
    ├── epic_1b_20211001055120.jpg
    ├── epic_1b_20211001073923.jpg
    ├── epic_1b_20211001092726.jpg
    ├── epic_1b_20211001111528.jpg
    ├── epic_1b_20211001130331.jpg
    ├── epic_1b_20211001145133.jpg
    ├── epic_1b_20211001163936.jpg
    ├── epic_1b_20211001182739.jpg
    ├── epic_1b_20211001201541.jpg
    └── epic_1b_20211001220344.jpg
```


