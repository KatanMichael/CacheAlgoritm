package com.hit.algorithm;

import static org.junit.jupiter.api.Assertions.*;

class LRUAlgoCacheImplTest
{

    @org.junit.jupiter.api.Test
    void getElement()
    {
        Person p = new Person();
        LRUAlgoCacheImpl<Integer,Person> lru = new LRUAlgoCacheImpl<>(5);



    }

    @org.junit.jupiter.api.Test
    void putElement()
    {

        Integer myInt;
        LRUAlgoCacheImpl<Integer,Integer> lru = new LRUAlgoCacheImpl<>(4);

        myInt = lru.putElement(1,2);
        assertEquals(null,myInt);

        myInt = lru.putElement(3,4);
        assertEquals(null,myInt);

        myInt = lru.putElement(5,6);
        assertEquals(null,myInt);

        myInt = lru.putElement(7,8);
        assertEquals(null,myInt);

        lru.removeElement(3);
        myInt = lru.putElement(9,10);
        assertEquals(null,myInt);

        myInt = lru.putElement(11,12);
        assertEquals(2,myInt.hashCode());

        myInt = lru.getElement(7);
        assertEquals(8,myInt.hashCode());




    }

    @org.junit.jupiter.api.Test
    void removeElement()
    {

    }
}

class Person
{
    int age;
    String name;
    public Person(int age,String name)
    {this.age = age;this.name = name;}
    public Person(){}

    @Override
    public String toString()
    {
        return (name+": "+age);
    }
}