package com.hit.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LRUAlgoCacheImpl <Integer,V> extends AbstractAlgoCache<Integer,V>
{
    private int numberOfEntries;
    private int leastentry;
    private List<V> cacheList;

    public LRUAlgoCacheImpl(int capacity)
    {
        cacheList = new ArrayList<>();
        numberOfEntries = 0;
        this.capacity = capacity;
        leastentry = 0;
    }


    public V getElement(Integer key)
    {
        return cacheList.get(key.hashCode());
    }

    public V putElement(Integer key, V value)
    {
        V v;
        if(capacity == numberOfEntries)
        {
            v = cacheList.get(leastentry);
            cacheList.set(leastentry,value);
            return  v;
        }else
        {
            cacheList.add(value);
            numberOfEntries++;
        }

        return  null;
    }

    public void removeElement(Integer key)
    {
        cacheList.remove(key.hashCode());
    }

}
