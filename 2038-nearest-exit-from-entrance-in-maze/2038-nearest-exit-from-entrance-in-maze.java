class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { entrance[0], entrance[1], 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], steps = current[2];

            if ((r != entrance[0] || c != entrance[1]) &&
                    (r == 0 || r == rows - 1 || c == 0 || c == cols - 1)) {
                return steps;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && maze[nr][nc] == '.') {
                    queue.offer(new int[] { nr, nc, steps + 1 });
                    maze[nr][nc] = '+';
                }
            }
        }

        return -1;
    }
}