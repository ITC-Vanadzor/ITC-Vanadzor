import java.util.Scanner;

public class MainLab {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert labyrinth size");
        int labsize = in.nextInt();
        Labyrinth lab = new Labyrinth(labsize);
        lab.computeshortestpath();
    }

}

