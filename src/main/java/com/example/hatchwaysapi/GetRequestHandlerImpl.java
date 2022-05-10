package com.example.hatchwaysapi;

import com.example.hatchwaysapi.SortStrategy.Sorter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.Produces;
import java.io.IOException;

public class GetRequestHandlerImpl implements GetRequestHandler {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * Returns a query in json format given a tag.
     *
     * @param tag is mandatory, sortType and dir have provided default value if one is not given in uri
     * @return
     */
    @Produces("application/json")

    @Override
    public JSONObject getJSONFromAPI(String tag, String sortType, String dir) throws IOException, ParseException {//?tag=
        if ((sortType.equals("id")) || (sortType.equals("reads")) || (sortType.equals("likes")) || (sortType.equals("popularity"))) {
            if ((dir.equals("asc")) || (dir.equals("desc"))) {
                String appendedTag = "?tag=" + tag;
                String urlStr = "https://api.hatchways.io/assessment/blog/posts" + appendedTag; //+ appendedSort + appendedDir;
                HttpGet request = new HttpGet(urlStr);
                request.addHeader("tag", tag);

                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();

                String result = EntityUtils.toString(entity);
                if (result.contains("{\"posts\":[]}")) {
                    JSONObject errorResponse = new JSONObject();
                    errorResponse.put("error", "Tags parameter is required");
                    return errorResponse;
                }
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(result);

                //If optional query parameters are default  return json (no sorting needed)
                if (sortType.contains("id") && dir.contains("asc")) {
                    return json;
                }
                JSONArray jsonArr = (JSONArray) json.get("posts");//Create JSONArray for sorting
                json = new JSONObject();//Reset json
                Sorter sorter = new Sorter(sortType, dir, jsonArr);

                json.put("posts", sorter.jsonList);
                return json;
            } else {
                JSONObject errorResponse = new JSONObject();
                errorResponse.put("error", "direction parameter is invalid");
                return errorResponse;
            }
        } else {
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("error", "sortBy parameter is invalid");
            return errorResponse;
        }

    }


}
