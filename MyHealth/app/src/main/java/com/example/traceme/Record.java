package com.example.traceme;

/**
 * The Record class encapsulates all the information contained in a health record. It provides
 * setter and getter functions to update the attributes.
 */

public class Record {
    private int id;
    private String date;
    private String time;
    private float temperature;
    private int wellness;
    private String signs;

    /**
     * Constructor without attribute parameters
     */
    Record() {
    }

    /**
     * Constructor with attribute parameters
     * @param id id of the record
     * @param date date string
     * @param time time string
     * @param temperature temperature float
     * @param wellness 1 if the user is well, 0 otherwise
     * @param signs string of signs and symptoms
     */
    public Record(int id, String date, String time, float temperature, int wellness, String signs) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.wellness = wellness;
        this.signs = signs;
    }

    /**
     * @return Record's ID
     */
    int getId() {
        return id;
    }

    /**
     * Set id attribute
     * @param id ID of the record
     */
    void setId(int id) {
        this.id = id;
    }
    /**
     * @return Record's date
     */
    String getDate(){
        return date;
    }
    /**
     * Set date attribute
     * @param date date string
     */
    void setDate(String date) {
         this.date = date;
    }
    /**
     * @return Record's time
     */
    String getTime(){
        return time;
    }
    /**
     * Set time attribute
     * @param time time string
     */
    void setTime(String time) {
        this.time = time;
    }
    /**
     * @return Record's temperature
     */
    float getTemperature() {
        return temperature;
    }
    /**
     * Set temperature attribute
     * @param temperature temperature float
     */
    void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    /**
     * @return Record's wellness (1 if well, 0 is unwell)
     */
    int getWellness() {
        return wellness;
    }
    /**
     * Set wellness attribute
     * @param wellness 1 if the user is well, 0 otherwise
     */
    void setWellness(int wellness) {
        this.wellness = wellness;
    }
    /**
     * @return Record's signs
     */
    String getSigns(){
        return signs;
    }
    /**
     * Set signs attribute
     * @param signs String of signs and symptoms
     */
    void setSigns(String signs) {
        this.signs = signs;
    }

    /**
     * Custom toString method that produces a string containing all the information about the record
     * @return
     */

    @Override
    public String toString() {
        String wellString;
        String signsString;
        /**
         * If wellness = 1, the user is well
         * If wellness = 0, the user is unwell
         */
        if(wellness==1) wellString = "Yes";
        else wellString = "No";
        /**
         * Display NA if there are no signs
         */
        if(signs.length()==0) signsString = "NA";
        else signsString = signs;

        /**
         * Concatenate strings containing record details together
         */
        return "Date: " + date + "\nTime: " + time + "\nTemperature: " + temperature +"\nFeeling well: "
                + wellString +"\nSigns and Symptoms: " + signsString;
    }

}
