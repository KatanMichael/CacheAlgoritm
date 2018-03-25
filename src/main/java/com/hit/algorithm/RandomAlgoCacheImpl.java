package com.hit.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RandomAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private Hashtable<K,V> hashtable;
    private List<K> listOfKeys;
    private int numberOfEntries;

    public RandomAlgoCacheImpl(int capacity)
    {
        numberOfEntries = 0;
        hashtable = new Hashtable<>();
        this.capacity = capacity;
        listOfKeys = new ArrayList<>();
    }

    public V getElement(K key)
    {
        V v;
        v = hashtable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {
        V v = null;
        if(numberOfEntries == capacity)
        {
            int randomNum = (int)(Math.random()*(capacity*10))%capacity;
            K tempKey;

            tempKey = listOfKeys.get(randomNum);
            v = hashtable.get(tempKey);
            listOfKeys.remove(tempKey);
            hashtable.remove(key);

            hashtable.put(key,value);
            listOfKeys.add(key);

        }else
        {
            numberOfEntries++;
            hashtable.put(key,value);
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

        hashtable.remove(key);
        listOfKeys.remove(key);

    }
}
