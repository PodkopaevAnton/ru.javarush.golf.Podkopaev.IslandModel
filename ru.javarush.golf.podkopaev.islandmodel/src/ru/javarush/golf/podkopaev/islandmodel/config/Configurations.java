package ru.javarush.golf.podkopaev.islandmodel.config;

public class Configurations {

    public static int maxValue(BioTypes bioTypes){
        return switch (bioTypes) {
            case Bear -> 5;
            case Boa, Fox, Wolf -> 30;
            case Eagle, Deer, Horse -> 20;
            case Boar -> 50;
            case Buffalo -> 10;
            case Caterpillar -> 1000;
            case Duck, Plant -> 200;
            case Goat, Sheep -> 140;
            case Mouse -> 500;
            case Rabbit -> 150;
        };
    }

}
