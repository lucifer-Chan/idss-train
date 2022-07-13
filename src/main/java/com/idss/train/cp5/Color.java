package com.idss.train.cp5;

/**
 * @author lucifer.chan
 * @create 2022-07-13 6:31 PM
 **/
public enum Color {

    RED(1, "红色") ,

    GREEN(2, "绿色");


    public final int code;

    public final String description;

    Color(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Color resolve(int code) {
        for (Color color : values()) {
            if(color.code == code ) {
                return color;
            }
        }

        return null;
    }


    public static Color valueOf(int code) {
        Color status = resolve(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        } else {
            return status;
        }
    }


}
