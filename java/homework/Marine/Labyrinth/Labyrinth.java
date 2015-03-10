package mainlab;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Labyrinth {

    int startx;
    int starty;
    int endx;
    int endy;
    int labsize;
    int wall = -3;
    int start = -1;
    final int end = -2;
    final int max = Integer.MAX_VALUE;
    int step = 1;
    public int aa[] = new int[4];
    public int lab[][] = new int[1000][1000];
    ArrayList<PathIndex> pathindex = new ArrayList<>();

    public Labyrinth(int n) {
        this.labsize = n;
        Random rand = new Random();
        for (int i = 0; i < 2 * labsize; ++i) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            lab[a][b] = wall;
        }
    }

    public void computeshortestpath() {
        printLab();
        inputStartEndCoordinates(start);
        inputStartEndCoordinates(end);
        getFullPaths(startx, starty, labsize, step);
        shortestPath(endx, endy);
        printLab();
    }

    void inputStartEndCoordinates(int se) {

        Scanner in = new Scanner(System.in);
        System.out.println("Insert  coordinates x and y");
        int x = in.nextInt();
        int y = in.nextInt();
        while (x < 0 || x > labsize - 1 || y < 0 || y > labsize - 1 || lab[x][y] != 0) {
            System.out.println("Insert new  coordinates x and y(0<x<" + labsize + ",0<y<" + labsize + ")");
            x = in.nextInt();
            y = in.nextInt();
        }
        if (se == start) {
            startx = x;
            starty = y;
            lab[x][y] = start;
        } else {
            endx = x;
            endy = y;
            lab[x][y] = end;
        }
    }

    void getFullPaths(int startx, int starty, int labsize, int step) {
        lab[startx][starty] = step;
        if ((starty + 1 < labsize) && (lab[startx][starty + 1] == 0 || (lab[startx][starty + 1] != wall && lab[startx][starty + 1] > step))) {
            getFullPaths(startx, starty + 1, labsize, step + 1);
        }
        if ((startx + 1 < labsize) && (lab[startx + 1][starty] == 0 || (lab[startx + 1][starty] != wall && lab[startx + 1][starty] > step))) {
            getFullPaths(startx + 1, starty, labsize, step + 1);
        }
        if ((starty - 1 >= 0) && (lab[startx][starty - 1] == 0 || (lab[startx][starty - 1] != wall && lab[startx][starty - 1] > step))) {
            getFullPaths(startx, starty - 1, labsize, step + 1);
        }
        if ((startx - 1 >= 0) && (lab[startx - 1][starty] == 0 || (lab[startx - 1][starty] != wall && lab[startx - 1][starty] > step))) {
            getFullPaths(startx - 1, starty, labsize, step + 1);
        }
    }

    void shortestPath(int endx, int endy) {
        if (endx != startx || endy != starty) {
            if (endy < labsize - 1 && lab[endx][endy + 1] > 0) {
                aa[0] = lab[endx][endy + 1];
            } else {
                aa[0] = max;
            }
            if (endx < labsize - 1 && lab[endx + 1][endy] > 0) {
                aa[1] = lab[endx + 1][endy];
            } else {
                aa[1] = max;
            }
            if (endx > 0 && lab[endx - 1][endy] > 0) {
                aa[2] = lab[endx - 1][endy];
            } else {
                aa[2] = max;
            }
            if (endy > 0 && lab[endx][endy - 1] > 0) {
                aa[3] = lab[endx][endy - 1];
            } else {
                aa[3] = max;
            }
            int min = aa[0];
            int minIndex = 0;
            for (int i = 1; i <= 3; ++i) {
                if (min > aa[i]) {
                    min = aa[i];
                    minIndex = i;
                }
            }
            switch (minIndex) {
                case 0:
                    PathIndex shortestpathindex = new PathIndex(endx, endy + 1);
                    pathindex.add(shortestpathindex);
                    shortestPath(endx, endy + 1);
                    break;
                case 1:
                    PathIndex shortestpathindex1 = new PathIndex(endx + 1, endy);
                    pathindex.add(shortestpathindex1);
                    shortestPath(endx + 1, endy);
                    break;
                case 2:
                    PathIndex shortestpathindex2 = new PathIndex(endx - 1, endy);
                    pathindex.add(shortestpathindex2);
                    shortestPath(endx - 1, endy);
                    break;
                case 3:
                    PathIndex shortestpathindex3 = new PathIndex(endx, endy - 1);
                    pathindex.add(shortestpathindex3);
                    shortestPath(endx, endy - 1);
                    break;
            }
        } else {
            setShortestPathElements();
        }
    }

    void setShortestPathElements() {
        pathindex.stream().forEach((index) -> {
            lab[index.x][index.y] = -4;
        });
    }

    void printLab() {
        for (int i = 0; i < labsize; i++) {
            for (int j = 0; j < labsize; j++) {
                if (lab[i][j] == wall) {
                    System.out.print("* ");
                } else if (lab[i][j] == start) {
                    System.out.print("s ");
                } else if (lab[i][j] == end) {
                    System.out.print("e ");
                } else if (lab[i][j] == -4) {
                    System.out.print("@ ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

