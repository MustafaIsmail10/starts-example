package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

class B {
    
    public void vB() {
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
}
