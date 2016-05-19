package jp.cordea.retrofitmockdemo.api.response;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoshihiro Tanaka on 16/05/19.
 */
@Getter
@AllArgsConstructor
public class Detail {

    @SerializedName("event_id")
    int eventId;

    String title;

    @SerializedName("catch")
    String catchText;


    String description;

    @SerializedName("event_url")
    String eventUrl;

    @SerializedName("started_at")
    String startedAt;

    @SerializedName("ended_at")
    String endedAt;

    String url;

    int limit;

    String address;

    String place;

    String lat;

    String lon;

    @SerializedName("owner_id")
    int ownerId;

    @SerializedName("owner_nickname")
    String ownerNickname;

    @SerializedName("owner_twitter_id")
    String ownerTwitterId;

    int accepted;

    int waiting;

    @SerializedName("updated_at")
    String updatedAt;
}
