package com.example.hatchwaysapi.SortStrategy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Instanciated with proper parameter will sort according to sortType and direction param
 **/
public class Sorter {
    public JSONArray jsonArray;
    public ArrayList<JSONObject> jsonList = new ArrayList<>();
    private String sortType = null;
    private String dir = null;

    public Sorter(String sortType, String dir, JSONArray jsonArray) {
        this.sortType = sortType;
        this.jsonArray = jsonArray;
        this.dir = dir;
        jsonToList();//Send json to list for sorting


        Comparator<JSONObject> comparator = new Comparator<>() {


            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                Double d1 = Double.parseDouble(o1.get(sortType).toString());
                Double d2 = Double.parseDouble(o2.get(sortType).toString());
                if (sortType.contains("popularity")) {//multiply by 100 if too small for int casting precisely
                    d1 *= 100;
                    d2 *= 100;
                }
                return (int) (d1 - d2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        if (dir.contains("asc")) {
            jsonList.sort(comparator);
        } else {
            jsonList.sort(comparator.reversed());
        }

    }


    public void jsonToList() {
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonList.add((JSONObject) jsonArray.get(i));
        }
    }

}


