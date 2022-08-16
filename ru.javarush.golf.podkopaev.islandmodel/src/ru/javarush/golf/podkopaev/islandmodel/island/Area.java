package ru.javarush.golf.podkopaev.islandmodel.island;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;

import ru.javarush.golf.podkopaev.islandmodel.animals.predators.*;
import ru.javarush.golf.podkopaev.islandmodel.config.BioTypes;
import ru.javarush.golf.podkopaev.islandmodel.config.Configurations;
import ru.javarush.golf.podkopaev.islandmodel.plants.Plant;

import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;
import ru.javarush.golf.podkopaev.islandmodel.animals.herbivors.*;

import java.util.*;

public class Area {
    int x ;
    int y ;
    private final List<Herbivore> herbivores = new ArrayList<>();
    private final List<Predator> predators = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
    private final int sizeX;
    private final int sizeY;

    public Area(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        createHerbivores();
        createPlants();
        createPredators();
    }

    public void calculate() {
        createPlants();
        animalsEat(predators, herbivores);
        animalsEat(predators, predators);
        animalsBreed(predators);
        animalsEat(herbivores, plants);
        animalsEat(herbivores, herbivores);
        animalsBreed(herbivores);
        hunger(predators);
        hunger(herbivores);
        for (Predator predator:predators){
            predator.setTired(false);
        }
        for (Herbivore herbivore : herbivores){
            herbivore.setTired(false);
        }
    }

    public List<Predator> movePredators() {return setDirection(predators);}

    public List<Herbivore> moveHerbivores() {return setDirection(herbivores);}

    public <T extends Animal> List<T> getTravelAnimals(List<T> animals) {
        for (ListIterator<T> iterator = animals.listIterator();iterator.hasNext();) {
            T animal = iterator.next();
            if (  (animal.getX() == x) && (animal.getY() == y) && increaseNumber(animal)) {
                    if (animal instanceof Predator) {
                        predators.add((Predator) animal);
                    }else if(animal instanceof Herbivore){
                        herbivores.add((Herbivore) animal);
                    }
                    iterator.remove();
                    animals.remove(animal);
            }
        }
        return animals;
    }

    public <T extends Animal> void returnAnimals(List<T> animals){
        for (T animal : animals){
                animal.returnHome(this.x,this.y);
        }
        getTravelAnimals(animals);
    }

    @Override
    public String toString() {
        return "{" +
                "(x=" + x +
                ", y=" + y +
                "): \uD83D\uDC3B=" + numberOfBios("Bear") +
                ", \uD83D\uDC0D=" + numberOfBios("Boa") +
                ", \uD83E\uDD85=" + numberOfBios("Eagle") +
                ", \uD83E\uDD8A=" + numberOfBios("Fox") +
                ", \uD83D\uDC3A=" + numberOfBios("Wolf") +
                ", \uD83D\uDC17=" + numberOfBios("Boar") +
                ", \uD83D\uDC03=" + numberOfBios("Buffalo") +
                ", \uD83D\uDC1B=" + numberOfBios("Caterpillar") +
                ", \uD83E\uDD8C=" + numberOfBios("Deer") +
                ", \uD83E\uDD86=" + numberOfBios("Duck") +
                ", \uD83D\uDC10=" + numberOfBios("Goat") +
                ", \uD83D\uDC0E=" + numberOfBios("Horse") +
                ", \uD83D\uDC01=" + numberOfBios("Mouse") +
                ", \uD83D\uDC07=" + numberOfBios("Rabbit") +
                ", \uD83D\uDC11=" + numberOfBios("Sheep") +
                ", \uD83C\uDF3F" + numberOfBios("Plant") +
                '}';
    }

    private void createPlants() {
            int number = Randomizer.getRandom(Configurations.maxValue(BioTypes.Plant));
            for (int i = 0; i < number; i++) {
                if (numberOfBios("Plant") < Configurations.maxValue(BioTypes.Plant)) {
                    plants.add(new Plant(x, y));
                }
            }
    }

