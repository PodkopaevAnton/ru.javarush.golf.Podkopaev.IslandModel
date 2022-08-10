package ru.javarush.golf.Podkopaev.IslandModel.util;

import java.util.concurrent.ThreadLocalRandom;

// НУЖЕН И ФИНАЛЬНЫМ ДАННЫЙ КЛАСС

public class Randomizer {

    public static boolean getProbability(int percent) {return getRandom(0, 100) < percent;}

    public static int getRandom(int from, int to) { return ThreadLocalRandom.current().nextInt(from, to + 1); }

    public static int getRandom(int x) { return ThreadLocalRandom.current().nextInt(x); }

}
