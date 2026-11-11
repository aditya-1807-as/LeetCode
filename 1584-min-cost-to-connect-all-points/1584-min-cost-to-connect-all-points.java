
class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int u = -1;

            // Find the nearest unvisited point
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < min) {
                    min = minDist[j];
                    u = j;
                }
            }

            visited[u] = true;
            totalCost += min;

            // Update distances of remaining points
            for (int v = 0; v < n; v++) {

                if (!visited[v]) {

                    int distance =
                        Math.abs(points[u][0] - points[v][0]) +
                        Math.abs(points[u][1] - points[v][1]);

                    minDist[v] = Math.min(minDist[v], distance);
                }
            }
        }

        return totalCost;
    }
}
