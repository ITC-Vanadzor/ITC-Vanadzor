import java.util.Scanner;

public class Labyrinth {

    static int si, x, y;
    static int sj;
    static int ei;
    static int ej;
    final static int n = 6;
    final static int wall = -3;
    final static int start = -1;
    final static int end = -2;
    final static int max = 1000;
    static int step = 1;
    static int u = 0;//index array length
    static int aa[] = new int[4];
    static int lab[][] = new int[n][n];
    static int index[][] = new int[2][50];

    public static void main(String[] args) {
        setStartMatrix();
        setWallCoordinates();
        inputStartEndCoordinates();
        getFullPaths(si, sj, n, step);
        shortestPath(lab, ei, ej);
    }

    static void setStartMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lab[i][j] = 0;
            }
        }
    }

    static void setWallCoordinates() {
        lab[0][2] = wall;
        lab[1][3] = wall;
        lab[2][1] = wall;
        lab[3][3] = wall;
        lab[3][4] = wall;
        lab[4][2] = wall;
        lab[5][0] = wall;
    }

    static void inputStartEndCoordinates() {

        Scanner in = new Scanner(System.in);
        System.out.println("Insert begin coordinates x and y");
        x = in.nextInt();
        y = in.nextInt();
        while (x < 0 || x > n - 1 || y < 0 || y > n - 1 || lab[x][y] != 0) {
            System.out.println("Insert new start coordinates x and y(0<x<6,0<y<6)");
            x = in.nextInt();
            y = in.nextInt();
        }
        si = x;
        sj = y;
        lab[x][y] = start;
        System.out.println("Insert end coordinates x and y");
        x = in.nextInt();
        y = in.nextInt();
        while (x < 0 || x > n - 1 || y < 0 || y > n - 1 || lab[x][y] != 0) {
            System.out.println("Insert new end coordinates x and y(0<x<6,0<y<6)");
            x = in.nextInt();
            y = in.nextInt();
        }
        ei = x;
        ej = y;
        lab[x][y] = end;
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
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lab[i][j] == -3) {
                    System.out.print("* ");
                } else if (lab[i][j] == -1) {
                    System.out.print("s ");
                } else if (lab[i][j] == -2) {
                    System.out.print("e ");
                } else {
                    System.out.print(lab[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    static void shortestPath(int[][] lab, int ei, int ej) {
        if (ei != si && ej != sj) {
            int m = 0;
            if (ej < n - 1 && lab[ei][ej + 1] > 0) {
                aa[m] = lab[ei][ej + 1];
            } else {
                aa[m] = max;
            }
            System.out.println(aa[m]);
            m++;
            if (ei < n - 1 && lab[ei + 1][ej] > 0) {
                aa[m] = lab[ei + 1][ej];
            } else {
                aa[m] = max;
            }
            System.out.println(aa[m]);
            m++;
            if (ei > 0 && lab[ei - 1][ej] > 0) {
                aa[m] = lab[ei - 1][ej];
            } else {
                aa[m] = max;
            }
            System.out.println(aa[m]);
            m++;
            if (ej > 0 && lab[ei][ej - 1] > 0) {
                aa[m] = lab[ei][ej - 1];
            } else {
                aa[m] = max;
            }
            System.out.println(aa[m]);
            int min = aa[0];
            int minIndex = 0;
            for (int k = 0; k < 2; k++) {
                if (aa[k] > aa[k + 1]) {
                    min = aa[k + 1];
                    minIndex = k + 1;
                }
            }
            System.out.println();
            System.out.println(min);
            System.out.println();
            switch (minIndex) {
                case 0:
                    index[0][u] = ei;
                    index[1][u] = ej + 1;
                    //ej = ej + 1;
                    u++;
                    shortestPath(lab, ei, ej + 1);
                    break;
                case 1:
                    index[0][u] = ei + 1;
                    index[1][u] = ej;
                    //ei = ei + 1;
                    u++;
                    shortestPath(lab, ei + 1, ej);
                    break;
                case 2:
                    index[0][u] = ei - 1;
                    index[1][u] = ej;
                    //ei = ei - 1;
                    u++;
                    shortestPath(lab, ei - 1, ej);
                    break;
                case 3:
                    index[0][u] = ei;
                    index[1][u] = ej - 1;
                    //ej = ei - 1;
                    u++;
                    shortestPath(lab, ei, ej - 1);
                    break;
            }
        } else {
            printLab(index, u);
        }
    }

    static void printLab(int[][] index, int u) {
        for (int f = 0; f < u; f++) {
            int k1 = index[0][u];
            int k2 = index[1][u];
            lab[k1][k2] = -4;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lab[i][j] == wall) {
                    System.out.print("* ");
                } else if (lab[i][j] == start) {
                    System.out.print("s ");
                } else if (lab[i][j] == end) {
                    System.out.print("e ");
                } else if (lab[i][j] == -4) {
                    System.out.print("+ ");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}

