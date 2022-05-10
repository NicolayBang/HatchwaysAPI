package com.example.hatchwaysapi;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingTest {

    @Test
    void testPing() {
        RestAPIController restAPIController = new RestAPIController();
        JSONObject pingMsg = new JSONObject();
        pingMsg.put("success", true);
        assertEquals(restAPIController.getPing(), pingMsg);
        restAPIController.getPing();

    }
}
