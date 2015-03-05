import java.util.*;

class Autoservice {    

	Scanner in = new Scanner(System.in);
	int action = -1;
	ArrayList<Car> history = new ArrayList<Car>(); 

	void addRepAuto(Car car) {
		history.add(car);
	}

	void printHistory(){
		for (Car auto:history){
			System.out.println(auto.model + " - " + auto.defect );
		}
	} 

	public void cooseAction(){
		int n = 0;
		int exit = 1;
		Car[] cars = new Car [1000]; 
		while(exit != 0 ){
			while(action != 1 && action != 0 && action != 2 && action != 3){
				System.out.println("set '4', if you want view statisticis\nset '1', if you want add repairing car,\nset '2', if you want print most frequent defect,\nset '3', if you want print most frequent model car.");
				action = in.nextInt();
			}
			switch(action){
				case 4: 	printHistory();
									break;
				case 1:		System.out.println("Please set car model:");
									String model = in.next();
									System.out.println("Please set car defect:");
									String defect = in.next();
									cars[n] = new Car(model, defect);
									addRepAuto(cars[n++]);
									break;
				case 2:		printMostFrequentDefect();
									break;
				case 3:   printMostFrequentModels();
									break;
			}
			System.out.println("Please set 0 for finish and 1 for continue.");
			exit = in.nextInt();
			action = -1;
		}
	}

	int getCountDefect(String def){
		int count = 0;
		for (Car auto:history){
			if(def == auto.defect){
				++count;
			}
		}
		return count;
	} 

	int getCountModel(String model){
		int count = 0;
		for (Car auto:history){
			if(model == auto.model){
				++count;
			}
		}
		return count;
	} 

	void printMostFrequentDefect(){
		Map<String, Integer> defectCounts = new HashMap<String, Integer>();
		for (Car auto:history){
			defectCounts.put(auto.defect, getCountDefect(auto.defect));
		}
		System.out.println(getKeyByMaxValue(defectCounts));
	}

	void printMostFrequentModels(){
		Map<String, Integer> modelsCounts = new HashMap<String, Integer>();
		for (Car auto:history){
			modelsCounts.put(auto.model, getCountModel(auto.model));
		}
		System.out.println(getKeyByMaxValue(modelsCounts));
	}

	String getKeyByMaxValue(Map<String, Integer> elementCounts){
		int max = 0;
		String elemKey = "";
		for (Map.Entry<String,Integer> e : elementCounts.entrySet()){
			if(e.getValue() > max){
				max = e.getValue();
				elemKey = e.getKey();
			}
		}
		return elemKey;
	}
}

