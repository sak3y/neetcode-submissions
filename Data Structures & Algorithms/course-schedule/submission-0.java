class Solution {
    Set<Integer> visit = new HashSet<>();
    Map < Integer, List <Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }
        
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visit.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) return true;
        
        visit.add(course);
        for (int pre : map.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visit.remove(course);
        map.put(course, new ArrayList<>());
        return true;

    }
}

/*
    Need to take x ammount of courses
    Courses need to be taken in order, from b -> a
    Cna somene finish all teh courses
    Courses can either be in a chain, i.e: a -> b -> c, since they only come in paris.
    So waht we are looking fro is the shortest chain.
    For a chain of lenght 3, they have to take a to c which is 3, so three is the minimum number
    [0,1][1,2][2,3]
    [course want to take, course need to take]
    Also infinite loops as well, so if we have the reverse of a pre, then that means it's impossible

    Solution
    - The idea is dfs, since we want to to find the shortest, chain fro a list of prerequisites.
    - Brute force idiea
    - Say we start with an a value
    - we then chekc if there are prer for that a value anywhere else. If there are, we take the prer
    - so it starts like this: [course we want to take, course we need to take] => look for the
   course we need to take unitl there are no prerequisites. Count how many chains / prereqs it took
   to get there.
    - Do that for every single value until we get a shortest and then return it
    - Detecting infinite cycle.
    -   Need to catch where an infinifte cylcle exists if the course we need to take is a prerequ of
   the course we want to take, i.e. the array reversed
    -
*/