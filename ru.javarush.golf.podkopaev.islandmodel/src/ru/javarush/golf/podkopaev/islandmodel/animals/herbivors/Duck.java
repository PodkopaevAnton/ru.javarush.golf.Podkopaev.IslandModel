package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;

public class Duck extends Herbivore{

    int ProbabilityOfEatCaterpillar = 90;

    public Duck(int x, int y) {
        super(x, y);
        weight = 1;
        maxFullness = 0.15;
        speed = 4;
        fullness = maxFullness /4;
    }

    @Override
    public boolean eat(Bio bio) {
                if (bio instanceof Caterpillar) {
                    if (Randomizer.getProbability(ProbabilityOfEatCaterpillar)){
                        return true;
                    }
                }
        return super.eat(bio);
    }

    @Override
    public Duck reproduce(Animal animal) {
        return new Duck(x,y);
    }
}
