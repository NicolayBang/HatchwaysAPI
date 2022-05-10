package com.example.hatchwaysapi;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.cache.annotation.Cacheable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * Singleteon class that will handle all threads
 */
@org.springframework.web.bind.annotation.RestController
public class RestAPIController implements RestListener, BlogHandler {

    @Override
    @Path("/posts")
    @Cacheable(value = "posts")
    @GET
    @Produces({"application/json"})
    public Response getResponse(@Context UriInfo uriInfo) throws IOException, ParseException {
        BlogHandlerImpl thread = new BlogHandlerImpl();
        thread.start();
        return thread.getByKey(uriInfo);
    }

    @Override
    public JSONObject getPing() {
        BlogHandlerImpl thread = new BlogHandlerImpl();
        thread.start();
        return thread.getPing();
    }
}
