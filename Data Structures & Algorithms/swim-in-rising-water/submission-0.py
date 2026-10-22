class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        DIRS = [(0,-1), (0,1), (1,0), (-1,0)]

        def bfs(t):
            q = deque([(0,0)]) # position [r,c]
            visit = {(0,0)}
            
            while q:
                r, c = q.popleft()

                if r == ROWS - 1 and c == COLS - 1:
                    return True

                for dr, dc in DIRS:
                    row = dr + r
                    col = dc + c

                    if (row < 0 or col < 0
                        or row >= ROWS or col >= COLS
                        or grid[row][col] > t
                        or (row, col) in visit):
                        continue

                    visit.add((row, col))
                    q.append((row, col))
                    

            return False

        t = grid[0][0]

        while not bfs(t):
            t += 1

        return t
                    
   
"""
    Grid[i][j] -> represents the elevation
    [i][j] -> represents the position 

    Rules:
    - we can travel to an adjacent square only if we the water level matches or is greater than 
    that square
    - we have a timer t, set to 0 initally
    - t increments and we use it to move to different elevations
    - If there are no available squares, we have to 

    GOAL -> Get to BOTTOM-RIGHT square from TOP-LEFT and RETURN the TIME AKA Water level in as little time as possible

    Asumptions:
    - Top left is always 0,0
    
    Notes:
    - It could be that going backwards helps us go forwads, as such, we should disclude any squares
    - Therefore a solution neccesitates covering each and every square (we can't know in advance what the ideal path is)
    -

    Brute Force. 
    - Initially, we start top left, 
    - Check to see what squares are available to use. 
    - Increment T
    - Check again what square we can go -> BFS or DFS? that fit T
    - Im gonna use BFS for this since, we want the path that gets there teh quickest
    - We need to keep track of visited squares to avoid cycles
    - Maybe we just repeat BFS from (0,0) and repeat each time T is incremented
    - That way we get the results ASAP
    - Storing values in a set, until 

    Alternatifve approach
    - What if we worked backwards
    - Starting from bottom right
    - We know that our min values is 6 since htat' the val in ex2
    - we then do bfs.
    - Next value is 7 and 15. 
    - We look at adjacnt squares only
    - We maybe use a heap to keep track of the biggest square we've seen so far for each bfs iteration

    KEY INSIGHT: - If we can keep track of the max for each bfs iterations, once we get to the bottom right, we just return the smallest one
    - I guess we can store the total cost to get to a specific square. 

    Another key insight.
    - We can make a graph.
    - Nodes represent positiosn on the graph, we don't really care about that but it's needed for calc
    - we can use the values of those nodes, as edges. Say for 0 -> 1, costs 1

    Converting grid to adjacency list

"""