import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Autoservice {
    String maxRepairedModel;
    String maxRepaireddefect;
    List<String> repairedModels;
    List<String> repairedDefects;
    
    public Autoservice(){
        maxRepairedModel = "";
        maxRepaireddefect = "";
        repairedModels = new ArrayList<String>();
        repairedDefects = new ArrayList<String>();
    }
    public void repair(Car car){
        repairedModels.add(car.getModel());
        repairedDefects.add(car.getDefects());
        maxRepairedModel = GetMostCommonModel();
        maxRepaireddefect = GetMostCommonDefect();
    }
    private String GetMostCommonModel(){
        Map<String,Integer> mymap= new HashMap<String,Integer>();
        for (int i = 0; i<repairedModels.size();++i){
            Integer count = mymap.get(repairedModels.get(i));
            mymap.put(repairedModels.get(i),count == null ? 1 : count + 1);
        }
        Map.Entry<String,Integer> max = null;
        for (Map.Entry<String, Integer> e : mymap.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }
        return max.getKey();
    }
    private String GetMostCommonDefect(){
        Map<String,Integer> mymap= new HashMap<String,Integer>();
        for (int i = 0; i < repairedDefects.size();++i){
            Integer count = mymap.get(repairedDefects.get(i));
            mymap.put(repairedDefects.get(i),count == null ? 1 : count + 1);
        }
        Map.Entry<String,Integer> max = null;
        for (Map.Entry<String, Integer> e : mymap.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }
        return max.getKey();
    }
    public String GetMaxModel(){ return maxRepairedModel;}
    public String GetMaxDefect(){ return maxRepaireddefect;}
}
