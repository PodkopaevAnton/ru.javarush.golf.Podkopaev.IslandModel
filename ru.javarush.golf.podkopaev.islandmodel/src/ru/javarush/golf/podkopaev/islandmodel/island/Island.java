package ru.javarush.golf.podkopaev.islandmodel.island;

import ru.javarush.golf.podkopaev.islandmodel.services.CalculationWorker;
import ru.javarush.golf.podkopaev.islandmodel.services.TravelWorker;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Island {

    protected int sizeX = 2;//100
    protected int sizeY = 2;//20
    private final World world = new World(sizeY,sizeX);
    private int step = 0;

    public void start() {
        world.print();
        System.out.println("Beginning: ");
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(4);
        gameScheduledThreadPool.scheduleAtFixedRate(this::calculateAndMoveAnimals,0,2,TimeUnit.SECONDS);
        runTimer();
    }
    private void calculateAndMoveAnimals(){
        List<Area[]> divideAreas = world.divideWorld();
        Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();
        for (Area[] areas: divideAreas) {
            tasks.add(new CalculationWorker(areas));
        }
        for (Area[] areas: divideAreas) {
            tasks.add(new TravelWorker(areas,world.getAreas(),"Predator"));
            tasks.add(new TravelWorker(areas,world.getAreas(),"Herbivore"));
        }
        int CORE_POOL_SIZE = 4;
        ExecutorService fixedThreadPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        for (Runnable task : tasks) {
            fixedThreadPool.submit(task);
        }
        fixedThreadPool.shutdown();
        try {
            if (fixedThreadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS)) {
                step = step + 1;
                System.out.println("Next step " + step);
                world.print();
            }
        } catch (InterruptedException e) {
            System.out.println("The game is finished");
        }
    }

    private void runTimer(){
        try {
            int GAME_DURATION = 20000;
            Thread.sleep(GAME_DURATION);
        } catch (InterruptedException e) {
            System.out.println("The game is already finished");
        }
        //
        System.out.println("The game is over by timeout");
        world.print();
        System.exit(1);
    }
}