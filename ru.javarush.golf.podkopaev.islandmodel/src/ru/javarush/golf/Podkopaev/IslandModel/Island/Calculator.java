package ru.javarush.golf.Podkopaev.IslandModel.Island;

import static ru.javarush.golf.Podkopaev.IslandModel.Island.Island.*;

public class Calculator implements Runnable{

    private final GamePoint[][] gameField;
    public Calculator(GamePoint[][] gameField) {
        this.gameField = gameField;
    }
    @Override
    public void run() {
                calculate();
    }

    public synchronized void calculate(){
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                GamePoint gamePoint = gameField[i][j];
                gamePoint.getLock().lock();
                try {
                    gamePoint.calculate();
                }finally {
                    gamePoint.getLock().unlock();
                }
            }
        }
    }
}