    private void createPredators() {
        int numberOfBears = Randomizer.getRandom(Configurations.maxValue(BioTypes.Bear));
        for (int i = 0; i < numberOfBears; i++) {
            predators.add(new Bear(x, y));
        }
        int numberOfBoa = Randomizer.getRandom(Configurations.maxValue(BioTypes.Boa));
        for (int i = 0; i < numberOfBoa; i++) {
            predators.add(new Boa(x, y));
        }
        int numberOfEagle = Randomizer.getRandom(Configurations.maxValue(BioTypes.Eagle));
        for (int i = 0; i < numberOfEagle; i++) {
            predators.add(new Eagle(x, y));
        }
        int numberOfFoxes = Randomizer.getRandom(Configurations.maxValue(BioTypes.Fox));
        for (int i = 0; i < numberOfFoxes; i++) {
            predators.add(new Fox(x, y));
        }
        int numberOfWolfs = Randomizer.getRandom(Configurations.maxValue(BioTypes.Wolf));
        for (int i = 0; i < numberOfWolfs; i++) {
            predators.add(new Wolf(x, y));
        }
    }

    private void createHerbivores() {

        int numberOfBoars = Randomizer.getRandom(Configurations.maxValue(BioTypes.Boar));
        for (int i = 0; i < numberOfBoars; i++) {
            herbivores.add(new Boar(x, y));
        }
        int numberOfBuffalo = Randomizer.getRandom(Configurations.maxValue(BioTypes.Buffalo));
        for (int i = 0; i < numberOfBuffalo; i++) {
            herbivores.add(new Buffalo(x, y));
        }
        int numberOfCaterpillars = Randomizer.getRandom(Configurations.maxValue(BioTypes.Caterpillar));
        for (int i = 0; i < numberOfCaterpillars; i++) {
            herbivores.add(new Caterpillar(x, y));
        }
        int numberOfDeer = Randomizer.getRandom(Configurations.maxValue(BioTypes.Deer));
        for (int i = 0; i < numberOfDeer; i++) {
            herbivores.add(new Deer(x, y));
        }
        int numberOfDucks = Randomizer.getRandom(Configurations.maxValue(BioTypes.Duck));
        for (int i = 0; i < numberOfDucks; i++) {
            herbivores.add(new Duck(x, y));
        }
        int numberOfGoats = Randomizer.getRandom(Configurations.maxValue(BioTypes.Goat));
        for (int i = 0; i < numberOfGoats; i++) {
            herbivores.add(new Goat(x, y));
        }
        int numberOfHorses = Randomizer.getRandom(Configurations.maxValue(BioTypes.Horse));
        for (int i = 0; i < numberOfHorses; i++) {
            herbivores.add(new Horse(x, y));
        }
        int numberOfMice = Randomizer.getRandom(Configurations.maxValue(BioTypes.Mouse));
        for (int i = 0; i < numberOfMice; i++) {
            herbivores.add(new Mouse(x, y));
        }
        int numberOfRabbits = Randomizer.getRandom(Configurations.maxValue(BioTypes.Rabbit));
        for (int i = 0; i < numberOfRabbits; i++) {
            herbivores.add(new Rabbit(x, y));
        }
        int numberOfSheep = Randomizer.getRandom(Configurations.maxValue(BioTypes.Sheep));
        for (int i = 0; i < numberOfSheep; i++) {
            herbivores.add(new Sheep(x, y));
        }
    }

