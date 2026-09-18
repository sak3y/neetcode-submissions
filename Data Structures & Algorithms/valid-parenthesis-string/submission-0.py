class Solution:
    def checkValidString(self, s: str) -> bool:
        openStack = []
        starStack = []

        for i, c in enumerate(s):
            if c == '(':
                openStack.append(i)
            elif c == '*':
                starStack.append(i)
            else:  # c == ')'
                if openStack:
                    openStack.pop()
                elif starStack:
                    starStack.pop()
                else:
                    return False

        while openStack and starStack:
            if openStack[-1] > starStack[-1]:
                return False
            openStack.pop()
            starStack.pop()

        return not openStack

"""
'(' -> open parentheses, must be closed
')' -> an open must preceed it
'*' -. represents anything or nothing

tricky part here is deciding what the start would do (since we are going from start to end) -> when we do reach a start * what do we do?
depend on what we have right
say we have an open bracket. We want to close, the first action we need to take
that wouldnt work tho because we could have a close after

instead we could look at just brackets
then we eliminate pairs on the first run

"(**" -> if we trace on the first example

now we can deal with the start since we don't have to worry about close brackets

se we can cancel out the open with a start and then convert to empty

ec -> a close comes before an open -> invalid
also forgot to consider the inverse. What about stars for opening brackets?

"(**))"
"**)"

we cna also take the fact that if we get to a start. Going forward it has to match an open adn going back it has to match a close
Once we've taken care of all the pairs.
we can then implement

Implementation:
- 

"""