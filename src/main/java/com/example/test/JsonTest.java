package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.Feature;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        String str = "{ \"លេខបុងបញ្ញើ\": \"billCode\", \"ជូនដំណឹងដល់សាខា\": \"notifySiteCode\", \"ប្រភេទទំនិញមានបញ្ហា\": \"type1\", \"មូលហេតុនៃទំនិញមានបញ្ហា\": \"type2\", \"បញ្ជាក់មូលហេតុ\": \"reason\"}";
        LinkedHashMap<String, String> maps =   JSON.parseObject(str, LinkedHashMap.class, Feature.OrderedField);
        LinkedHashMap<String, String> rest = new LinkedHashMap<String, String>();
        for(Map.Entry<String,String> vo:maps.entrySet()){
            rest.put(vo.getValue(),vo.getKey());
        }
        JSONArray jArray = new JSONArray();
        jArray.add(rest);
        String r = jArray.toString();
        System.out.println(r);

    }
}
