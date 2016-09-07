package jp.cordea.retrofitmockdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.widget.ListView;

import jp.cordea.retrofitmockdemo.api.AtndClient;
import jp.cordea.retrofitmockdemo.api.response.Event;
import jp.cordea.retrofitmockdemo.api.response.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yoshihiro Tanaka on 16/05/18.
 */
public class MainViewModel extends BaseObservable {

    private ObservableArrayList<Event> events = new ObservableArrayList<>();

    public ObservableArrayList<Event> getEvents() {
        return events;
    }

    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private boolean isLoading;

    @Bindable
    public boolean getIsLoading() {
        return isLoading;
    }

    private void setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
        notifyPropertyChanged(jp.cordea.retrofitmockdemo.BR.isLoading);
    }

    public void onClickReal(View view) {
        setIsLoading(true);
        AtndClient.getAtndService()
                .getEvents(query, "json")
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        events.clear();
                        events.addAll(response.body().getEvents());
                        setIsLoading(false);
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        query = t.getLocalizedMessage();
                        setIsLoading(false);
                    }
                });
    }

    public void onClickMock(View view) {
        setIsLoading(true);
        AtndClient.getMockAtndService()
                .getEvents(query, "json")
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        events.clear();
                        events.addAll(response.body().getEvents());
                        setIsLoading(false);
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        query = t.getLocalizedMessage();
                        setIsLoading(false);
                    }
                });
    }

    @BindingAdapter("items")
    public static void bindItems(ListView view, ObservableArrayList<Event> events) {
        if (view.getAdapter() != null) {
            ((MainListAdapter) view.getAdapter()).refreshItems(events);
            return;
        }
        MainListAdapter adapter = new MainListAdapter(view.getContext(), R.layout.list_item_main, events);
        view.setAdapter(adapter);
    }


}
