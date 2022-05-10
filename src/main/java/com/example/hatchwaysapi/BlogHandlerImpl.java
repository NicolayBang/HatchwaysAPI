package com.example.hatchwaysapi;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;


public class BlogHandlerImpl extends Thread implements RestListener {

    private final GetRequestHandlerImpl getHandler = new GetRequestHandlerImpl();

    /**
     * Gets JSON file from hatchways API by tag.
     *
     * @param uriInfo
     * @return
     * @throws IOException
     */
    public Response getByKey(@Context UriInfo uriInfo) throws IOException, ParseException {
        MultivaluedMap<String, String> qParams = uriInfo.getQueryParameters();
        String tag = qParams.getFirst("tag");
        String sortBy = qParams.getFirst("sortBy");
        String direction = qParams.getFirst("direction");

        if (sortBy == null) {//Setting default values if none are provided
            sortBy = "id";
        }
        if (direction == null) {
            direction = "asc";
        }

        JSONObject jsonObject = getHandler.getJSONFromAPI(tag, sortBy, direction);
        if (jsonObject.containsKey("error")) {
            return Response.status(400).entity(jsonObject).build();
        }
        return Response.status(200).entity(jsonObject).build();
    }

    public JSONObject getPing() {
        JSONObject errorResponse = new JSONObject();
        errorResponse.put("success", true);
        return errorResponse;
    }

    @Override
    public void run() {

    }


}


