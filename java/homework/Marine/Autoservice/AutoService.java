import java.util.*;

public class AutoService {
    ArrayList<Car> history = new ArrayList<Car>();

    public void addRepairHistory(Car data) {
        history.add(data);
    }

    public int getModelCount(String mod) {
        int index = 0;
        for (Car carhistory : history) {
            if (mod.equals(carhistory.model)) {
                index++;
            }
        }
        return index;
    }

    public int getDefectCount(String def) {
        int index = 0;
        for (Car carhistory : history) {
            if (def.equals(carhistory.defect)) {
                index++;
            }
        }
        return index;
    }

    public String getMaxRepairDefect() {
        Map<String, Integer> defectlist = new HashMap<String, Integer>();
        int max = 0;
        String maxdef = "";
        for (Car carhistory : history) {
            defectlist.put(carhistory.defect, getDefectCount(carhistory.defect));
        }
        for (Map.Entry<String, Integer> entry : defectlist.entrySet()) {
            if (max < entry.getValue()) {
                maxdef = entry.getKey();
                max = entry.getValue();
            }

        }
        return maxdef;
    }
    public String getMaxRepairModel() {
        Map<String, Integer> modellist = new HashMap<String, Integer>();
        int max = 0;
        String maxmodel = "";
        for (Car carhistory : history) {
            modellist.put(carhistory.model, getModelCount(carhistory.model));
        }
        for (Map.Entry<String, Integer> entry : modellist.entrySet()) {
            if (max < entry.getValue()) {
                maxmodel = entry.getKey();
                max = entry.getValue();
            }
        }
        return maxmodel;

    }
}

