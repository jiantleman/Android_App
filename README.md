# MyHealth Application

 1. [Introduction](#intro)
 2. [Application Layout](#app)
 3. [Demonstration](#demo)
 4. [Discussion](#disc)
 5. [References](#ref)

## Introduction <a name="intro"></a>
This application is created as part of the [Build Your First Android App (Project-Centered Course)](https://www.coursera.org/learn/android-app) offered by CentraleSupélec through Coursera. Through the course, I learnt how to design and build an Android application with basic elements and functionalities using the Android Studio IDE.

While the course only equipped me with basic app development skills, I still wanted to build an app that would have a practical and meaningful application. I had earlier taken a public health course, [COVID-19 Contact Tracing](https://www.coursera.org/learn/covid-19-contact-tracing), taught by Johns Hopkins University, where I learnt about the basics of COVID-19 and the process of contact tracing. As a part of contact tracing, the public health authorities have to regularly check-in with cases and their contacts during the period of their isolation and quarantine. This gave me the idea to create an app to allow cases and contacts to update their health details, get information on the disease and quickly get help, thereby reducing the manpower needed to monitor and support them.

In this project, I also integrated my knowledge of databases and SQL obtained from IBM's [Databases and SQL for Data Science](https://www.coursera.org/learn/sql-data-science) course. I used an SQLite database to store and persist the health data on the device locally.

## Application Layout <a name="app"></a>
### Main Activity
This is the main activity of the application, with four buttons that launch a different activity each.
<p align="center">
<img src="https://github.com/jiantleman/Android_App/blob/master/media/main.png?raw=true" width="250" />
</p>

### Update Health Information Activity
This is the activity where users can update their health information. They can select the date and time using a picker. If they select the "I feel unwell" option, a series of checkboxes with the common signs and symptoms of COVID-19 appear.
<p align="center">
<img src="https://github.com/jiantleman/Android_App/blob/master/media/newHealth.png?raw=true="250" />
<img src="https://github.com/jiantleman/Android_App/blob/master/media/newHealth_selectTime.png?raw=true="250" />
<img src="https://github.com/jiantleman/Android_App/blob/master/media/newHealth_selectSigns.png?raw=true="250" />
</p>

## Demonstration <a name="demo"></a>
The following gif shows a full demonstration of the application features:
<p align="center">
<img src="https://github.com/jiantleman/Android_App/blob/master/demonstration.gif?raw=true" width="300"/>

</p>

## Discussion <a name="disc"></a>
This application is not intended to fully functional, but more of a proof-of-concept to demonstrate how a mobile application can assist in contact tracing efforts. Other further extensions that can explored to make this application more functional include:

 * The use of a cloud-based SQL database instead of a local database, such that the public health authorities would be able to retrieve the information submitted by the cases and contacts. 
 * Functionality to allow the public health authorities to send reminders to users to update their health information periodically.
 * Secure authentication procedure and encryption of health information to ensure privacy and confidentiality. 

## References <a name="ref"></a>

 1. [Sylvain Saurel](https://medium.com/@ssaurel/learn-to-save-data-with-sqlite-on-android-b11a8f7718d3) provided the implementation of the `SQLiteOpenHelper` extended class.
 2. [Tutlane](https://www.tutlane.com/tutorial/android/android-timepicker-with-examples) provided the implementation to show a `TimePickerDialogue` and `DatePickerDialogue` when a `TextView` is clicked.