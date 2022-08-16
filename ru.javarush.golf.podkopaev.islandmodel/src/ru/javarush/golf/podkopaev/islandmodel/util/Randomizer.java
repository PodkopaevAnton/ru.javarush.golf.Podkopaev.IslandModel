package ru.javarush.golf.podkopaev.islandmodel.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static boolean getProbability(int percent) {return getRandom(0, 100) < percent;}

    public static int getRandom(int from, int to) { return ThreadLocalRandom.current().nextInt(from, to + 1); }

    public static int getRandom(int x) { return ThreadLocalRandom.current().nextInt(x); }

}
