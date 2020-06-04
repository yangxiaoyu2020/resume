### indegree 

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            indegree[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            res += 1;
            for (int[] p :prerequisites) {
                if (p[1] == tmp) {
                    indegree[p[0]]--;
                    if (indegree[p[0]] < 0) return false;
                    if (indegree[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }

            }
        }
        return res == numCourses;
        

    }
}
```