    private <T extends Animal> void animalsBreed(List<T> animals) { //?
            List<T> children = new ArrayList<>();
            List<T> pairs = new ArrayList<>();
            for (int i = 0; i < animals.size() - 1; i++) {
                T MaleAnimal = animals.get(i);
                if (pairs.contains(MaleAnimal) || children.contains(MaleAnimal))
                    continue;
                for (int j = i + 1; j < animals.size(); j++) {
                    T FemaleAnimal = animals.get(j);
                    if(MaleAnimal.getClass() == FemaleAnimal.getClass() && !pairs.contains(FemaleAnimal) && !children.contains(FemaleAnimal)) {
                        T child = (T) MaleAnimal.reproduce(FemaleAnimal);
                        if (increaseNumber(child)) {
                            animals.add(child);
                            children.add(child);
                            pairs.add(MaleAnimal);
                            pairs.add(FemaleAnimal);
                            break;
                        }
                    }
                }
            }
    }

    private <T extends Animal, V extends Bio> void animalsEat(List<T> animals, List<V> victims) {
    List<V> deadVictims = new ArrayList<>();
    List<T> animalsCopy = new ArrayList<>(animals);
        for (T animal: animalsCopy) {
            if(deadVictims.contains(animal))
                continue;
            for (ListIterator<V> iterator = victims.listIterator();iterator.hasNext();) {
                V victim = iterator.next();
                if (animal == victim) {
                    continue;
                }
                if (animal.getFullness() >= animal.getMaxFullness()) {
                    break;
                }
                if (animal.eat(victim) && reduceNumber(victim) && animal.isTired()) {
                    animal.setFullness(animal.getFullness() + victim.getWeight());
                    iterator.remove();
                    victims.remove(victim);
                    deadVictims.add(victim);
                }
            }
        }
    }

    private <T extends Animal> void hunger(List<T> animals){
        for (ListIterator<T> iterator = animals.listIterator();iterator.hasNext();) {
            T animal = iterator.next();
            animal.hunger(animal.getFullness());
            if (!(animal instanceof Caterpillar) && animal.getFullness() < 0.1) {
                    reduceNumber(animal);
                    animals.remove(animal);
                    iterator.remove();
            }
        }
    }

    private <T extends Animal> List<T> setDirection(List<T> animals) {
        List<T> movingAnimals = new ArrayList<>();
        int stepProbability = 4;
        for (ListIterator<T> iterator = animals.listIterator();iterator.hasNext();) {
            T animal = iterator.next();
            int speed = animal.getSpeed();
            int stepCount = 4;
            int x = animal.getX();
            int y = animal.getY();
            for (int j = 0; j < stepCount; j++) {
                  if (speed > 0 && animal.isTired()) {
                      int random = Randomizer.getRandom(stepProbability);
                      if (random == 0 && y < sizeY) {
                          animal.move(Direction.UP);
                      } else if (random == 1 && (y > 0)) {
                          animal.move(Direction.DOWN);
                      } else if (random == 2 && (x < sizeX) ) {
                          animal.move(Direction.RIGHT);
                      } else if (random == 3 && (x > 0)) {
                          animal.move(Direction.LEFT);
                      }
                  x = animal.getX();
                  y = animal.getY();
                  speed--;
                  } else {
                      break;
                  }
            }
            animal.setTired(true);
            if (x != this.x || y != this.y) {
                movingAnimals.add(animal);
                reduceNumber(animal);
                iterator.remove();
                animals.remove(animal);
            }
        }
        return movingAnimals;
    }

    private boolean increaseNumber(Animal animal) {
            String name = animal.getName();
            return numberOfBios(name) < Configurations.maxValue(BioTypes.valueOf(name));
        }

    private boolean reduceNumber(Bio bio) {
            String name = bio.getName();
            return numberOfBios(name) > 0;
        }

    private int numberOfBios(String name){
        List<Bio> allBiosList = new ArrayList<>(predators);
        allBiosList.addAll(herbivores);
        allBiosList.addAll(plants);
        List<Bio> currentBiosNumber = new ArrayList<>();
            for (Bio animal1 : allBiosList) {
                if (animal1.getName().equals(name))
                    currentBiosNumber.add(animal1);
            }
            return currentBiosNumber.size();
    }
}
