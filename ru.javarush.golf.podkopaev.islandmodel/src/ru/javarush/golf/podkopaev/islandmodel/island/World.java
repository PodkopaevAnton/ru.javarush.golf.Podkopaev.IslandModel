package ru.javarush.golf.podkopaev.islandmodel.island;

import java.util.ArrayList;
import java.util.List;

public class World {

    private final Area[][] areas;
    private final int sizeX;//100
    private final int sizeY;//20
    private final List<Area> listOfAreas = new ArrayList<>();
    private final Area[] listOfAreas1;

    public World(int rows, int cols) {
        areas = new Area[rows][cols];
        sizeX = cols;
        sizeY = rows;
        listOfAreas1 = new Area[cols*rows];
        initialize();
    }

    public Area[][] getAreas() {
        return areas;
    }

    public void print() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.println(areas[i][j].toString());
            }
        }
    }

    public List<Area[]> divideWorld() {
        List<Area[]> dividedAreas = new ArrayList<>();
        if (listOfAreas.size() / 4 != 0) {
            Area[] dividedArea1 = new Area[listOfAreas1.length / 4];
            Area[] dividedArea2 = new Area[listOfAreas1.length / 4];
            Area[] dividedArea3 = new Area[listOfAreas1.length / 4];
            int length4 = listOfAreas1.length - 3 * listOfAreas1.length / 4;
            Area[] dividedArea4 = new Area[length4];
            System.arraycopy(listOfAreas1,0,dividedArea1,0,(listOfAreas1.length / 4));
            System.arraycopy(listOfAreas1,listOfAreas1.length / 4,dividedArea2,0,(listOfAreas1.length / 4));
            System.arraycopy(listOfAreas1,listOfAreas1.length / 2,dividedArea3,0,(listOfAreas1.length / 4));
            System.arraycopy(listOfAreas1,3*listOfAreas1.length / 4,dividedArea4,0, length4);
            dividedAreas.add(dividedArea1);
            dividedAreas.add(dividedArea2);
            dividedAreas.add(dividedArea3);
            dividedAreas.add(dividedArea4);
        }else {
            dividedAreas.add(listOfAreas1);
        }
        return dividedAreas;
    }

    private void initialize() {
        int index = 0;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                areas[i][j] = new Area(j, i, sizeX, sizeY);
                listOfAreas.add(areas[i][j]);
                listOfAreas1[index++] = areas[i][j];
            }
        }
    }

}
