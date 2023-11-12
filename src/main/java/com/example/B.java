package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

class B {

    int bField = 0;

    public void bViolationMethod() {
        bField += 2;
        List<Integer> l;
        l = new ArrayList<Integer>(Arrays.asList(4, 5, 2, 3, 1));
        try{
            for (int i : l) {
                l.add(10);
            }
        } catch (ConcurrentModificationException e) { // add the exception variable name
            System.out.println("ConcurrentModificationException");
        }
    }

    public void bMethod() {
        System.out.println("bMethod");
    }

    public void bFieldMethod() {
        System.out.println("bFieldMethod");
        bField -= 1;
    }


}
