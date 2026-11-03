class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]

        prevRow = self.getRow(rowIndex - 1)
        curRow = [1]

        for i in range(1, rowIndex):
            curRow.append(prevRow[i - 1] + prevRow[i])

        curRow.append(1)

        return curRow
        

#     0,1,2,3,4
# 0: [1]
# 1: [1,1]
# 2: [1,2,1]
# 3: [1,3,3,1]
# 4: [1,4,6,4,1]

"""
    to finda row, we need to know what the row before it is.
    That results in recursively going down to the base case which is rowIndex = 0
    in this case, we have [1]
    for RowIdx = 1:
    
    for each index, we take the value of the previous row and add it to the current row 
    then append it to our res..
    we konw that the legnth of our list increases by 1 times or in otherwords
    len = rowindex + 1
    we skip the first and last elements since they are always the same
    but also because they would be out of bounds
"""