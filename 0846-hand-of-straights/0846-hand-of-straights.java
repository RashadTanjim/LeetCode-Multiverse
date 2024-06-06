class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        boolean output = false;
        
        if (hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int first = countMap.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int current = first + i;
                if (!countMap.containsKey(current)) return false;
                int count = countMap.get(current);
                if (count == 1) {
                    countMap.remove(current);
                } else {
                    countMap.put(current, count - 1);
                }
            }
        }

        return true;
    }
}