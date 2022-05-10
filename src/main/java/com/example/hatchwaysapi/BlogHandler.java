package com.example.hatchwaysapi;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;


@Path("/api")
public interface BlogHandler {


    @Path("/posts")
    @GET
    @Produces({"application/json"})
    Response getResponse(@Context UriInfo uriInfo) throws IOException, ParseException;


    @Path("/ping")
    @GET
    @Produces({"application/json"})
    JSONObject getPing();


}
