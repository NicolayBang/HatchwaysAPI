package com.example.hatchwaysapi;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface GetRequestHandler {

    JSONObject getJSONFromAPI(String fieldAndValue, String sortType, String dir) throws IOException, ParseException;
}
