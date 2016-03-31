package com.company;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        Shop shop1 = new Shop();

        for (int i=1;i<=10;i++){
            shop1.addInstrument(new Guitar());
            shop1.addInstrument(new Piano());
            shop1.addInstrument(new Trumpet());
        }

        shop1.view();

        //Make order
        Map <String, Integer> order;
        order = new HashMap<>();

        order.put("GUITAR", 3);//-5,100
        order.put("PIANO", 2);
        order.put("TRUMPET", 6);
        //order.put("VIOLIN", 6);

        //Order to remove
        try {
            shop1.removeInstruments(shop1.prepareInstruments(order));
            System.out.println("Instruments prepared successfully!");
        }catch (Exception e) {
            System.out.println("Exception happened: "+e.getMessage());
        }

        shop1.view();

    }
}
