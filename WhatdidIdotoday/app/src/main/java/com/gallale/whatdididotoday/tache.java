package com.gallale.whatdididotoday;

public class tache {
    private String valueTxt;
    private int valueImg;
    private int valueDay;

    public tache(){
    }

    public String getValueTxt() {
        return valueTxt;
    }

    public void setValueTxt(String valueTxt) {
        this.valueTxt = valueTxt;
    }

    public int getValueImg() {
        return valueImg;
    }

    public void setValueImg(int valueImg) {
        this.valueImg = valueImg;
    }

    public int getValueDay() {
        return valueDay;
    }

    public void setValueDay(int valueDay) {
        this.valueDay = valueDay;
    }


    public tache(String valueTxt, int valueImg, int valueDay){
        this.valueTxt = valueTxt;
        this.valueImg = valueImg;
        this.valueDay = valueDay;
    }
}

