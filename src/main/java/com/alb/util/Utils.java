package com.alb.util;

public class Utils {

    public static String extractIdFromURL(String url) {
        String[] out = url.split("/");
        return out[out.length - 1];

    }


}
