package ru.javarush.golf.Podkopaev.IslandModel.Island;

import java.util.Queue;
import java.util.concurrent.*;

public class Island {
    protected static int sizeX = 10;//100
    protected static int sizeY = 20;//20
    private final boolean STOP_ON_TIMEOUT = true ;
    private final int GAME_DURATION = 10000;
    protected static GamePoint[][] gameField = new GamePoint[sizeY][sizeX];
    private int step = 0;


    public void start() {

        initialize();
        System.out.println("Beginning: ");
        print();
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(2);
        gameScheduledThreadPool.scheduleAtFixedRate(this::runAndWaitAnimals, 0, 2, TimeUnit.SECONDS);

        if (STOP_ON_TIMEOUT) runTimer();
    }

    private void initialize() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                gameField[i][j] = new GamePoint(j, i, sizeX, sizeY);
            }
        }
    }

    private void runAndWaitAnimals() {
        Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();
        tasks.add(new Calculator(gameField));
        tasks.add(new TravelWorker(gameField));
        int CORE_POOL_SIZE = 2;
        ExecutorService fixedThreadPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
            for (Runnable task : tasks) {
                fixedThreadPool.submit(task);
            }
        fixedThreadPool.shutdown();
        try {
            if (fixedThreadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS)) {
                step = step + 1;
                System.out.println("Next step " + step);
                print();
            }
        } catch (InterruptedException e) {
            System.out.println("The game is finished");
        }

    }

    public void print() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.println(gameField[i][j].toString());
            }
        }
    }
    private void runTimer(){
        try {
            Thread.sleep(GAME_DURATION);
        } catch (InterruptedException e) {
            System.out.println("The game is already finished");
        }
        //
        System.out.println("The game is over by timeout");
        System.exit(1);
    }
}