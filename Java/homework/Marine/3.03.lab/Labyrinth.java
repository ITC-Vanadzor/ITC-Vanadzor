package labyrinth;

import java.util.Scanner;

public class Labyrinth {

    static int si;
    static int sj;
    static int ei;
    static int ej;
    final static int n = 6;
    final static int wall = -3;
    final static int start = -1;
    final static int end = -2;
    final static int max=1000;
    static int step = 1;
    static int u = 0;//index array length
    static int aa[] = new int[4];
    static int lab[][] = new int[n][n];
    static int index[][] = new int[2][50];

    public static void main(String[] args) {
        InputMatrix();
        InputCoordinates();
        GetFullPaths(lab, si, sj, n, step);
        ShortestPath(lab, ei, ej);
    }
    public static void InputMatrix() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                lab[i][j]=0;
            }
        }
    public static void InputCoordinates() {

        Scanner in = new Scanner(System.in);
        System.out.println("Insert begin coordinates x and y");
        int x = in.nextInt();
        si = x;
        int y = in.nextInt();
        sj = y;
        lab[x][y] = start;
        System.out.println("Insert end coordinates x and y");
        x = in.nextInt();
        ei = x;
        y = in.nextInt();
        ej = y;
        lab[0][2] = wall;
        lab[1][3] = wall;
        lab[2][1] = wall;
        lab[3][3] = wall;
        lab[3][4] = wall;
        lab[4][2] = wall;
        lab[5][0] = wall;
        lab[x][y] = end;

    }

    public static void GetFullPaths(int[][] lab, int si, int sj, int n, int step) {
        lab[si][sj] = step;
        if ((sj + 1 < n) && (lab[si][sj + 1] == 0 || (lab[si][sj + 1] != wall && lab[si][sj + 1] > step))) {
            GetFullPaths(lab, si, sj + 1, n, step + 1);
        }
        if ((si + 1 < n) && (lab[si + 1][sj] == 0 || (lab[si + 1][sj] != wall && lab[si + 1][sj] > step))) {
            GetFullPaths(lab, si + 1, sj, n, step + 1);
        }
        if ((sj - 1 >= 0) && (lab[si][sj - 1] == 0 || (lab[si][sj - 1] != wall && lab[si][sj - 1] > step))) {
            GetFullPaths(lab, si, sj - 1, n, step + 1);
        }
        if ((si - 1 >= 0) && (lab[si - 1][sj] == 0 || (lab[si - 1][sj] != wall && lab[si - 1][sj] > step))) {
            GetFullPaths(lab, si - 1, sj, n, step + 1);
        }
        /* (int i = 0; i < 6; i++) {
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
        System.out.println();*/
    }

    public static void ShortestPath(int[][] lab, int ei, int ej) {
        if (ei != si && ej != sj) {
            int m = 0;
            if (ej < n) {
                aa[m] = lab[ei][ej + 1];
                m++;
            } else {
                aa[m] = max;
            }
            if (ei < n) {
                aa[m] = lab[ei + 1][ej];
                m++;
            } else {
                aa[m] = max;
            }
            if (ei > 0) {
                aa[m] = lab[ei - 1][ej];
                m++;
            } else {
                aa[m] = max;
            }x
            if (ej > 0) {
                aa[m] = lab[ei][ej - 1];
                m++;
            } else {
                aa[m] = max;
            }
            int min = aa[0];
            int minIndex = 0;
            for (int k = 0; k < 2; k++) {
                if (aa[k] > aa[k + 1]) {
                    min = aa[k + 1];
                    minIndex = k + 1;
                }
            }
            switch (minIndex) {
                case 0:
                    index[1][u] = ei;
                    index[2][u] = ej + 1;
                    ej = ej + 1;
                    u++;
                    ShortestPath(lab, ei, ej + 1);
                    break;
                case 1:
                    index[1][u] = ei + 1;
                    index[2][u] = ej;
                    ei = ei + 1;
                    u++;
                    ShortestPath(lab, ei + 1, ej);
                    break;
                case 2:
                    index[1][u] = ei - 1;
                    index[2][u] = ej;
                    ei = ei - 1;
                    u++;
                    ShortestPath(lab, ei - 1, ej);
                    break;
                case 3:
                    index[1][u] = ei;
                    index[2][u] = ej - 1;
                    ei = ei - 1;
                    u++;
                    ShortestPath(lab, ei, ej - 1);
                    break;
            }
        } else {
            PrintLab(index, u);
        }
    }

    public static void PrintLab(int[][] index, int u) {
        for (int f = 0; f < u; f++) {
            int k1 = index[1][u];
            int k2 = index[2][u];
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

