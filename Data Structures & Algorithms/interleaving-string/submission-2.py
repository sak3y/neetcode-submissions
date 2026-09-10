class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False

        memo = {}
        def dfs(i, j):
            if  i == len(s1) and j == len(s2):
                return True
            if (i, j) in memo:
                return memo[(i, j)]

            if i < len(s1) and s1[i] == s3[i + j] and dfs(i + 1, j):
                return True
            elif j < len(s2) and s2[j] == s3[i + j] and dfs(i, j + 1):
                return True

            memo[(i, j)] = False
            return False

        return dfs(0, 0)

            

"""
    we have two string
    those two strings can be split in any way
    we then weave the substrings together toform s3
    Relative order to be maintained

    Brute force:
    - a realy long way to do this is to take all the possibel subsequences of s1,s2
    and then use them to make s3
    - see if any instances match

    another way:
    we know that s3, for an

    we know that combining every possibls subsequcne from both s1 and s2 will eventually give us the results
    s1 + s2 (len wise) = s3
    so we have a poiter on both strings
    the two options are:
    - add a char from s1 or s2
    - once we've add that string we can move the pointer of the string from the char we've taken
    
    Solution
    - we make a choice between picking a char form s1 or s2
    - then we update the pointer, after we've picked a char
    - the thing about this one is that we already have 
"""
