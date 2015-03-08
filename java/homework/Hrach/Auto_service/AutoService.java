import java.util.Scanner;


class AutoService{
	final static int r = 100;//max rows for history
	final static int c = 2;//columns for history
	static int k = 0;
	static String[][] history=new String[r][c];//array for repaird cars
	static String[] models={"BMW","Mersedes","Lexus","Mazda"};
	static String[] defects={"engine","turbines","shock absorbers"};

	public  static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("input 1 for repair car, 2 for print maximum repaired model, 3 for print maximum repaired defect, 4 for break");	
			int a = in.nextInt();
			if (a==1) {
				repair();
			} else if (a==2) {
				System.out.println(returnMaxRepairedModel());
			} else if (a==3) {
				System.out.println(returnMaxRepairedDefect());
			} else if (a==4) {
				break;
			} else {
				System.out.println("Incorrect input");
			}
		}
	}

	public static void repair(){
		boolean n = true;
		boolean m = true;
		if(k==100) {
			System.out.println("history refilled");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Insert car model");
		String model = in.next();
        // AREG: use equals() to compare objects and == to compare references
		for (int i=0; i<models.length; ++i) {
			if (model.equals(models[i])) {
				n=false;
				break;
			}
		}
		if (n) {
			System.out.println("Incorrect model");
			repair();
		}
		System.out.println("Insert car defect");
		String  defect = in.next();
		for (int i=0; i<defects.length; ++i) {
			if (defect.equals(defects[i])) {
				m=false;
				break;
			}
		}
		if (m) {
			System.out.println("Incorrect defect");
			repair();
		}
		Car carsdata = new Car(model,defect);
		history[k][0]=carsdata.getModel();
		history[k][1]=carsdata.getDefect();
		++k;
	}

	static String returnMaxRepairedModel() {
		if (history[0][0]==null) {
			return "cars not exists";
		}
		int c;
		String model = "";
		int max = 0;
		for (int x=0; x<models.length; ++x) {
			c=0;
			for (int i=0; i<r; ++i) {
				if (history[i][0]==null) {
					break;
				} else if (history[i][0].equals(models[x])) {
					c++;
				}
			}
			if (c>max) {
				max = c;
				model = models[x];
			}
		}
		return model;
	}

	static String returnMaxRepairedDefect() {
		if (history[0][0]==null) {
			return "cars not exists";
		}
		int c;
		String defect = "";
		int max = 0;
		for (int x=0; x<defects.length; ++x) {
			c=0;
			for (int i=0; i<r; ++i) {
				if (history[i][1]==null) {
					break;
				} else if (history[i][1].equals(defects[x])) {
					c++;
				}
			}
			if (c>max) {
				max = c;
				defect = defects[x];
			}
		}
		return defect;
	}
}
