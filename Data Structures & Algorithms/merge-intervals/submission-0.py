class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
     
        
        intervals.sort(key=lambda pair: pair)
        res = [intervals[0]]

        for x, y in intervals[1:]:
            if x <= res[-1][1]:
                res[-1][1] = max(res[-1][1], y)
            else:
                res.append([x, y])

        return res
       
       # [2,10] res=[1,6]

                

"""
Assume it's ordered?

so wiht this one an overlapping pair is defined as:
pair[1] >= pair[0]

for normal a pair, 
pair[1] < pair[0]

and we can multiple overlapping pairs

so assuming it's ordered:
we can take a pair, check the values of the next pair. 
If we see overlap, then we take the min and max of both values.
then we contniue so long as there is overlap
once finsished, we add it to our res


"""