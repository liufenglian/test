package hash;

public class TestHashMap {

    public static void main(String[] args) {
        Map<String,Integer>map = new HashMap<String,Integer>();
        for (int i = 0;i<10000;i++){
            map.put(""+i,i);
        }
    }
}
