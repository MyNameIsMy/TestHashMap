package org.suchushin.projects;

import org.junit.jupiter.api.Test;

public class TestHashMap {

    @Test
    void test(){
        IntLongHashMap map = new IntLongHashMap();

        map.put(1,10);
        map.put(2,13);
        map.put(4,131);
        map.put(8,55);

        map.put(12,81);
        map.put(16,67);
        map.put(0,88);
        map.put(28,123);

        map.put(27,111);
        map.put(27,199);
        map.put(37,16);
        map.put(165,85);

        System.out.println();

        System.out.println("Value of key " + 1 + ": " + map.get(1));
        System.out.println("Value of key " + 2 + ": " + map.get(2));
        System.out.println("Value of key " + 4 + ": " + map.get(4));
        System.out.println("Value of key " + 8 + ": " + map.get(8));

        System.out.println();

        System.out.println("Value of key " + 12 + ": " + map.get(12));
        System.out.println("Value of key " + 16 + ": " + map.get(16));
        System.out.println("Value of key " + 0 + ": " + map.get(0));
        System.out.println("Value of key " + 28 + ": " + map.get(28));

        System.out.println();

        System.out.println("Value of key " + 27 + ": " + map.get(27));
        System.out.println("Value of key " + 27 + ": " + map.get(27));
        System.out.println("Value of key " + 37 + ": " + map.get(37));
        System.out.println("Value of key " + 165 + ": " + map.get(165));

        System.out.println();

        System.out.println("Total size: " + map.size());

        //This statement produce NoSuchElementException because no one entry with such key exist.
        System.out.println(map.get(5));
    }
}
