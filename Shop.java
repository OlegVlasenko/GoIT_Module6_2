package com.company;

import java.util.*;

/**
 * Created by User on 16.03.2016.
 */
public class Shop {
    List<MusicInstrument> instruments;

    public Shop(List<MusicInstrument> instruments) {
        this.instruments = instruments;
    }

    public Shop(MusicInstrument instrument) {
        this.instruments = new ArrayList<MusicInstrument>();
        this.instruments.add(instrument);
    }

    public Shop() {
        this.instruments = new ArrayList<MusicInstrument>();
    }

    public List<MusicInstrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(List<MusicInstrument> instruments) {
        this.instruments = instruments;
    }

    public void addInstrument (MusicInstrument instrument){
        instruments.add(instrument);
    }

    public void view() {
        Map<InstrumentsType,Integer> inv = new HashMap<>();
        for (MusicInstrument item:instruments){
            if (inv.containsKey(item.getType())){
                inv.replace(item.getType(), inv.get(item.getType()) + 1);
            }else {
                inv.put(item.getType(), 1);
            }
        }
        System.out.println("----------------------------------");
        System.out.println(inv);
        System.out.println("----------------------------------");

    }

    public List<MusicInstrument> prepareInstruments(Map<String, Integer> order){

        List<MusicInstrument> result = new ArrayList<>();

        for (Map.Entry<String, Integer> orderEntry : order.entrySet() ) {
            String instrumentType = orderEntry.getKey();
            Integer orderQuantity = orderEntry.getValue();

            Integer instrumentsToBeRemoved = 0;
            for (MusicInstrument instrument: instruments ) {
                if( instrument.getType().toString().equals(instrumentType) && instrumentsToBeRemoved < orderQuantity ) {
                    result.add(instrument);
                    instrumentsToBeRemoved += 1;
                }
            }
            if (instrumentsToBeRemoved == 0)
                throw new IllegalArgumentException("Shop doesn't have type " + instrumentType);

            if (! instrumentsToBeRemoved.equals(orderQuantity))
                throw new IllegalArgumentException("Not enough " + (orderQuantity - instrumentsToBeRemoved) + " " + instrumentType + "S"  + " of the " + orderQuantity + " ordered" );
         }
        return result;
    }

    public void removeInstruments(List<MusicInstrument> listRoBeRemoved){
        for (MusicInstrument item: listRoBeRemoved ) {
            instruments.remove(item);
        }
    }

}
