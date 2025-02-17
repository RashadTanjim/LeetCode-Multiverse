class Solution {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0)
            return 0;
            
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPosition) {
                arrowPosition = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }
}