package ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;

public class Wolf extends Predator{

    @Override
    public boolean eat(Object o) {
        return super.eat(o);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
    }
    public Wolf(int x, int y){
        super(x,y);
        weight = 50;
        max_fullness = 8;
        speed = 3;
        horse_ver = 10;
        deer_ver = 15;
        rabbit_ver = 60;
        mouse_ver = 80;
        goat_ver = 60;
        sheep_ver = 70;
        boar_ver = 15;
        buffalo_ver = 10;
        duck_ver = 40;
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
        if(o2 instanceof Wolf) {
            return new Wolf(super.x, super.y);
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
