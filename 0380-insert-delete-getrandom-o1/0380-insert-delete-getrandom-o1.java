import java.util.*;

class RandomizedSet {

    private HashSet<Integer> set;
    private Random random;

    public RandomizedSet() {
        this.set = new HashSet();
        this.random = new Random();
    }

    public boolean insert(int val) {

        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {

        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {

        int randomIndex = random.nextInt(set.size());

        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < randomIndex; i++) {
            it.next();
        }

        return it.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */