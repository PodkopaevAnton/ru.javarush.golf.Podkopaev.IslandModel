package ru.javarush.golf.Podkopaev.IslandModel.Island;

import ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors.Herbivore;
import ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators.Predator;

import java.util.ArrayList;
import java.util.List;


public class Traveler extends Island {
    private final String name;
    private final GamePoint[][] gameField;

    public Traveler(GamePoint[][] gameField, String name) {
        this.name = name;
        this.gameField = gameField;
    }


    public void move() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                gameField[i][j].getLock().lock();
                try {
                    moveOnPoint(gameField[i][j]);
                }finally {
                    gameField[i][j].getLock().unlock();
                }
            }
        }
    }

    public void moveOnPoint( GamePoint gamePoint){
        if(name.equals("Herbivore")) {
            List<Herbivore> travelHerbivores = gamePoint.moveHerbivores();
            List<Herbivore> returningHerbivores = new ArrayList<>();
            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX; j++) {
                    GamePoint nextPoint = gameField[i][j];
                    if (gamePoint != nextPoint) {
                        returningHerbivores = nextPoint.getTravelAnimals(travelHerbivores);
                    }
                }
            }
            gamePoint.returnAnimals(returningHerbivores);
        }
        if(name.equals("Predator")) {
            List<Predator> travelPredators = gamePoint.movePredators();
            List<Predator> returningPredators = new ArrayList<>();
            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX; j++) {
                    GamePoint nextPoint = gameField[i][j];
                    if (gamePoint != nextPoint) {
                        returningPredators = nextPoint.getTravelAnimals(travelPredators);
                    }
                }
            }
            gamePoint.returnAnimals(returningPredators);
        }
    }

}