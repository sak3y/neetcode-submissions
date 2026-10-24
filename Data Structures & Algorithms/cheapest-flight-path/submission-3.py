class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float('inf')] * n
        prices[src] = 0

        for i in range(k + 1):
            tmp = prices.copy()

            for s, d, c in flights:
                if prices[s] == float('inf'):
                    continue
                if prices[s] + c < tmp[d]:
                    tmp[d] = prices[s] + c
            
            prices = tmp

        return prices[dst] if prices[dst] != float('inf') else -1
            


"""
    K -> max n# of stops
    src, dst: start, stop

    flights : [src, dst, cost]


    We need to get from SRC to DST such that we do in it K stops
    and RETURN total cost

    Brute force:
    - To get from src to dst we can take any number of routes.
    - A brute force app would go through each and every routes
    and find theh ones that is 
        A: the cheapest
        b: is within K stops

    We can do the above using DFS and a counter

    1. Build an adjacencey list:
    Ex1:
    adj = [
        0 : [[1, 200]]
        1 : [[3, 300], [2, 100]]
        2 : [[3, 100]]
    ]

    the above examples shows 2 paths.

    Altho 0 -> 1 -> 2 -> 3 is cheapers, it has 2 stops which is too high

    2. Run dfs, keep track of visited, stops, total cost

    3. return min cost valid dfs search 
"""