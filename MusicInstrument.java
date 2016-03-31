package com.company;


abstract public class MusicInstrument {
    private InstrumentsType type;

    public MusicInstrument(InstrumentsType type) {
        this.type = type;
    }

    public InstrumentsType getType(){
        return  this.type;
    }
}
