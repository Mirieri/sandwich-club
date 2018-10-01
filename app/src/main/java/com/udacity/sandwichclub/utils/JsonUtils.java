package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            //Convert java object to JSON
            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList =  new ArrayList<>();
            for (int i=0; i<alsoKnownAs.length();i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            //other atributes
            String placeOforigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String image = root.getString("image");
            JSONArray ingredients = root.getJSONArray("ingredients");
            ArrayList<String> ingredienstList = new ArrayList<>();
            for(int i=0; i<ingredients.length();i++){
                ingredienstList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName,alsoKnownAsList,placeOforigin,description,image,ingredienstList);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
