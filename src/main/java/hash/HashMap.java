package hash;


import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {

    /**
     * 默认数组长度
     */
    private int defaultLength;

    /**
     * 幕刃负载因子
     */
    private double defaultAddFactor;
    /**
     * 使用长度
     */
    private double userSize;

    /**
     * entry数组
     */
    Entry<K, V>[] entries;


    @Override
    public V put(K k, V v) {
        //判断是否需要扩容
        if(this.userSize>this.defaultAddFactor*this.defaultLength){
            rehash();
        }
        //计算出当前下标
        int index= this.getIndex(k,this.defaultLength);
        //获取下标上的entry
        Entry<K,V> entry = this.entries[index];

        //创建一个新的 entry
        Entry<K,V> newEntry = new Entry<K,V>(k,v,null);
        //判断当前下标是否被使用，如果没有被使用九江newEntry填入
        if(entry == null){
            this.entries[index] = newEntry;
            //使用长度+1
            this.userSize++;
        }else {
            Entry<K,V> e =entry;
            //判断当前的key是否等于传入的key
            if(e.getKey()==k){
                //如果相等就覆盖
                e.v=v;
            }else {
                //如果不相等就遍历entry
                while (e.next!=null){
                    //判断下一个entry的key是否等于传入的key，如果等于就赋值v
                    if(e.next.getKey()==k || e.next.getKey().equals(k)){
                        e.next.v = v;
                        break;
                    }else {
                        e = e.next;
                    }
                }
                //判断上边虚幻后的entry.next 是否等于null，如果等于null 将newEntry设置到entry.next位置
                if(e.next==null){
                    e.next=newEntry;
                }
            }
        }
        return newEntry.getValue();
    }

    @Override
    public V get(K k) {
        //获得下标
        int index = this.getIndex(k,this.defaultLength);

        //获得该下标的下的entry

        Entry<K,V> entry = this.entries[index];

        //如果该entry为空 返回空
        if(entry == null){
            return  null;
        }
        //如果不为空，遍历改entry
        while (entry != null){
            if(entry.getKey()==k ||entry.getKey().equals(k)){
                return entry.getValue();
            }else {
                entry = entry.next;
            }
        }
        return null;
    }

    /**
     * 有残构造。传入长度 defaultLength，负载因子：defaultAddFactor
     * */
    public HashMap(int defaultLength,double defaultAddFactor){
       if(defaultLength<0){
           throw new RuntimeException("数组长度错误");
       }
       if(defaultAddFactor<=0 || Double.isNaN(defaultAddFactor)){
           throw  new RuntimeException("负载因子错误");
       }
       this.defaultLength=defaultLength;
       this.defaultAddFactor = defaultAddFactor;
       entries = new Entry[this.defaultLength];
    }
    /**
    * 无参构造
    * */
    public HashMap(){
        this(16,0.75);
    }

    /***
     * 计算hashCode
     * */
    private int hash(int hashCode){
        hashCode = hashCode ^ ((hashCode>>>20) ^ (hashCode>>>12));
        return hashCode ^ ((hashCode>>>7) ^ (hashCode>>>4));
    }

    /**
     * 获取保存位置的下标
     * */
    private  int getIndex(K k , int length){
        int m = length - 1 ;
        int index = hash(k.hashCode()) & m;
        return index>0?index :-index;
    }

    /**
     * 扩容
     * */
    private void  rehash(){
        //创建一个新的Entry数组，长度是defaultLength的两倍
        System.out.println("hash扩容。。。。。");
        Entry<K,V>[] newEntryTable = new Entry[this.defaultLength*2];
        //创建一个新的list用来用entry
        List<Entry<K,V>> entryList = new ArrayList<>();
        //保存历史数据
        for(int i = 0 ; i<entries.length;i++){
            Entry<K,V> entry = entries[i];
            while (entry !=null){
                entryList.add(entry);
                entry = entry.next;
            }
        }

        if(entryList != null && entryList.size()>0){
            //重新设置对默认长度
            this.defaultLength = this.defaultLength*2;
            //使用长度重置为0
            this.userSize = 0;
            //将newTable肤质给table；
            this.entries = newEntryTable;
            //将保存好的数组放到新的容器中
            for (Entry<K,V> entry: entryList) {
                //循环list中的Entry,并将其next置为null
                if(entry.next != null){
                    entry.next=null;
                }

                //调用put方法，传入  kv
                put(entry.getKey(),entry.getValue());
            }


        }


    }


}
