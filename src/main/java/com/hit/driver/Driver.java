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

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        while(true)
        {
            key = (int) ((Math.random()*100));
            value = (int) ((Math.random()*100));
            Integer result;
            choice = (int) ((Math.random()*10)%3);

            switch (choice) {
                case 0: {

                    lru.removeElement(key);
                    System.out.println(key + " Got Removed");

                    break;
                }
                case 1: {
                    System.out.println(key + ", " + value + " Enterd");
                    result = lru.putElement(key, value);
                    if (result != null) {
                        System.out.println(result + " Removed From the Table");
                    }


                    break;
                }

                case 2: {
                    System.out.println("Searching for key: " + key);
                    result = lru.getElement(key);
                    if (result == null) {
                        System.out.println("Nothing Matched this key");
                    } else {
                        System.out.println(result + " Matched this key ");

                    }


                    break;
                }
            }

            thread.run();

        }
    }


}
