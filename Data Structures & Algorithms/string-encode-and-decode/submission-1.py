class Solution:

    def encode(self, strs: List[str]) -> str:
        encodedStr = ""

        for word in strs:
            encodedStr += str(len(word)) + "!" + word
        return encodedStr

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0  
        while i < len(s):
            j = i
            while s[j] != '!':
                j += 1

            length = int(s[i:j])
            res.append(s[j + 1 : j + 1 + length])
            i = j + 1 + length

        return res



"""
    encode -> decode
    what does ecnode mean. We are just returning the the same value that we insert
    the caveat is that the value that we input -> a List of string returns a string
    the Decode fucntion then takes in a string and converts that into a list of strings

    so its List<String> (input) -> string (return) -> string (input)
        -> List<string>

    Ex: 
    - ["hello", world] -> "hello world" -> ["hello", world]

    The actual problem is convrting a the list to a string
    the inital thought is to just co thru each word in the list, and using a strinbuilder, attach it to a new string
    once that string fiinshes, we add a separator like a $ so that we can distinguish between seperate words
    the probelm with that is hte sttring can contain any possible set of characters, so suing our seperraot means it can be diluted by another string


    Issue: 
    - we need to be able to distinguish words
        Using any char doesn't work

    Solution: 
    - what if we define the lenght of the string, attach it to the start so we get something like: "5hello5world"
    - reading the number, we know exaclty how far to go
    - issues:
        If our words start with a number, we should be able to read
        only the number we assigned
    - instead we do something like: "5&hello5&world", we read all values up until our special char, then we go as far as defined
    
"""