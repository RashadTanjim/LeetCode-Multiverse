import java.util.*;

class RandomizedSet {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> map; // Maps value to its index in the list

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    private boolean search(int val) {
        return map.containsKey(val);
    }

    public boolean insert(int val) {

        if (search(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!search(val))
            return false;

        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */