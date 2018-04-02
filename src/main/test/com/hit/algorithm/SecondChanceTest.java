package com.hit.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChanceTest {

    @Test
    void getElement() {

    }

    @Test
    void putElement() {

        SecondChance<Integer, Integer> secondChance = new SecondChance<>(3);
        Integer myInt;

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(2, 2);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(3, 3);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(4, 4);
        assertEquals(2, myInt.hashCode());

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(2, 2);
        assertEquals(3, myInt.hashCode());

        myInt = secondChance.putElement(5, 5);
        assertEquals(null, myInt);


    }

    @Test
    void removeElement() {


    }
}