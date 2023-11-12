package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class C extends B {

    int z = 5;

    public void cViolationMethod() {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        try {
            iterator.remove(); // This will violate the specification
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException");
        }
        z += 22;
    }

    public void bViolationMethod() {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        try {
            iterator.remove(); // This will violate the specification
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException");
        }
        z = 0;
    }

    public void cMethod() {
        System.out.println("cMethod");
    }

    public void usingDViolationMethod(){
        D d_Variable = new D();
        d_Variable.dViolationMethod();
    }

    public void usingDMethod(){
        D d_Variable = new D();
        d_Variable.dMethod();
    }
}

