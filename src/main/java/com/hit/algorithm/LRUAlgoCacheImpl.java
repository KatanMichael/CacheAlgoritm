package com.hit.algorithm;

import java.util.*;

public class LRUAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private int numberOfEntries;
    Hashtable<K,V> hashtable;
    Queue<K> keysQueue;


    public LRUAlgoCacheImpl(int capacity)
    {
        numberOfEntries = 0;
        this.capacity = capacity;
        hashtable = new Hashtable<>();
        keysQueue = new ArrayDeque<>();
    }


    public V getElement(K key)
    {
        V v;
        v= hashtable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {
        V v;
        if(numberOfEntries == capacity)
        {
            K k = keysQueue.poll();
            v = hashtable.get(k);
            hashtable.remove(k);
            keysQueue.add(key);
            hashtable.put(key, value);
            return v;

        }else
        {
            keysQueue.add(key);
            hashtable.put(key,value);
            numberOfEntries++;
            return null;
        }
    }

    public void removeElement(K key)
    {
        numberOfEntries--;
        hashtable.remove(key);
        keysQueue.remove(key);
    }

}
