import java.util.*;

class RandomizedSet {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> map; // Maps value to its index in the list
    private int size = 0;
    private Random rand;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    private boolean search(int val) {
        return map.containsKey(val);
    }

    public boolean insert(int val) {

        if (search(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        size++;

        return true;
    }

    public boolean remove(int val) {

        if (!search(val))
            return false;

        int index = map.get(val);
        int temp = list.get(size - 1);

        list.set(index, temp);
        map.put(temp, index);

        list.remove(size - 1);
        map.remove(val);
        size--;

        return true;
    }

    public int getRandom() {
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