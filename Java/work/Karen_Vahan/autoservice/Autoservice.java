import java.util.*;

class Autoservice {    
    private ArrayList<Car> history = new ArrayList<Car>(); 

    public Autoservice() {

    }
    
    public void addRepAuto(Car transport) {
        history.add(transport);
    }

    public void printHistory(){
        for (Car auto:history){
            System.out.println(auto.model + " - " + auto.defect );
        }
    } 

    public int getCountDefect(String def){
        int count = 0;
        for (Car auto:history){
            if(def == auto.defect){
                ++count;
            }
        }
        return count;
    } 
    
    public String getMaxDefect(){
        Map<String, Integer> defectCounts = new HashMap<String, Integer>();
        int max = 0;
        String defect;
        for (Car auto:history){
            defectCounts.put(auto.defect, getCountDefect(auto.defect));
        }
         
        for (Iterator count:defectCounts){
            if(max < )
        }
    }

}

