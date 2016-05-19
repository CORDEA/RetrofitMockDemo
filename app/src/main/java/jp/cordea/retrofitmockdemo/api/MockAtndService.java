package jp.cordea.retrofitmockdemo.api;

import java.util.ArrayList;
import java.util.List;

import jp.cordea.retrofitmockdemo.api.response.Detail;
import jp.cordea.retrofitmockdemo.api.response.Event;
import jp.cordea.retrofitmockdemo.api.response.Result;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.mock.BehaviorDelegate;

/**
 * Created by Yoshihiro Tanaka on 16/05/18.
 */
public class MockAtndService implements AtndService {

    private BehaviorDelegate<AtndService> delegate;

    public MockAtndService(BehaviorDelegate<AtndService> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<Result> getEvents(@Path("keyword") String keyword, @Path("format") String format) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Detail detail = new Detail(1, keyword + ":" + i, "catch", "description",
                    "https://google.com", "startedAt", "endedAt",
                    "https://google.com", 1, "address", "place:" + i, "1", "1", 1,
                    "cordea", "cordea", 1, 1, "updatedAt");
            Event event = new Event(detail);
            events.add(event);
        }
        Result result = new Result(1, 1, events);
        return delegate.returningResponse(result).getEvents(keyword, format);
    }
}
