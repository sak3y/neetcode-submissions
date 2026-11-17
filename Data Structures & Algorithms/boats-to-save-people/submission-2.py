class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        res = 0
        l, r = 0, len(people) - 1

        while l <= r:
            if people[l] + people[r] <= limit:
                l += 1

            r -= 1
            res +=1

        return res

"""
    Brute force is too slow.

    ex1: [1,2,4,5], lim = 6
    let's assume that we can always add a person, i.e they're
    always uunder the limit

    a greedy approach would work if we add teh largest possible number
    that way we can make use of the capacity of the boat

"""