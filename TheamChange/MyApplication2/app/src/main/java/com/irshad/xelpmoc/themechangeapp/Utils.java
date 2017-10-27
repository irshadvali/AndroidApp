package com.irshad.xelpmoc.themechangeapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Irshad on 25/03/17.
 */

public class Utils {
    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_WHITE = 1;
    public final static int THEME_BLUE = 2;
    public final static int THEME_ORANGE = 3;
    public  static int backgroundcolor;
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.FirstTheme);
                backgroundcolor=0xFFFF4081;
                break;
            case THEME_WHITE:
                activity.setTheme(R.style.SecondTheme);
                backgroundcolor=0xFF00FF00;
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.Thirdheme);
                backgroundcolor=0xFF0000F0;
                break;
            case THEME_ORANGE:
                activity.setTheme(R.style.FourthTheme);
                backgroundcolor= 0xFFf07400;
                break;
        }
    }
}
