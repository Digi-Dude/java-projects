package main;

import main.model.Do;

import java.util.*;

public class Storage {
    private static int currentId = 1;
    private volatile static Map<Integer, Do> doings = new HashMap<>();

    public static int addDo(Do newDo){
        int id = currentId++;
        newDo.setId(id);
        doings.put(id, newDo);
        return id;
    }

    public static Do getDo(int doId) {
        if (doings.containsKey(doId)) {
            return doings.get(doId);
        }
        return null;
    }

    public static void removeDo (int id) {
        doings.remove(id);
    }

    public static List<Do> getAllDoings() {
        ArrayList<Do> arrayDo = new ArrayList<>(doings.values());
        return arrayDo;
    }

}
