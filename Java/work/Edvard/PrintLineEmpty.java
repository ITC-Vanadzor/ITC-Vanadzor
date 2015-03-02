public class PrintLineEmpty {
    public static void printLineEmpty(int point) {
        System.out.print('*');
        for (int i = 1; i <= (point - 2); i++) {
        System.out.print(' ');
        }
        System.out.print('*');
        System.out.println();
    }
}
