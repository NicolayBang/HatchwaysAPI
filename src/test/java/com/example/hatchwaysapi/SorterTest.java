package com.example.hatchwaysapi;

import com.example.hatchwaysapi.SortStrategy.Sorter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SorterTest {
    private GetRequestHandlerImpl getRequestHandler = new GetRequestHandlerImpl();


    /**
     * Testing if the JSONArray is added to the jsonList properly and if the given key is accessible
     */
    @Test
    public void testJsonToStringArr() throws IOException, ParseException {

        JSONObject jsonObject =  getRequestHandler.getJSONFromAPI("tech", "popularity","");
        System.out.println("XXX"+jsonObject);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        Sorter sorter = new Sorter("popularity","desc", jsonArray);
//        sorter.jsonToList();

        for (JSONObject json:
             sorter.jsonList) {
            System.out.println("XXX"+json);
        }

        for(int i = 0; i<10;i++){
            System.out.println("ID :"+sorter.jsonList.get(i).get("id"));
            System.out.println("Reads : "+sorter.jsonList.get(i).get("reads"));
            System.out.println("Popularity : "+sorter.jsonList.get(i).get("popularity"));
            System.out.println("Likes : "+sorter.jsonList.get(i).get("likes"));
        }


//        for(int i=0; i<sorter.jsonArray.size();i++) {
//
//        }
    }
}
