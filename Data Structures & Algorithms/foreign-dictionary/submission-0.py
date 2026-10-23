class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        n = len(words)
        adj = {c : set() for w in words for c in w} # {char : {}}

        for i in range(n - 1):
            w1, w2 = words[i], words[i + 1]
            minLen = min(len(w1), len(w2))

            # handle cases like ["abc", "ab"]
            if len(w1) > len(w2) and w1[:minLen] == w2[:minLen]:
                return ""
            
            # Different char pos
            for j in range(minLen):
                if w1[j] != w2[j]:
                    adj[w1[j]].add(w2[j])
                    break
            
        # Connect all our nodes
        visited = {}
        res = []

        def dfs(char):
            if char in visited:
                return visited[char]

            visited[char] = True

            for neiChar in adj[char]:
                if dfs(neiChar):
                    return True

            visited[char] = False
            res.append(char)

        for char in adj:
            if dfs(char):
                return ""

        res.reverse()
        return "".join(res)



""" 
    Given a list of words:
    - The words are sorted lexicographically

    Meaning that in some language, the words are in alphabetical order. So not ABC but some other alphabet

    So we need ot understand how to sort words in regular alphabet and then apply those rules here


    Thinking on this. The words, if they follow these rules, then we can assume that the alien langauge is valid. 
    We determine if they follow those rules by applying lexicogrpahic statements, where we takes two words at differnet prositions, and make conclusions.
    Following these conclusion, we take each unique letter and then form it into a word that is sorted lexicographically according to the conclussion we found.
    If two conclusion contradicts, then the langauge is invalid, return ""
    

    What are we actually returning. 
    - A sorted list of chars (in new langauge), where 

    Ex2:  "hrn", "hrf". In this case: n < f => we'll add this as a rule.

    Brute force:
    - we know that the first letter of a word is always the smallest
    - in "hrf" order is:

    h -> e
    r -> n
    e -> r
    n -> f
    Combing these: h -> e -> r -> n -> f

    h < r < n
    n < f
    h < e
    e < r < n
    e < r < f

    h < e < r < n < f

    So by comparing adjacent words, we get the direct next val and don't have to worry about intermediate values

    We know we have a valid language if we can visit all nodes in the adjeacenc list
    
    if we can't then it's invalid
    
    Take:
    [abc, ab]

    c -> ''

    Acutal brute force:
    1. Create adj lists
        - compare adjacent words,
        - look at differnece.
        - add word[i] and word[i + 1] as a directed edge and the chars as nodes.
        - incfrement i by 1 to compare next adj words
        - 
"""