package ua.lviv.navpil;

import javax.json.Json;
import javax.json.JsonObject;

public class TestJsonNull {

    public static void main(String[] args) {

        JsonObject appID = Json.createObjectBuilder()
                .add("AppID", (String) null)
                .build();

        System.out.println(appID.toString());

    }
}
