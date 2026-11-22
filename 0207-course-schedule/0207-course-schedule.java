class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int desc = pre[0];
            int src = pre[1];
            graph.get(src).add(desc);
            inDegree[desc]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int processedCourses = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            processedCourses++;

            for(int neighbor: graph.get(current)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return processedCourses == numCourses;
    }
}