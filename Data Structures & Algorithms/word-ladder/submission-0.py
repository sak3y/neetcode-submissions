class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        trans = {word : [] for word in wordList}
        trans[beginWord] = []

        def isValidTfm(word1, word2):
            # we can already assume they are the same length and are lower case only
            diff = 0
            for i in range(len(word1)):
                if diff > 1:
                    return False
                
                if word1[i] != word2[i]:
                    diff += 1

            return diff == 1

        # build adj list
        words = list(trans.keys())
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                word1 = words[i]
                word2 = words[j]

                if isValidTfm(word1, word2):
                    trans[word1].append(word2)
                    trans[word2].append(word1)
                    
        # bfs
        q = deque([beginWord])
        visit = {beginWord}
        res = 1

        while q:
            for i in range(len(q)):
                cur = q.popleft()

                if cur == endWord:
                    return res

                for nei in trans[cur]:
                    if nei in visit:
                        continue
                    visit.add(nei)
                    q.append(nei)

            res += 1

        return 0
        

            


"""
    Get to beginWord -> endWord
    RULES:
        - we can change a beginWord to any word in the list so long as
        the position of only one character is different
        Ex. cat and bat -> only 'c' is different so we can transform
        - We can do this as many times following the rules above
    
    GOAL: Find the number of transfomrations needed or if it can't be reached return 0

    BF:
    Which words can we get from begin Word?
    ex1: 
        cat: bat
        bat: cat, bag
        bag: bat, sag, dag
        sag: bag, dag
        dag: bag, sag
        dot: n/a

    This looks familiar, it's almost like an adjacency list.
    If we can map out values in this way, we can peform a dfs to find the word taht we need

    EC: 
    - endWord must exists in the list
    - However, beginWord doesn't have to, we add it to the list anyways so we can handle the
    edge case
    
    Sub problems
    1. compare two string to see if there is a different of one char position -> valid trans
    2. Create a hashmap of dependencies
    3. find a path (if exists) that gets from BW to EW. AKA BFS
    4. Return the n# of transformations


    SP1:
        - They need to be the same length
        - We can use two pointer to go over chars and a val of diff (which shouldn't exceed 1)
        - TC: O(n)

    SP2: 
        - use nested loop and check strings are valid

    SP3:
        - We have an adj list and we want to explore the paths. Think of the adjacency list as
        as an undirected graph
        - Starting from beginWord, we can take many routes at once
        - this way, we incrememnt
        - 

    Brute force:
        - create a 'transformation' map that maps a word to all of it's transormations
        - to do that, we need have valid transomration that follow the rules so we comapre the 
        chars in it's string
        - then we can add it to map
        - do that for every word in wordLIst so O(n^2)
        - Now we have a transormations map, start finding the paths
        - from beginWord, we look at all its tfms and do as deep as we can.
        - We know that different paths can get there quicker or not at all so we exhaust the paths
        - maybe do bfs instead actually, so we get the path quicker
        - return on first instance

"""