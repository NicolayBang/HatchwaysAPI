package com.example.hatchwaysapi;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class GetRequestHandlerImplTest {
    GetRequestHandlerImpl    getRequestHandler = new GetRequestHandlerImpl();
    /**
     * Test if the get request to external API is working properly.
     * Checks if the returned requests contain the tag "tech", "health" & "history" when a
     * get with those tags are made. Also testing if method returns error JSON if no tag entered as param.
     * TODO put in for loop to check every json element, check as string array
     */

    @Test
    void testGetJSONFromAPI() throws IOException, ParseException {
        String compareTo = "tech";
        String compareTo2 = "health";
        String compareTo3 = "history";
        String compareTo4 = "{\"error\":\"The tag parameter is required\"}";
        System.out.println(getRequestHandler.getJSONFromAPI("tech", "","").toString());
        assert getRequestHandler.getJSONFromAPI("tech", "","").toString().contains(compareTo);
        assert getRequestHandler.getJSONFromAPI("health","","").toString().contains(compareTo2);
        assert getRequestHandler.getJSONFromAPI("history","","").toString().contains(compareTo3);
        assert getRequestHandler.getJSONFromAPI("","","").toString().contains(compareTo4);

    }

    @Test
    void testConcurrentRequests() {
        for(int i=0; i<10;i++){

        }
    }


}
