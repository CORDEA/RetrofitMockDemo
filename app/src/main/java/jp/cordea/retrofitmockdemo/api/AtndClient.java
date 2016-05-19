package jp.cordea.retrofitmockdemo.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jp.cordea.retrofitmockdemo.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by Yoshihiro Tanaka on 16/05/18.
 */
public class AtndClient {

    private static Gson gson =
            new GsonBuilder().create();

    private static Retrofit retrofit =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .build();

    private static MockRetrofit mockRetrofit =
            new MockRetrofit.Builder(retrofit)
                    .networkBehavior(NetworkBehavior.create())
                    .build();

    public static AtndService getAtndService() {
        return retrofit.create(AtndService.class);
    }

    public static MockAtndService getMockAtndService() {
        return new MockAtndService(mockRetrofit.create(AtndService.class));
    }

}
