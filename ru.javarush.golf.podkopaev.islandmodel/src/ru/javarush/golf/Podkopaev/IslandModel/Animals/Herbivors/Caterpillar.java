package ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;

public class Caterpillar extends Herbivore{
    public Caterpillar(int x, int y) {
        super(x, y);
        weight = 0.01;
        max_fullness = 0.001;
        speed = 4;
        fullness = max_fullness/2;
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
    public Object reproduce(Object o2) {
        if(o2 instanceof Caterpillar) {
            return new Caterpillar(super.x, super.y);
        }
        return null;
    }
    @Override
    public boolean eat(Object o) {
        return super.eat(o);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
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