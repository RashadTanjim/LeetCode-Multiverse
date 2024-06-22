class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> oddIndices = new LinkedList<>();
        int subarrays = 0;
        int lastPopped = -1;
        int initialGap = -1;

        for (int i = 0; i < nums.length; i++) {
            // If element is odd, append its index to the list.
            if (nums[i] % 2 == 1) {
                oddIndices.offer(i);
            }
            // If the number of odd numbers exceeds k, remove the first odd index.
            if (oddIndices.size() > k) {
                lastPopped = oddIndices.poll();
            }
            // If there are exactly k odd numbers, add the number of even numbers
            // in the beginning of the subarray to the result.
            if (oddIndices.size() == k) {
                initialGap = oddIndices.element() - lastPopped;
                subarrays += initialGap;
            }
        }

        return subarrays;
    }
}