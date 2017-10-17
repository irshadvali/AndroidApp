package com.irshad.uiretrofitapp;

import static com.facebook.FacebookSdk.getApplicationContext;


public class PrintO {
    public static void log(String msg) {
        System.out.println(getApplicationContext().getClass().getName() + ":" + msg);
    }
}
