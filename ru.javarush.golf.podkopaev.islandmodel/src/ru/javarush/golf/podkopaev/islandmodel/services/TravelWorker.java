package ru.javarush.golf.podkopaev.islandmodel.services;

import ru.javarush.golf.podkopaev.islandmodel.animals.herbivors.Herbivore;
import ru.javarush.golf.podkopaev.islandmodel.animals.predators.Predator;
import ru.javarush.golf.podkopaev.islandmodel.island.Area;

import java.util.ArrayList;
import java.util.List;

public class TravelWorker implements Runnable{

    private final String name;
    private final Area[][] world;
    private final Area[] areas;

    public TravelWorker(Area[] areas, Area[][] world, String name) {
        this.name = name;
        this.world = world;
        this.areas = areas;
    }

    @Override
    public void run() {
        synchronized (areas) {
            move();
        }
    }

    public void move() {
        for (Area area: areas){
                    moveOnPoint(area);
            }
    }

    public void moveOnPoint( Area area){
        if(name.equals("Herbivore")) {
            List<Herbivore> travelHerbivores = area.moveHerbivores();
            List<Herbivore> returningHerbivores = new ArrayList<>();
            for (Area[] rows : world) {
                for (Area nexArea : rows) {
                    if (area != nexArea) {
                        returningHerbivores = nexArea.getTravelAnimals(travelHerbivores);
                    }
                }
            }
            area.returnAnimals(returningHerbivores);
        }
        if(name.equals("Predator")) {
            List<Predator> travelPredators = area.movePredators();
            List<Predator> returningPredators = new ArrayList<>();
            for (Area[] rows : world) {
                for (Area nexArea : rows) {
                    if (area != nexArea) {
                        returningPredators = nexArea.getTravelAnimals(travelPredators);
                    }
                }
            }
            area.returnAnimals(returningPredators);
        }
    }

}