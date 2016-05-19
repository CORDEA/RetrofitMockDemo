package jp.cordea.retrofitmockdemo;

import jp.cordea.retrofitmockdemo.api.response.Detail;
import jp.cordea.retrofitmockdemo.api.response.Event;

/**
 * Created by Yoshihiro Tanaka on 16/05/19.
 */
public class MainListItemViewModel {

    private String title;

    private String desc;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public MainListItemViewModel(Event event) {
        Detail detail = event.getEvent();
        title = detail.getTitle();
        desc = detail.getPlace();
    }
}
