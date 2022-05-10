package com.example.hatchwaysapi;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests multiThreading. Each instance of this test will test 4 GET cases 100 times. To test concurrent execution, allow for multiple instances of this class.
 * Was tested with 16 instances.
 */
public class StressTest extends Thread {

    @Override
    public void run() {

    }

    @Test
    void testTagPoliticsSortByLikesAscOrder() throws IOException {

        for (int i = 0; i < 100; i++) {
            String jsonMimeType = "HTTP/1.1 200";
            HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=politics&sortBy=likes&direction=asc");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            String mimeType = response.toString();


            assertTrue(mimeType.contains(jsonMimeType));

        }

    }

    @Test
    void testTagHistorySortByReadsAscOrder() throws IOException {
        for (int i = 0; i < 100; i++) {
            String jsonMimeType = "HTTP/1.1 200";
            HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=history&sortBy=reads&direction=asc");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            String mimeType = response.toString();
            assertTrue(mimeType.contains(jsonMimeType));

        }
    }

    @Test
    void testTagTechSortByPopularity() throws IOException {
        for (int i = 0; i < 100; i++) {
            String jsonMimeType = "HTTP/1.1 200";
            HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=tech&sortBy=popularity");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            String mimeType = response.toString();
            assertTrue(mimeType.contains(jsonMimeType));

        }
    }

    @Test
    void testTagHealthAscOrder() throws IOException {
        for (int i = 0; i < 100; i++) {
            String jsonMimeType = "HTTP/1.1 200";
            HttpUriRequest request = new HttpGet("http://localhost:8080/hatchways/services/api/posts?tag=health&&direction=asc");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            String mimeType = response.toString();
            assertTrue(mimeType.contains(jsonMimeType));

        }
    }


}
