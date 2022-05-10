package com.example.hatchwaysapi;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testErrorMsg {
    /**
     * Test with invalid sortBy parameter
     *
     * @throws IOException
     */
    @Test
    void testSortError() throws IOException {
        String jsonMimeType = "HTTP/1.1 400";
        HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=history&sortBy=fdfd");//try with invalid sort parameter
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = response.toString();


        assertTrue(mimeType.contains(jsonMimeType));

    }

    /**
     * Test with no tag parameter
     *
     * @throws IOException
     */
    @Test
    void testNoTagError() throws IOException {
        String jsonMimeType = "HTTP/1.1 400";
        HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?&sortBy=asc");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = response.toString();


        assertTrue(mimeType.contains(jsonMimeType));

    }

    /**
     * Test with invalid tag parameter
     *
     * @throws IOException
     */
    @Test
    void testInvalidTagError() throws IOException {
        String jsonMimeType = "HTTP/1.1 400";
        HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=tdss&sortBy=asc");//try with invalid tag parameter
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = response.toString();


        assertTrue(mimeType.contains(jsonMimeType));

    }

    /**
     * Test with invalid direction parameter
     *
     * @throws IOException
     */
    @Test
    void testDirectionError() throws IOException {
        String jsonMimeType = "HTTP/1.1 400";
        HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=history&sortBy=likes&direction=sda");//try with invalid sort parameter
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = response.toString();


        assertTrue(mimeType.contains(jsonMimeType));

    }
}