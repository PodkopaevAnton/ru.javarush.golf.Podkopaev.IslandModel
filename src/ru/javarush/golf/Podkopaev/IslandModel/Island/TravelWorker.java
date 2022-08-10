package ru.javarush.golf.Podkopaev.IslandModel.Island;

import java.util.ArrayList;


public class TravelWorker implements Runnable{
    ArrayList<Traveler> travelers = new ArrayList<>();
    private final GamePoint[][] gameField;

    public TravelWorker(GamePoint[][] gameField) {
        this.gameField = gameField;
    }
    @Override
    public void run() {
        runTasks();
    }
    public void runTasks(){
        travelers.add(new Traveler(gameField,"Herbivore"));
        travelers.add(new Traveler(gameField,"Predator"));
        for (Traveler traveler: travelers) {
            traveler.move();
        }

    }
}
