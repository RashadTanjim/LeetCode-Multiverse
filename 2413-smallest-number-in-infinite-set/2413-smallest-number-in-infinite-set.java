class SmallestInfiniteSet {

    private PriorityQueue<Integer> minHeap;
    private Set<Integer> addedBack;
    private int current;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        addedBack = new HashSet<>();
        current = 1;
    }

    public int popSmallest() {
        
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBack.remove(smallest);
            return smallest;
        } else {
            return current++;
        }
    }

    public void addBack(int num) {
        if (num < current && !addedBack.contains(num)) {
            minHeap.offer(num);
            addedBack.add(num);
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */