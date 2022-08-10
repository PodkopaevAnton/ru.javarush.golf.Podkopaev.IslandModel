package ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;
import ru.javarush.golf.Podkopaev.IslandModel.util.Randomizer;

public class Bear extends Predator{
    int boa_ver = 80;

    public Bear(int x, int y) {
        super(x, y);
        weight = 500;
        max_fullness = 80;
        speed = 2;
        horse_ver = 40;
        deer_ver = 80;
        rabbit_ver = 80;
        mouse_ver = 90;
        goat_ver = 70;
        sheep_ver = 70;
        boar_ver = 50;
        buffalo_ver = 20;
        duck_ver = 10;
        fullness = max_fullness/2;
    }

    @Override
    public boolean eat(Object o) {
            if (o instanceof Boa) {
                if (Randomizer.getProbability(boa_ver)) {
                    //System.out.println(this.getClass().getName() + " съел " + o.getClass().getName());
                    return true;
                }
            }
        return super.eat(o);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
    }

    @Override
    public Object reproduce(Object o2) {
        if(o2 instanceof Bear) {
            return new Bear(super.x, super.y);
        }
        return null;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public double getFullness() {
        return super.getFullness();
    }

    @Override
    public void setFullness(double fullness) {
        super.setFullness(fullness);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    @Override
    public double hunger(double fullness) {
        return super.hunger(fullness);
    }


    @Override
    public double getMax_fullness() {
        return super.getMax_fullness();
    }

    @Override
    public void returnHome(int x, int y) {
        super.returnHome(x, y);
    }
    @Override
    public boolean isTired() {
        return super.isTired();
    }

    @Override
    public void setTired(boolean tired) {
        super.setTired(tired);
    }
}
