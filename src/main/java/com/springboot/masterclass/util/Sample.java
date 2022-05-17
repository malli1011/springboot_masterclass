package com.springboot.masterclass.util;

public class Sample {

    public String checkStingType(String str) {
        if (str == null) {
            return "normal";
        }
        switch (str.length()) {
            case 1:
                return "short";
            case 10:
                return "long";
            default:
                return "normal";
        }
    }


}
