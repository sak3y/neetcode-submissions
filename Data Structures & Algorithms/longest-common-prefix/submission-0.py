class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        smallest = min(len(word) for word in strs)

        for i in range(smallest):
            for j in range(1, len(strs)):
                if strs[0][i] != strs[j][i]:
                    return res
            res += strs[0][i]
                
        return res
"""
    Brute force:
    - so the brute force way to do this is using a two pointer.
    - Check that chars match 
    Ex: [bat, bank]
        - b : b
        - a : a
        - t : n -> here they don't match so we return the current string
        - "": k
    
    for longer strings:
    - we have to check teh char at each index for each word in strs
    TC: O(n * k) n = len of strs, k = avg len of the words

    usinga  set we can keep track of new chars and old chars
    So we intialise with the curr char.
    If at any point we have to add a new char
    
    Trie:
    - we know words can be represented as the chars of their tree.
    - we can represetn each of these wrods as a trie which gives us their combined
    char combination
    - we can do bfs and dfs at the same time and return when they dont match
"""