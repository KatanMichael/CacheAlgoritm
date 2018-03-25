package com.hit.algorithm;

import java.util.Hashtable;
import java.util.Stack;

public class MRUAlgoCacheImpl <K,V> extends AbstractAlgoCache<K,V>
{
    private Hashtable<K,V> hashtable;
    private Stack<K> firstStack;
    private Stack<K> secondStack;
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
        V v;
        v = null;
        K k;

        int totalStacksSize = firstStack.size() + secondStack.size();

        if(totalStacksSize == capacity)
        {
            if(firstStack.size() == capacity)
            {

                secondStack.push(key);
                hashtable.put(key,value);
                removingFirstStack = true;
                k = firstStack.pop();
                v = hashtable.get(k);
            }else
            if(secondStack.size() == capacity)
            {
                firstStack.push(key);
                hashtable.put(key,value);
                removingFirstStack = false;
                k = secondStack.pop();
                v = hashtable.get(k);
            }else
            {
                if(removingFirstStack)
                {
                    secondStack.push(key);
                    hashtable.put(key,value);
                    removingFirstStack = true;
                    k = firstStack.pop();
                    v = hashtable.get(k);
                }else
                {
                    firstStack.push(key);
                    hashtable.put(key,value);
                    removingFirstStack = false;
                    k = secondStack.pop();
                    v = hashtable.get(k);

                }
            }



        }else
        {
            hashtable.put(key,value);
            firstStack.add(key);
        }


        return v;
    }

    public void removeElement(K key)
    {

        if(!firstStack.removeElement(key))
        {
            secondStack.removeElement(key);
        }
        hashtable.remove(key);

    }

    private void removeFromStack(Stack<K> stack,K key)
    {

    }
}
