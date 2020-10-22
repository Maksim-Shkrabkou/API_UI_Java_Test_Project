package com.socks.api.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

    private final String jsonPath;
    private final Matcher mather;

    @Override
    public void check(Response response) {
        response.then().assertThat().body(jsonPath, mather);
    }

    @Override
    public String toString() {
        return "body field [" + jsonPath + "]  " + mather;
    }
}
