package ru.javarush.golf.Podkopaev.IslandModel.Plants;

public class Plant {
    private int x;
    private int y;
    int weight = 1;
    int max_population = 200;
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

    public int getWeight() {
        return weight;
    }

    public int getMax_population() {
        return max_population;
    }
}
