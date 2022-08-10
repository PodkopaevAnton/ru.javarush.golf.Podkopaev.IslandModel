package ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;

public class Horse extends Herbivore{

    @Override
    public boolean eat(Object o) {
        return super.eat(o);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
    }
    public Horse(int x, int y){
        super(x,y);
        weight = 400;
        max_fullness = 60;
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
        if(o2 instanceof Horse) {
            return new Horse(super.x, super.y);
        }
        return null;
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
