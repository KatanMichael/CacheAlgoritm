package com.hit.algorithm;

import java.util.*;

public class SecondChance <K,V> extends AbstractAlgoCache<K,V>
{

    List<K> listOfKeys;
    Queue<K> secondChanceKeys;
    private Hashtable<K, V> hashtable;
    private int numberOfEntries;


    public SecondChance(int capacity)
    {
        listOfKeys = new ArrayList<>();
        secondChanceKeys = new ArrayDeque<>();
        numberOfEntries = 0;
        hashtable = new Hashtable<>();
        this.capacity = capacity;
    }

    public V getElement(K key) {
        V v;
        v = hashtable.get(key);

        return v;
    }

    public V putElement(K key, V value) {
        V v = hashtable.get(key);
        if (v != null) {
            if (v == value) {
                if (!secondChanceKeys.contains(key)) {
                    secondChanceKeys.add(key);

                }
                return null;
            }
        }


        if (numberOfEntries == capacity) {
            for (int i = 0; i < listOfKeys.size(); i++) {
                K tempK;
                tempK = listOfKeys.get(i);
                if (secondChanceKeys.contains(tempK)) {
                    secondChanceKeys.remove(key);
                } else {
                    v = hashtable.get(tempK);
                    listOfKeys.add(key);
                    listOfKeys.remove(tempK);
                    hashtable.remove(tempK);
                    i = listOfKeys.size() + 1;
                }
            }

        } else {
            hashtable.put(key, value);
            numberOfEntries++;
            listOfKeys.add(key);

        }


        return v;
    }

    public void removeElement(K key) {

    }
}
