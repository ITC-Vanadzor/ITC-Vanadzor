import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Autoservice {
   // String maxRepairedModel;
   // String maxRepaireddefect;
    List<String> repairedModels;
    List<String> repairedDefects;
    
    public Autoservice(){
        maxRepairedModel = "";
        maxRepaireddefect = "";
        repairedModels = new ArrayList();
        repairedDefects = new ArrayList();
    }
    public void addRepairedModel(Car car){
        repairedModels.add(car.getModel());
    }
    public void addRepairedDefects(Car car){
        repairedDefects.add(car.getDefects());
    }
    private String findMostCommonModel(){
        Map<String,int> mymap= new HashMap<String,int>();
        for (int i = 0; i<repairedModels.size();++i){
            int count = mymap.repairedModels.get(i);
            M
        }
    }
    public String GetmaxRepModel(){
        findMostCommonModel();
        return maxRepModel;
    }
}
