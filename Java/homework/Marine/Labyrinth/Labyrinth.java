import java.util.Random;
import java.util.Scanner;

public class Labyrinth {

    static int si;
    static int sj;
    static int ei;
    static int ej;
    static int n;
    final static int wall = -3;
    final static int start = -1;
    final static int end = -2;
    final static int max = 1000;
    static int step = 1;
    static int u = 0;//index array length
    static int aa[] = new int[4];
    static int lab[][] = new int[1000][1000];
    static int index[][] = new int[2][50];

    public static void main(String[] args) {
        insertLabSize();
        setStartMatrix();
        setWallCoordinates();
        printLab();
        inputStartEndCoordinates(start);
        inputStartEndCoordinates(end);
        getFullPaths(si, sj, n, step);
        shortestPath(ei,ej);
        printLab();
    }

    static void insertLabSize() {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert labyrinth size");
        n = in.nextInt();
    }

    static void setStartMatrix() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                lab[i][j] = 0;
            }
        }
    }

    static void setWallCoordinates() {
        Random rand = new Random();
        for (int i = 0; i < 2 * n; ++i) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            lab[a][b] = wall;
        }
    }

    static void inputStartEndCoordinates(int se) {

        Scanner in = new Scanner(System.in);
        System.out.println("Insert  coordinates x and y");
        int x = in.nextInt();
        int y = in.nextInt();
        while (x < 0 || x > n - 1 || y < 0 || y > n - 1 || lab[x][y] != 0) {
            System.out.println("Insert new  coordinates x and y(0<x<6,0<y<6)");
            x = in.nextInt();
            y = in.nextInt();
        }
        if (se == start) {
            si = x;
            sj = y;
            lab[x][y] = start;
        } else {
            ei = x;
            ej = y;
            lab[x][y] = end;
        }
    }

    static void getFullPaths(int si, int sj, int n, int step) {
        lab[si][sj] = step;
        if ((sj + 1 < n) && (lab[si][sj + 1] == 0 || (lab[si][sj + 1] != wall && lab[si][sj + 1] > step))) {
            getFullPaths(si, sj + 1, n, step + 1);
        }
        if ((si + 1 < n) && (lab[si + 1][sj] == 0 || (lab[si + 1][sj] != wall && lab[si + 1][sj] > step))) {
            getFullPaths(si + 1, sj, n, step + 1);
        }
        if ((sj - 1 >= 0) && (lab[si][sj - 1] == 0 || (lab[si][sj - 1] != wall && lab[si][sj - 1] > step))) {
            getFullPaths(si, sj - 1, n, step + 1);
        }
        if ((si - 1 >= 0) && (lab[si - 1][sj] == 0 || (lab[si - 1][sj] != wall && lab[si - 1][sj] > step))) {
            getFullPaths(si - 1, sj, n, step + 1);
        }
    }

    static void shortestPath(int ei, int ej) {
        if (ei != si || ej != sj) {
            // AREG: think about removing "m" from the indices
            int m = 0;
            if (ej < n - 1 && lab[ei][ej + 1] > 0) {
                aa[m] = lab[ei][ej + 1];
            } else {
                aa[m] = max;
            }
            ++m;
            if (ei < n - 1 && lab[ei + 1][ej] > 0) {
                aa[m] = lab[ei + 1][ej];
            } else {
                aa[m] = max;
            }
            ++m;
            if (ei > 0 && lab[ei - 1][ej] > 0) {
                aa[m] = lab[ei - 1][ej];
            } else {
                aa[m] = max;
            }
            ++m;
            if (ej > 0 && lab[ei][ej - 1] > 0) {
                aa[m] = lab[ei][ej - 1];
            } else {
                aa[m] = max;
            }
            int min = aa[0];
            int minIndex = 0;
            // AREG: change indexes in the iteration to 1->3
            for (int i = 0; i <= 2; ++i) {
                if (min > aa[i + 1]) {
                    min = aa[i + 1];
                    minIndex = i + 1;
                }
            }
            switch (minIndex) {
                case 0:
                    index[0][u] = ei;
                    index[1][u] = ej + 1;
                    u++;
                    shortestPath(ei, ej + 1);
                    break;
                case 1:
                    index[0][u] = ei + 1;
                    index[1][u] = ej;
                    u++;
                    shortestPath(ei + 1, ej);
                    break;
                case 2:
                    index[0][u] = ei - 1;
                    index[1][u] = ej;
                    u++;
                    shortestPath(ei - 1, ej);
                    break;
                case 3:
                    index[0][u] = ei;
                    index[1][u] = ej - 1;
                    u++;
                    shortestPath(ei, ej - 1);
                    break;
            }
        } else {
            matrixConversions();
        }
    }

    static void matrixConversions() {
        for (int j = 0; j < u; j++) {
            int j1 = index[0][j];
            int j2 = index[1][j];
            lab[j1][j2] = -4;
        }
        lab[si][sj] = start;
    }

    static void printLab() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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

