package ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;
import ru.javarush.golf.Podkopaev.IslandModel.util.Randomizer;


public class Eagle extends Predator{
    int fox_ver = 10;
    public Eagle(int x, int y) {
        super(x, y);
        weight = 6;
        max_fullness = 1;
        speed = 3;
        horse_ver = 0;
        deer_ver = 0;
        rabbit_ver = 90;
        mouse_ver = 90;
        goat_ver = 0;
        sheep_ver = 0;
        boar_ver = 0;
        buffalo_ver = 0;
        duck_ver = 80;
        fullness = max_fullness/2;
    }

    @Override
    public boolean eat(Object o) {
            if (o instanceof Fox) {
                if (Randomizer.getProbability(fox_ver)) {
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
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public Object reproduce(Object o2) {
        if(o2 instanceof Eagle) {
            return new Eagle(super.x, super.y);
        }
        return null;    }
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
