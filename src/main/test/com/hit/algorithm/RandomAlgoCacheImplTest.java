package com.hit.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomAlgoCacheImplTest {

    @Test
    void getElement() {
    }

    @Test
    void putElement()
    {
        RandomAlgoCacheImpl<Integer,Integer> rand = new RandomAlgoCacheImpl<>(4);
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Integer res;
                    int x,y;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    x = (int) (Math.random()*100);
                    y = (int) (Math.random()*100);
                    res = rand.putElement(x,y);

                    System.out.println(x + ", "+ y + "Enterd The Cache");

                    if(res != null)
                    {
                        System.out.println(res + "Got Out");
                    }


                }

            }
        });

        thread.run();

    }

    @Test
    void removeElement()
    {

    }
}