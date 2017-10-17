package com.irshad.uiretrofitapp.utils;
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by irshadvali on 08/02/17.
 */

public class PermissionSingleton {
    private static Context context = null;

    private  static LocationManager lm;

    public PermissionSingleton(Context context) {
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static void requestLocationPermission(final Context context) {
        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        // Permission handling for Below Marshmallow (< API 23)

        if (Build.VERSION.SDK_INT < 23) {
            if (!gps_enabled)
            {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("HomeHapp");
                builder.setMessage("Please enable location services!");
                builder.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        showSystemAlert(context);
                    }
                });

                builder.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Please enable location!", Toast.LENGTH_SHORT).show();
                        ((Activity) context).finish();
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        }

        // Permission handling for Marshmallow and above (>= API 23)
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
        }

    }

    @TargetApi(Build.VERSION_CODES.M)
    public static void showSystemAlert(Context context) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        context.startActivity(intent);

    }


    @TargetApi(Build.VERSION_CODES.M)
    public static void requestGalleryPermission(final Context context) {

        // Permission handling for Marshmallow and above (>= API 23)
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
        }

    }
    @TargetApi(Build.VERSION_CODES.M)
    public static void requestCameraPermission(final Context context){
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, 3);
        }
    }
}
