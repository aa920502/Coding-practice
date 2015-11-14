import java.io.*;
import java.util.*;

public class MyHashtable<K, V> {    
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>()).run();
    }
    
    private int size;
    private Entry<K,V>[] myhashtable;
    
    //counstructor for no-input initialization
    public MyHashtable(){
        this.size = 500;
        myhashtable = new Entry[size];
    }
    //constructor
    public MyHashtable(int size){
        if(size<=0){
            throw new IllegalArgumentException("size must be greater than 0");
        }
        this.size = size;
        myhashtable = new Entry[size];
    }
    
    public void put(K key, V value) {
        if(key == null){
            throw new IllegalArgumentException("key must not be null");
        }
        int indexPos = getIndexPos(key);
        //nothing inserted at that position yet
        if (myhashtable[indexPos] == null){
            myhashtable[indexPos] = new Entry<K,V>(key,value);
            return;
        }
        
        //something already there
        Entry<K,V> cur = myhashtable[indexPos];
        while(cur != null){
            //at same index, if meet an entry that has same key value, replace it and return directly
            if(cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.nextEntry;
        }
        
        Entry<K,V> tmp = new Entry<K,V>(key,value);
        // append current entry as nextEntry for the new Entry, and set new Entry at that position
        tmp.nextEntry = myhashtable[indexPos];
        myhashtable[indexPos] = tmp;
    }

    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException("key must not be null");
        }
        int indexPos = getIndexPos(key);
        
        Entry<K,V> cur = myhashtable[indexPos];
        // search through all entries at that position and find one with same key
        while(cur!=null){
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.nextEntry;
        }
        //if not found, return null instead
        return null;
    }
    
    // method to get the index position in the entry array for a valid key,value input
    public int getIndexPos(K key){
        return (key.hashCode())%size;   
    }
    
    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> nextEntry;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
            this.nextEntry = null;
        }
    }
    

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}