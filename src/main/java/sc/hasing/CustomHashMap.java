package sc.hasing;

import java.util.List;
import java.util.ArrayList;

public class CustomHashMap {

    private class Entry {
        int key;
        int value;

        public Entry(int key, int value){
            key = this.key;
            value = this.value;
        }
    }

    List<Entry>[] buckets;
    int size; // number of key-value pairs
    int sz = 4; //initial size of array

    public CustomHashMap() {
        initBuckets(sz);
        size = 0;
    }

    public int getBucketIndex(int key)
    {
        return Math.abs(key) % buckets.length;
    }

    public void put(int key, int value) {
        int bi = getBucketIndex(key);
        int di = getIndexWithInBucket(key, bi);

        if(di != -1) {
            buckets[bi].get(di).value = value;
        } else {
            Entry nn = new Entry(key, value);
            nn.key = key;
            nn.value = value;
            buckets[bi].add(nn);
            size++;

            //Check for rehashing
            double lambda = size / buckets.length;
            if(lambda > 2.0)
                rehash();
        }
    }

    public int get(int key) {
        int bi = getBucketIndex(key);
        int di = getIndexWithInBucket(key, bi);

        if(di != -1)
            return buckets[bi].get(di).value;
        else
            return -1;
    }

    public int remove(int key) {
        int bi = getBucketIndex(key);
        int di = getIndexWithInBucket(key, bi);
        if(di != -1)
        {   // Key found, remove and return value
            size--;
            return buckets[bi].remove(di).value;
        } else {
            return -1; // Key not found
        }
    }

    public int size() {
        return size;
    }

    private void initBuckets(int sz){
        buckets = new ArrayList[sz];
        for(int i=0; i<sz; i++)
        {
            buckets[i] = new ArrayList<>();
        }
    }

    private int getIndexWithInBucket(int key, int bi)
    {
        int di = 0;
        for(Entry n : buckets[bi])
        {
            if(n.key == key){
                return di; // Key found
            }
            di++;
        }
        return -1; // Key not found
    }

    private void rehash() {
        List<Entry>[] oldBuckets = buckets;
        initBuckets(2 * oldBuckets.length);
        size = 0;

        for(List<Entry> bucket: oldBuckets) {
            for(Entry n : bucket) {
                put(n.key, n.value);
            }
        }
    }


    public static void main(String[] args) {
        CustomHashMap cm = new CustomHashMap();
        cm.put(1, 10);
        cm.put(5, 20);
        System.out.println(cm.get(1));
        System.out.println(cm.get(2));
        cm.put(9,30);
        System.out.println(cm.size());
        System.out.println(cm.remove(5));
        System.out.println(cm.size());
    }
}

