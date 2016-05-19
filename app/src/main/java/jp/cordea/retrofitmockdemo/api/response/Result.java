package jp.cordea.retrofitmockdemo.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Yoshihiro Tanaka on 16/05/18.
 */
@Getter
@ToString
@AllArgsConstructor
public class Result {

    @SerializedName("results_returned")
    private int resultsReturned;

    @SerializedName("results_start")
    private int resultsStart;

    private List<Event> events;
}
