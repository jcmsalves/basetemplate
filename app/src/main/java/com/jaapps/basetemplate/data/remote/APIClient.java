package com.jaapps.basetemplate.data.remote;

/**
 * Created by joso on 13/05/16.
 */

import com.jaapps.basetemplate.data.models.Sample;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Docs: http://square.github.io/retrofit/
 */
public interface APIClient {

    @GET("sample/{id}")
    Observable<Sample> getSample(@Path("id") int id);

}
