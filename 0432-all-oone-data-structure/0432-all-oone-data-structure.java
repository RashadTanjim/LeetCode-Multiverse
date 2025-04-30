public class AllOne {

    class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
        }
    }

    private Map<String, Integer> keyCount;
    private Map<Integer, Bucket> countBucket;
    private Bucket head, tail;

    public AllOne() {
        keyCount = new HashMap<>();
        countBucket = new HashMap<>();
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        keyCount.put(key, count + 1);

        Bucket currBucket = countBucket.get(count);
        Bucket newBucket = countBucket.get(count + 1);

        if (newBucket == null) {
            newBucket = new Bucket(count + 1);
            countBucket.put(count + 1, newBucket);
            insertAfter(currBucket == null ? head : currBucket, newBucket);
        }

        newBucket.keys.add(key);

        if (currBucket != null) {
            currBucket.keys.remove(key);
            if (currBucket.keys.isEmpty()) {
                remove(currBucket);
                countBucket.remove(count);
            }
        }
    }

    public void dec(String key) {
        if (!keyCount.containsKey(key))
            return;

        int count = keyCount.get(key);
        Bucket currBucket = countBucket.get(count);

        if (count == 1) {
            keyCount.remove(key);
        } else {
            keyCount.put(key, count - 1);
            Bucket newBucket = countBucket.get(count - 1);
            if (newBucket == null) {
                newBucket = new Bucket(count - 1);
                countBucket.put(count - 1, newBucket);
                insertBefore(currBucket, newBucket);
            }
            newBucket.keys.add(key);
        }

        currBucket.keys.remove(key);
        if (currBucket.keys.isEmpty()) {
            remove(currBucket);
            countBucket.remove(count);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head)
            return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail)
            return "";
        return head.next.keys.iterator().next();
    }

    private void insertAfter(Bucket prev, Bucket newBucket) {
        newBucket.next = prev.next;
        newBucket.prev = prev;
        prev.next.prev = newBucket;
        prev.next = newBucket;
    }

    private void insertBefore(Bucket next, Bucket newBucket) {
        newBucket.prev = next.prev;
        newBucket.next = next;
        next.prev.next = newBucket;
        next.prev = newBucket;
    }

    private void remove(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */