package com.teaching.myyelp;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YelpClient {

    OkHttpClient httpClient =  new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @NonNull
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    return chain.proceed((chain.request())
                            .newBuilder()
                            .addHeader("Authorization", "Bearer 1Iz6sTjIebySrHTzRGUPLeuuXLI6AB104iJOA0LWQWGqoNng-2gmp5LSDK4UGKVfDW6dGaIcOo6h3FGnACN_yPdqEA_M3tq4PoDF4vspYtG5M1fqHGfGmeZjEtepYnYx")
                            .build());
                }
            }).build();

    public YelpAPI build() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.yelp.com/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(YelpAPI.class);
    }
}
