package ru.javarush.golf.podkopaev.islandmodel.plants;

import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;

public class Plant extends Bio {

    private final int x;
    private final int y;

    public Plant(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
