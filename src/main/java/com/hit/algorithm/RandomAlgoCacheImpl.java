package com.hit.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RandomAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private Hashtable<K, V> hashTable;
    private List<K> listOfKeys;
    private int numberOfEntries;

    public RandomAlgoCacheImpl(int capacity)
    {
        super(capacity);
        numberOfEntries = 0;
        hashTable = new Hashtable<>();
        this.capacity = capacity;
        listOfKeys = new ArrayList<>();
    }

    public V getElement(K key)
    {
        V v;
        v = hashTable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {
        V v = null;

        if (hashTable.contains(key)) {
            return null;
        }

        if(numberOfEntries == capacity)
        {
            int randomNum = (int)(Math.random()*(capacity*10))%capacity;
            K tempKey;

            tempKey = listOfKeys.get(randomNum);
            v = hashTable.get(tempKey);
            listOfKeys.remove(tempKey);
            hashTable.remove(key);

            hashTable.put(key, value);
            listOfKeys.add(key);

        }else
        {
            numberOfEntries++;
            hashTable.put(key, value);
            listOfKeys.add(key);
        }

        return v;
    }

    public void removeElement(K key)
    {
        if(numberOfEntries > 0)
        {
            numberOfEntries--;
        }

        hashTable.remove(key);
        listOfKeys.remove(key);

    }
}
