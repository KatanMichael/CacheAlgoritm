package com.hit.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MRUAlgoCacheImpl<K, V> extends AbstractAlgoCache<K, V> {
    private Hashtable<K, V> hashTable;
    private List<K> listOfKeys;
    private int numberOfEntries;
    private int removePos;
    private boolean firstTimeRemove;
    private boolean goingBack;


    public MRUAlgoCacheImpl(int capacity) {
        super(capacity);
        listOfKeys = new ArrayList<>();
        hashTable = new Hashtable<>();
        numberOfEntries = 0;
        removePos = capacity - 1;
        firstTimeRemove = true;
        goingBack = true;
    }

    public V getElement(K key) {
        V v;
        v = hashTable.get(key);

        return v;
    }

    public V putElement(K key, V value) {
        V v = null;

        if (hashTable.contains(key)) {
            return v;
        }


        if (numberOfEntries == capacity)
        {

            if (removePos == 0) {
                goingBack = false;
                K tempKey;
                tempKey = listOfKeys.get(removePos);
                listOfKeys.remove(tempKey);
                v = hashTable.get(tempKey);
                hashTable.remove(tempKey);
                hashTable.put(key, value);
                listOfKeys.add(removePos, key);
                removePos++;
                return v;


            }
            if (removePos == capacity - 1) {
                goingBack = true;
            }

            K tempKey;
            tempKey = listOfKeys.get(removePos);
            listOfKeys.remove(tempKey);
            v = hashTable.get(tempKey);
            hashTable.remove(tempKey);
            hashTable.put(key, value);
            listOfKeys.add(removePos, key);

            if (goingBack) {
                removePos--;
            } else {
                removePos++;
            }

            return v;

        } else {
            hashTable.put(key, value);
            listOfKeys.add(key);
            numberOfEntries++;
            removePos = listOfKeys.indexOf(key);
        }

        return v;

    }

    public void removeElement(K key) {
        hashTable.remove(key);
        listOfKeys.remove(key);
        numberOfEntries--;

    }


}
