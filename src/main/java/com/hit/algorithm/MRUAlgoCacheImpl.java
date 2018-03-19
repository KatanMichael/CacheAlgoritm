package com.hit.algorithm;

import java.util.Hashtable;
import java.util.Stack;

public class MRUAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private Hashtable<K,V> hashtable;
    private Stack<K> firstStack;
    private Stack<K> secondStack;
    private int numberOfEnteris;
    private boolean removingFirstStack;

    public MRUAlgoCacheImpl(int capacity)
    {
        this.capacity = capacity;
        firstStack = new Stack<>();
        secondStack = new Stack<>();
        hashtable = new Hashtable<>();
        removingFirstStack = true;
    }

    public V getElement(K key)
    {
        V v;
        v = hashtable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {

        return null;
    }

    public void removeElement(K key)
    {
        numberOfEnteris--;
        if(!firstStack.removeElement(key))
        {
            secondStack.removeElement(key);
        }
        hashtable.remove(key);

    }
}
