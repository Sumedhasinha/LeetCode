class Solution {

    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int fresh = 0;

        // Put all rotten oranges in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {

            Pair current = q.poll();

            int row = current.row;
            int col = current.col;
            int t = current.time;

            time = Math.max(time, t);

            // Check 4 directions
            for (int i = 0; i < 4; i++) {

                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check boundaries and fresh orange
                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 1 &&
                    vis[newRow][newCol] == 0) {

                    q.add(new Pair(newRow, newCol, t + 1));

                    vis[newRow][newCol] = 2;

                    fresh--;
                }
            }
        }

        // If some fresh oranges are still left
        if (fresh != 0) {
            return -1;
        }

        return time;
    }
}