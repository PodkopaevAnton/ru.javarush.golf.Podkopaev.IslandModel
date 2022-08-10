package ru.javarush.golf.Podkopaev.IslandModel.Island;

import ru.javarush.golf.Podkopaev.IslandModel.Animals.Animal;
import ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators.*;
import ru.javarush.golf.Podkopaev.IslandModel.Plants.Plant;
import ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors.Herbivore;

import ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors.*;
import ru.javarush.golf.Podkopaev.IslandModel.util.Randomizer;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GamePoint {
    int x ;
    int y ;

    public int maxCountPlants = 200;

    public int maxCountBears = 5;
    public int maxCountBoas = 30;
    public int maxCountEagles = 20;
    public int maxCountFoxes = 30;
    public int maxCountWolfs = 30;

    public int maxCountBoars = 50;
    public int maxCountBuffaloes = 10;
    public int maxCountCaterpillars = 1000;
    public int maxCountDeer = 20;
    public int maxCountDucks = 200;
    public int maxCountGoats = 140;
    public int maxCountHorses = 20;
    public int maxCountMice = 500;
    public int maxCountRabbits = 150;
    public int maxCountSheep = 140;
    // Списки где будут храниться находящиеся на локации сущности
    private final List<Herbivore> herbivores = new ArrayList<>();
    private final List<Predator> predators = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    private int number_of_bears = 0;
    private int number_of_boa = 0;
    private int number_of_eagle = 0;
    private int number_of_fox = 0;
    private int number_of_wolf = 0;

    private int number_of_boars = 0;
    private int number_of_buffalo = 0;
    private int number_of_caterpillars = 0;
    private int number_of_deer = 0;
    private int number_of_ducks = 0;
    private int number_of_goats = 0;
    private int number_of_horses = 0;
    private int number_of_mice = 0;
    private int number_of_rabbits = 0;
    private int number_of_sheep = 0;
    private int number_of_plants = 0;
    private final int sizeX;
    private final int sizeY;
    private final Lock lock = new ReentrantLock(true);

    public GamePoint(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        createHerbivores();
        createPlants();
        createPredators();
    }

    // Actions
    public void calculate() {


        createPlants();

        animalsEat(predators, herbivores);

        animalsEatEachOther(predators, predators);

        animalsBreed(predators);

        eatPlants(herbivores, plants);

        animalsEatEachOther(herbivores, herbivores);

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

    public <T extends Animal> List<T> getTravelAnimals(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T animal = list.get(i);
            if (  (animal.getX() == x) && (animal.getY() == y)) {
                if(increaseNumber(animal)) {
                    if (animal instanceof Predator) {
                        predators.add((Predator) animal);
                    }else if(animal instanceof Herbivore){
                        herbivores.add((Herbivore) animal);
                    }
                    list.remove(animal);
                    i--;
                }
            }
        }
        return list;
    }

    public <T extends Animal> void returnAnimals(List<T> list){
        for (T animal : list){
                animal.returnHome(this.x,this.y);
        }
        getTravelAnimals(list);
    }


    @Override
    public String toString() {
        return "{" +
                "(x=" + x +
                ", y=" + y +
                "): \uD83D\uDC3B=" + number_of_bears +
                ", \uD83D\uDC0D=" + number_of_boa +
                ", \uD83E\uDD85=" + number_of_eagle +
                ", \uD83E\uDD8A=" + number_of_fox +
                ", \uD83D\uDC3A=" + number_of_wolf +
                ", \uD83D\uDC17=" + number_of_boars +
                ", \uD83D\uDC03=" + number_of_buffalo +
                ", \uD83D\uDC1B=" + number_of_caterpillars +
                ", \uD83E\uDD8C=" + number_of_deer +
                ", \uD83E\uDD86=" + number_of_ducks +
                ", \uD83D\uDC10=" + number_of_goats +
                ", \uD83D\uDC0E=" + number_of_horses +
                ", \uD83D\uDC01=" + number_of_mice +
                ", \uD83D\uDC07=" + number_of_rabbits +
                ", \uD83D\uDC11=" + number_of_sheep +
                ", \uD83C\uDF3F" + number_of_plants +
                '}';
    }




    private void createPlants() {
        getLock().lock();
        try {
            int number = Randomizer.getRandom(maxCountPlants);
            for (int i = 0; i < number; i++) {
                if (number_of_plants < maxCountPlants) {
                    number_of_plants = number_of_plants + 1;
                    plants.add(new Plant(x, y));
                } else {
                    break;
                }
            }
        }finally {
            getLock().unlock();
        }
    }

    private void createPredators() {
        number_of_bears = Randomizer.getRandom(maxCountBears);
        for (int i = 0; i < number_of_bears; i++) {
            predators.add(new Bear(x, y));
        }
        number_of_boa = Randomizer.getRandom(maxCountBoas);
        for (int i = 0; i < number_of_boa; i++) {
            predators.add(new Boa(x, y));
        }
        number_of_eagle = Randomizer.getRandom(maxCountEagles);
        for (int i = 0; i < number_of_eagle; i++) {
            predators.add(new Eagle(x, y));
        }
        number_of_fox = Randomizer.getRandom(maxCountFoxes);
        for (int i = 0; i < number_of_fox; i++) {
            predators.add(new Fox(x, y));
        }
        number_of_wolf = Randomizer.getRandom(maxCountWolfs);
        for (int i = 0; i < number_of_wolf; i++) {
            predators.add(new Wolf(x, y));
        }
    }

    private void createHerbivores() {

        number_of_boars = Randomizer.getRandom(maxCountBoars);
        for (int i = 0; i < number_of_boars; i++) {
            herbivores.add(new Boar(x, y));
        }
        number_of_buffalo = Randomizer.getRandom(maxCountBuffaloes);
        for (int i = 0; i < number_of_buffalo; i++) {
            herbivores.add(new Buffalo(x, y));
        }
        number_of_caterpillars = Randomizer.getRandom(maxCountCaterpillars);
        for (int i = 0; i < number_of_caterpillars; i++) {
            herbivores.add(new Caterpillar(x, y));
        }
        number_of_deer = Randomizer.getRandom(maxCountDeer);
        for (int i = 0; i < number_of_deer; i++) {
            herbivores.add(new Deer(x, y));
        }
        number_of_ducks = Randomizer.getRandom(maxCountDucks);
        for (int i = 0; i < number_of_ducks; i++) {
            herbivores.add(new Duck(x, y));
        }
        number_of_goats = Randomizer.getRandom(maxCountGoats);
        for (int i = 0; i < number_of_goats; i++) {
            herbivores.add(new Goat(x, y));
        }
        number_of_horses = Randomizer.getRandom(maxCountHorses);
        for (int i = 0; i < number_of_horses; i++) {
            herbivores.add(new Horse(x, y));
        }
        number_of_mice = Randomizer.getRandom(maxCountMice);
        for (int i = 0; i < number_of_mice; i++) {
            herbivores.add(new Mouse(x, y));
        }
        number_of_rabbits = Randomizer.getRandom(maxCountRabbits);
        for (int i = 0; i < number_of_rabbits; i++) {
            herbivores.add(new Rabbit(x, y));
        }
        number_of_sheep = Randomizer.getRandom(maxCountSheep);
        for (int i = 0; i < number_of_sheep; i++) {
            herbivores.add(new Sheep(x, y));
        }
    }

    private <T extends Animal> void animalsBreed(List<T> list) {
        getLock().lock();
        try {
            List<T> listCopy1 = new ArrayList<>(list);
            List<T> childs = new ArrayList<>();
            for (int i = 0; i < listCopy1.size() - 1; i++) {
                for (int j = i + 1; j < listCopy1.size(); j++) {
                    T predator = listCopy1.get(i);
                    T predator1 = listCopy1.get(j);
                    T predator2 = (T) predator.reproduce(predator1);
                    if (increaseNumber(predator2)) {
                        childs.add(predator2);
                        listCopy1.remove(predator);
                        listCopy1.remove(predator1);
                        i--;
                        break;
                    }
                }
            }
            list.addAll(childs);
            childs.removeAll(list);
        }finally {
            getLock().unlock();
        }
    }

    private <T extends Animal, V extends Animal> void animalsEat(List<T> list1, List<V> list2) {
        getLock().lock();
        try {
            for (T predator : list1) {
                double fullness = predator.getFullness();
                for (int i = 0; i < list2.size(); i++) {
                    V herbivore = list2.get(i);
                    if (predator.getFullness() >= predator.getMax_fullness()) {
                        break;
                    } else if (predator.eat(herbivore) && (predator.getFullness() < predator.getMax_fullness())) {
                        fullness = fullness + herbivore.getWeight();
                        predator.setFullness(fullness);
                        reduceNumber(herbivore);
                        list2.remove(herbivore);
                        i--;
                    }
                }
            }
        }finally {
            getLock().unlock();
        }
    }

    public Lock getLock() {
        return lock;
    }

    private <T extends Animal, V extends Animal> void animalsEatEachOther(List<T> list1, List<V> list2) {
        getLock().lock();
        try {
            for (int i = 0; i < list1.size(); i++) {
                T predator1 = list1.get(i);
                double fullness = predator1.getFullness();
                for (int j = 0; j < list2.size(); j++) {
                    V predator2 = list2.get(j);
                    if (predator1 == predator2) {
                        continue;
                    }
                    if (predator1.getFullness() >= predator1.getMax_fullness()) {
                        break;
                    } else if (predator1.eat(predator2) && (predator1.getFullness() < predator1.getMax_fullness())) {
                        fullness = fullness + predator2.getWeight();
                        predator1.setFullness(fullness);
                        reduceNumber(predator2);
                        list2.remove(predator2);
                        j--;
                    }
                }
            }
        }finally {
            getLock().unlock();
        }
    }

    private void eatPlants(List<Herbivore> list1, List<Plant> list2) {
        getLock().lock();
        try {
            for (int i = 0; i < list1.size(); i++) {
                Herbivore predator1 = list1.get(i);
                double fullness = predator1.getFullness();
                for (int j = 0; j < list2.size(); j++) {
                    Plant predator2 = list2.get(j);
                    if (predator1.getFullness() >= predator1.getMax_fullness()) {
                        break;
                    } else if (predator1.eat(predator2) && (predator1.getFullness() < predator1.getMax_fullness())) {
                        fullness = fullness + predator2.getWeight();
                        predator1.setFullness(fullness);
                        reduceNumber(predator2);
                        list2.remove(predator2);
                        j--;
                    }
                }
            }
        }finally {
            getLock().unlock();
        }
    }

    private <T extends Animal> void hunger(List<T> list){
        getLock().lock();
        try {
            for (int i = 0; i < list.size(); i++) {
                T animal = list.get(i);
                double fullness = animal.getFullness();
                animal.hunger(fullness);
                if (!(animal instanceof Caterpillar) && animal.getFullness() < 0.0001) {  //умер от голода
                    reduceNumber(animal);
                    list.remove(animal);
                    i--;
                }
            }
        }finally {
            getLock().unlock();
        }
    }

    private <T extends Animal> List<T> setDirection(List<T> list) {
        getLock().lock();
        try {
            List<T> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                T animal = list.get(i);
                int speed = animal.getSpeed();
                int step = 5;
                int x = animal.getX();
                int y = animal.getY();
                for (int j = 0; j < step; j++) {
                    if (speed > 0 && !animal.isTired()) {
                        int ver = Randomizer.getRandom(6);
                        switch (ver) {
                            case 0:
                                if (y < sizeY) {
                                    animal.move(Direction.UP);
                                    x = animal.getX();
                                    y = animal.getY();
                                    speed--;
                                    break;
                                }
                            case 1:
                                if (y > 0) {
                                    animal.move(Direction.DOWN);
                                    x = animal.getX();
                                    y = animal.getY();
                                    speed--;
                                    break;
                                }
                            case 2:
                                if (x < sizeX) {
                                    animal.move(Direction.RIGHT);
                                    x = animal.getX();
                                    y = animal.getY();
                                    speed--;
                                    break;
                                }
                            case 3:
                                if (x > 0) {
                                    animal.move(Direction.LEFT);
                                    x = animal.getX();
                                    y = animal.getY();
                                    speed--;
                                    break;
                                }
                            default:
                                break;
                        }
                    } else {
                        break;
                    }
                }
                animal.setTired(true);
                if (x != this.x || y != this.y) {
                    list1.add(animal);
                    reduceNumber(animal);
                    list.remove(animal);
                    i--;
                }
            }
            return list1;
        }finally {
            getLock().unlock();
        }
    }

    private boolean increaseNumber(Object o) {
        if (o instanceof Bear && number_of_bears < maxCountBears) {
            number_of_bears = number_of_bears + 1;
            return true;
        }
        if (o instanceof Boa && number_of_boa < maxCountBoas) {
            number_of_boa = number_of_boa + 1;
            return true;
        }
        if (o instanceof Eagle && number_of_eagle < maxCountEagles) {
            number_of_eagle = number_of_eagle + 1;
            return true;
        }
        if (o instanceof Fox && number_of_fox < maxCountFoxes) {
            number_of_fox = number_of_fox + 1;
            return true;
        }
        if (o instanceof Wolf && number_of_wolf < maxCountWolfs) {
            number_of_wolf = number_of_wolf + 1;
            return true;
        }
        if (o instanceof Boar && number_of_boars < maxCountBoars) {
            number_of_boars = number_of_boars + 1;
            return true;
        }
        if (o instanceof Buffalo && number_of_buffalo < maxCountBuffaloes) {
            number_of_buffalo = number_of_buffalo + 1;
            return true;
        }
        if (o instanceof Caterpillar && number_of_caterpillars < maxCountCaterpillars) {
            number_of_caterpillars = number_of_caterpillars + 1;
            return true;
        }
        if (o instanceof Deer && number_of_deer < maxCountDeer) {
            number_of_deer = number_of_deer + 1;
            return true;
        }
        if (o instanceof Duck && number_of_ducks < maxCountDucks) {
            number_of_ducks = number_of_ducks + 1;
            return true;
        }
        if (o instanceof Goat && number_of_goats < maxCountGoats) {
            number_of_goats = number_of_goats + 1;
            return true;
        }
        if (o instanceof Horse && number_of_horses < maxCountHorses) {
            number_of_horses = number_of_horses + 1;
            return true;
        }
        if (o instanceof Mouse && number_of_mice < maxCountMice) {
            number_of_mice = number_of_mice + 1;
            return true;
        }
        if (o instanceof Rabbit && number_of_rabbits < maxCountRabbits) {
            number_of_rabbits = number_of_rabbits + 1;
            return true;
        }
        if (o instanceof Sheep && number_of_sheep < maxCountSheep) {
            number_of_sheep = number_of_sheep + 1;
            return true;
        }
        return false;
    }

    private void reduceNumber(Object o) {
        if (o instanceof Bear && number_of_bears > 0) {
            number_of_bears = number_of_bears - 1;
            return;
        }
        if (o instanceof Boa && number_of_boa > 0) {
            number_of_boa = number_of_boa - 1;
            return;
        }
        if (o instanceof Eagle && number_of_eagle > 0) {
            number_of_eagle = number_of_eagle - 1;
            return;
        }
        if (o instanceof Fox && number_of_fox > 0) {
            number_of_fox = number_of_fox - 1;
            return;
        }
        if (o instanceof Wolf && number_of_wolf > 0) {
            number_of_wolf = number_of_wolf - 1;
            return;
        }
        if (o instanceof Boar && number_of_boars > 0) {
            number_of_boars = number_of_boars - 1;
            return;
        }
        if (o instanceof Buffalo && number_of_buffalo > 0) {
            number_of_buffalo = number_of_buffalo - 1;
            return;
        }
        if (o instanceof Caterpillar && number_of_caterpillars > 0) {
            number_of_caterpillars = number_of_caterpillars - 1;
            return;
        }
        if (o instanceof Deer && number_of_deer > 0) {
            number_of_deer = number_of_deer - 1;
            return;
        }
        if (o instanceof Duck && number_of_ducks > 0) {
            number_of_ducks = number_of_ducks - 1;
            return;
        }
        if (o instanceof Goat && number_of_goats > 0) {
            number_of_goats = number_of_goats - 1;
            return;
        }
        if (o instanceof Horse && number_of_horses > 0) {
            number_of_horses = number_of_horses - 1;
            return;
        }
        if (o instanceof Mouse && number_of_mice > 0) {
            number_of_mice = number_of_mice - 1;
            return;
        }
        if (o instanceof Rabbit && number_of_rabbits > 0) {
            number_of_rabbits = number_of_rabbits - 1;
            return;
        }
        if (o instanceof Sheep && number_of_sheep > 0) {
            number_of_sheep = number_of_sheep - 1;
            return;
        }
        if (o instanceof Plant && number_of_plants > 0) {
            number_of_plants = number_of_plants - 1;
        }
    }

}
