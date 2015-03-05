import java.util.Scanner;


class AutoService{
    static String[][] history=new String[100][2];
    static String[] cars={"BMW","Mersedes","Lexus","Mazda"};
    static String[] defects={"engine","turbines","shock absorbers"};
      
      public  static void main(String[] args){

  repair();
    for (int i=0; i<100; ++i) {
        if (hsitory[i][0]==cars[0]) {
            c++;
    }
    }
    public static void repair(){
         Scanner in = new Scanner(System.in);
         
         for (int i=0;i<5;++i){
                 System.out.println("Insert model car");
                         String model = in.next();
                 System.out.println("Insert car defect");
                        String  defect = in.next();
                         Car carsdata = new Car(model,defect);
                          history[i][0]=carsdata.getModel();
                          history[i][1]=carsdata.getDefect();
         
         }

    }


}
