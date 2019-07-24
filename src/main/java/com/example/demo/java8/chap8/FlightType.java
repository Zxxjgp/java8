package com.example.demo.java8.chap8;

public enum FlightType {

    OW(1, "单程"), RT(2, "往返");

    public Integer code;
    public String desc;

    FlightType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static boolean getTypeByCode(Integer code) {
      /*  FlightType defaultType = FlightType.OW;
        for (FlightType ftype : FlightType.values()) {
            if (ftype.code == code) {
                return ftype;
            }
        }*/
        return true;
    }
}