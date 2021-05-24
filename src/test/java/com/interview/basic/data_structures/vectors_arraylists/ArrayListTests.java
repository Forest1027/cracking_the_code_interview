package com.interview.basic.data_structures.vectors_arraylists;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.logging.Logger;

public class ArrayListTests {
    private ArrayList<Integer> list = new ArrayList<>();
    private java.util.ArrayList<Integer> tempList = new java.util.ArrayList<>();
    private int size = 120;
    private Logger logger = Logger.getLogger("ArrayList");

    @Test
    public void testAddAndRemove() {
        Random random = new Random();
        int num = size;
        while (num > 0) {
            int element = random.nextInt(100);
            list.add(list.size(), element);
            tempList.add(tempList.size(), element);
            num--;
        }
        logger.info("My ArrayList: " + list.toString());
        logger.info("Java ArrayList: " + tempList.toString());
        assert list.toString().equals(tempList.toString());
        while (num < size) {
            list.remove(0);
            tempList.remove(0);
            logger.info("My ArrayList in remove: " + list.toString());
            logger.info("Java ArrayList in remove: " + tempList.toString());
            assert list.toString().equals(tempList.toString());
            num++;
        }
    }
}
