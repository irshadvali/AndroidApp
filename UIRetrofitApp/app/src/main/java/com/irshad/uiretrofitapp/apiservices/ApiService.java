package com.irshad.uiretrofitapp.apiservices;


import com.irshad.uiretrofitapp.model.NotificationModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irshadvali on 27/11/16.
 */

public interface ApiService {
    @GET("https://api.myjson.com/bins/vr5b")
    Call<NotificationModel> getNotification();

}
