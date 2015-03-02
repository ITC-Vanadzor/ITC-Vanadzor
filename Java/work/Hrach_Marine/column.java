
public class column{
  public static void  col(int m, int n){
    for (int i=1;i<=m-2;i=i+1){
      System.out.print("*");
      for (int x=1; x<=n-2;x=x+1){
        System.out.print(" ");
      }
      System.out.print("*");
      System.out.print("\n");
    }
  }
}
