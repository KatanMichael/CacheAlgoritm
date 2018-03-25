package com.hit.driver;


import com.hit.algorithm.*;

public class Driver
{
    static int choice = -1;
    static int key;
    static int value;

    static LRUAlgoCacheImpl<Integer,Integer> lru;

    public static void main(String[] args)
    {
        lru = new LRUAlgoCacheImpl<>(10);

        while(true)
        {
            key = (int) ((Math.random()*100));
            value = (int) ((Math.random()*100));

            choice = (int) ((Math.random()*10)%3);

            switch (choice) {
                case 0: {


                    break;
                }
                case 1: {

                    break;
                }

                case 2: {


                    break;
                }
            }

        }
    }


}
