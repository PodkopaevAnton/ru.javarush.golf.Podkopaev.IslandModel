package ru.javarush.golf.podkopaev.islandmodel.services;

import ru.javarush.golf.podkopaev.islandmodel.island.Area;

public class CalculationWorker implements Runnable{

    private final Area[] areas;

    public CalculationWorker(Area[] areas) {
        this.areas = areas;
    }

    @Override
    public void run() {
        synchronized (areas) {
            calculate();
        }
    }

    public void calculate(){
        for (Area area: areas){
                area.calculate();
        }
    }
}
