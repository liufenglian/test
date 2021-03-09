package oom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeapOOM {
    static  class  OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());

            HashMap<String,String> map = new HashMap<>();
        }
    }
}
