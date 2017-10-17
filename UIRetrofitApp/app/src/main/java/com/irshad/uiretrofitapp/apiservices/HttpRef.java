package com.irshad.uiretrofitapp.apiservices;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irshadvali on 27/11/16.
 */

public class HttpRef {
    public final static String domain = "http://www.google.com/beta/apis/";
    public final static String path = ":3000/";
    public static OkHttpClient okClient = new OkHttpClient.Builder()

            .addInterceptor(
                    new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();

                            // Request customization: add request headers
                            Request.Builder requestBuilder = original.newBuilder().method(original.method(), original.body());

                            Request request = requestBuilder.build();
                            System.out.println("GET CALLS : "+chain.request().url().toString());
//                           System.out.println("Request__: "+request.headers().toString()+" : "+request.body().toString()+" : " +chain.request().headers().toString()+" : "+chain.request().body().toString());
                            return chain.proceed(request);
                        }
                    })
            .build();

    public static Retrofit builder = new Retrofit.Builder().
            baseUrl(domain).addConverterFactory(GsonConverterFactory.create()).client(okClient).build();
    public static ApiService createService(){
        return builder.create(ApiService.class);
    }



}
