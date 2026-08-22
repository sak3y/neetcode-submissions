class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0],
                k -> new ArrayList<>()).add(pre[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        // Run dfs on each course
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, map, output, visited, cycle)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }

        return res;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq,
                    List<Integer> output, Set<Integer> visited, Set<Integer> cycle) {
    if (cycle.contains(course)) return false;
    if (visited.contains(course)) return true;

    cycle.add(course);
    for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
        if (!dfs(pre, prereq, output, visited, cycle)) return false;
    }

    cycle.remove(course);
    visited.add(course);
    output.add(course);
    return true;
    }
}

/*
    [course want to take : course need to take]
    GOAL: Find a valid order of courses that can be taken to complete all courses

    Idea is, some courses have prerequisites while others don't
    We want to find path/chain that connect all of them and meet our prerequ requiremetns
    Obstacles: cycle, so that means we can never finish a courses becaues one of the p ends up
    coming back in a circle
    typically, we start at a value so the first course, 0
    then see if any values are pr for that value. Check that value until we can have a valid
    chain if not, it's a cycle

    Implemntation
    - Hashmap to track values and what they map to 
    - Then dfs style, go thru each value to ssee how far they go
    - Cycle detection
    - DFS base case is when a value maps to nothing which means that it's a valid path
    - Keep in mind that values can map to multiple values, one => many so we need to traverse that list
    - 
*/