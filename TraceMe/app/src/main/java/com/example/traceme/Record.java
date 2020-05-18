package com.example.traceme;

public class Record {
    private int id;
    private String date;
    private String time;
    private float temperature;
    private int wellness;
    private String signs;

    public Record() {
    }

    public Record(int id, String date, String time, float temperature, int wellness, String signs) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.wellness = wellness;
        this.signs = signs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date) {
         this.date = date;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getWellness() {
        return wellness;
    }

    public void setWellness(int wellness) {
        this.wellness = wellness;
    }

    public String getSigns(){
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    @Override
    public String toString() {
        String wellstring = new String();
        String signsstring = new String();
        if(wellness==1){
            wellstring = "Yes";
        }else{
            wellstring = "No";
        }
        if(signs.length()==0){
            signsstring = "NA";
        }else{
            signsstring = signs.substring(0,signs.length()-2);
        }


        return "Date: " + date + ", Time:  " + time + ", Temperature: " + temperature +", Feeling well: "
                + wellstring +", Signs and Symptoms: " + signsstring;
    }

}
