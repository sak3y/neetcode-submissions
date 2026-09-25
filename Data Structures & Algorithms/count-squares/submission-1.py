class CountSquares:

    def __init__(self):
        self.ptsFreq = defaultdict(int)
        self.pts = []

    def add(self, point: List[int]) -> None:
        self.ptsFreq[tuple(point)] += 1
        self.pts.append(point)

    def count(self, point: List[int]) -> int:
        res=0
        fx, fy = point # this is our query point
        for x, y in self.pts:
            if abs(x - fx) != abs(y - fy) or x == fx or fy == y:
                continue
            res+= self.ptsFreq[(x, fy)] * self.ptsFreq[(fx, y)]
        return res

"""
    For a given point. A square is valid if there is a diagonal point to it (first). thhis is what we look for
    that diagonal point needs to be an equal length of x at it is y, in other words, at a 45 degree angle
    Then we can qualify two other points such that
    if [x, y] is our query and [fx, fy] is our diagonal
    then, [fx, y] and [x, fy] must exist for a valid square.
    We use a hashmap to deal with duplicate values

    Implementing the count class:
    - for each point, we validate whether a diagonal point exists
    - then we check the two other points
    - we then take the hashmaps value (for dupes) and then 


We can add points to our graph
Given a query, we must return the number of squares that we can form
Points

We need to understand what a square is:
- 4 sides
- equal length
- parallel to each other

so whenever we run count. We can image that its a new point we add in and that it must meet all the criteria above

So when we do count, we need to consider points.
1. they need to be on the same axis
2. the vertical point must be the same distance as the horizontal point
3. there also needs to be another point that is in line with both the other points """