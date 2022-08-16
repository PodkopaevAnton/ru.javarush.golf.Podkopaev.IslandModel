package ru.javarush.golf.podkopaev.islandmodel.animals;

import ru.javarush.golf.podkopaev.islandmodel.island.Direction;

public abstract class Animal extends Bio{

     protected int speed;
     protected int x;
     protected int y;
     protected double maxFullness;
     protected double fullness;
     protected boolean isTired = false;

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

    public double getFullness() {
        return fullness;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }

    public int getSpeed() {
        return speed;
    }

    public void hunger(double fullness){

        this.fullness = fullness - fullness/2;
    }

    public abstract boolean eat(Bio bio);

    public double getMaxFullness() {
        return maxFullness;
    }

    public boolean isTired() {
        return !isTired;
    }

    public void setTired(boolean isTired) {
        this.isTired = isTired;
    }

    public Animal reproduce(Animal animal){
        return null;
    }

}
