package ru.javarush.golf.Podkopaev.IslandModel.Animals;

import ru.javarush.golf.Podkopaev.IslandModel.Island.Direction;

public abstract class Animal {
     protected int speed;
     protected int x;
     protected int y;
     protected double weight;
     protected double max_fullness;
    protected double fullness;
    protected boolean tired = false;

    public abstract boolean eat(Object o);

    public Animal(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP -> this.y++;
            case DOWN -> this.y--;
            case LEFT -> this.x--;
            case RIGHT -> this.x++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void returnHome(int x, int y){
        this.x = x;
        this.y = y;
    }

    public  Object reproduce(Object o2){
        return null;}

    public double getWeight() { //добавил 27.07
        return weight;
    }

    public double getFullness() {
        return fullness;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }

    public int getSpeed() {
        return speed;
    }

    public double hunger(double fullness){

        this.fullness = fullness - fullness/2;
        return fullness;
    }


    public double getMax_fullness() {
        return max_fullness;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }
}
