import java.util.Scanner;
public class Labyrinth {
    public static int x, y, i, j, si, sj, ei, ej, step=1,n=6;
    static int lab[] []= new int[6] [6] ;
    public static void main(String[] args) {
      	Scanner in=new Scanner(System.in);
                for (i = 0; i < 6; i++) {
                    for (j = 0; j < 6; j++) {
                        lab[i][j] = 0;
                        System.out.print(lab[i][j] + " ");
                    }
                    System.out.println();
                }
		System.out.println("Insert begin coordinates x and y");
		x=in.nextInt();
		y=in.nextInt();
                lab[x][y]=-1;
                System.out.println("Insert end coordinates x and y");
                x = in.nextInt();
                y = in.nextInt();
                lab[0][2]=-3;
                lab[1][3]=-3;
                lab[2][1]=-3;
                lab[3][3]=-3;
                lab[3][4]=-3;
                lab[4][2]=-3;
                lab[5][0]=-3;
                lab[x][y]=-2;
                printMatrix(lab);
                
		
    }
    public static void printMatrix(int[][] lab) {
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                if (lab[i][j]==-3){
                    System.out.print("* ");
                }
                else if (lab[i][j]==-1) {
                    System.out.print("s ");
                    si=i;
                    sj=j;
                }
                else if (lab[i][j]==-2) {
                    System.out.print("e ");
                    ei=i;
                    ej=j;
                }
                else {
                    System.out.print(lab[i][j]+" ");
                }
            }
            System.out.println();
        }
        away(lab,si,sj,n,step);
    }
    public static void away(int[][] lab,int si,int sj,int n, int step) {
        lab[si][sj]=step;
        if (sj+1<n){
            if (lab[si][sj+1]==0 || (lab[si][sj+1]!=-3 && lab[si][sj+1]>step)){
                away(lab,si,sj+1,n,step+1);
            }    
        }
        if (si+1<n){
            if (lab[si+1][sj]==0 || (lab[si+1][sj]!=-3 && lab[si+1][sj]>step)){
                away(lab,si+1,sj,n,step+1);
            }    
        }
        if (sj-1>=0){
            if (lab[si][sj-1]==0 || (lab[si][sj-1]!=-3 && lab[si][sj-1]>step)){
                away(lab,si,sj-1,n,step+1);
            }    
        }
        if (si-1>=0){
            if (lab[si-1][sj]==0 || (lab[si-1][sj]!=-3 && lab[si-1][sj]>step)){
                away(lab,si-1,sj,n,step+1);
            }    
        }
        /*for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                if (lab[i][j]==-3){
                    System.out.print("* ");
                }
                else if (lab[i][j]==-1) {
                    System.out.print("s ");
                }
                else if (lab[i][j]==-2) {
                    System.out.print("e ");
                }
                else {
                    System.out.print(lab[i][j]+" ");
                }
            }
            System.out.println();
        }System.out.println();System.out.println();*/
    }
    
    
}

