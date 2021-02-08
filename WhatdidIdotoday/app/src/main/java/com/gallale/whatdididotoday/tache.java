package com.gallale.whatdididotoday;

public class tache {
    private String valueTxt;
    private int valueImg;

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

    public tache(String valueTxt, int valueImg){
        this.valueTxt = valueTxt;
        this.valueImg = valueImg;
    }
}

