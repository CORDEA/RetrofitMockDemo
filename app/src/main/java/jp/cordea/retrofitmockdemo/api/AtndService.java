package jp.cordea.retrofitmockdemo.api;

import jp.cordea.retrofitmockdemo.api.response.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Yoshihiro Tanaka on 16/05/18.
 */
public interface AtndService {

    @GET("/events")
    Call<Result> getEvents(
            @Query("keyword") String keyword,
            @Query("format") String format);

}
