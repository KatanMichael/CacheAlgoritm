package com.hit.algorithm;

import java.util.*;

public class LRUAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private int numberOfEntries;
    Hashtable<K, V> hashTable;
    Queue<K> keysQueue;


    public LRUAlgoCacheImpl(int capacity)
    {
        super(capacity);
        numberOfEntries = 0;
        this.capacity = capacity;
        hashTable = new Hashtable<>();
        keysQueue = new ArrayDeque<>();
    }


    public V getElement(K key)
    {
        V v;
        v = hashTable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {
        V v;
        if(numberOfEntries == capacity)
        {
            K k = keysQueue.poll();
            v = hashTable.get(k);
            hashTable.remove(k);
            keysQueue.add(key);
            hashTable.put(key, value);
            return v;

        }else
        {
            keysQueue.add(key);
            hashTable.put(key, value);
            numberOfEntries++;
            return null;
        }
    }

    public void removeElement(K key)
    {
        numberOfEntries--;
        hashTable.remove(key);
        keysQueue.remove(key);
    }

}
