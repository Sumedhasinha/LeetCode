
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

    
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);
        }

        
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

    
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            result[index++] = node;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }


        if (index == numCourses) {
            return result;
        }

        return new int[0];
    }
}
