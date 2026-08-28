class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        smap = {}
        tmap = {}

        for char in s:
            smap[char] = smap.get(char, 0) + 1
        
        for char in t:
            tmap[char] = tmap.get(char, 0) + 1

        return smap == tmap


"""
    Anagram: if two string have the same chars that appear the same 
    number of times.
    They can have differnt orders

    A map would solve our problem
    Parse both strings and create a map of chars : frequencny
    Compare and return true if they match

"""