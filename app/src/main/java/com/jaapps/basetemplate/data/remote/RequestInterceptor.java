package com.jaapps.basetemplate.data.remote;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by joaoalves on 30/05/16.
 */

public class RequestInterceptor implements Interceptor {

//    private final static String HEADER_FIELD = "xxxxxxx";

    @Override
    public Response intercept(Chain chain) throws IOException {

        final HttpUrl modifiedUrl = chain
                .request()
                .url()
                .newBuilder()
//                .addQueryParameter("header_field", HEADER_FIELD)
                .build();

        final Request request = chain
                .request()
                .newBuilder()
                .url(modifiedUrl)
                .build();

        return chain.proceed(request);
    }
}
