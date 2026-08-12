class Solution {
    Map<Character, String> map;
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.length() == 0) return res;

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    private void dfs(String digits, StringBuilder msg, int i) {
        if (i >= digits.length()) {
            res.add(msg.toString());
            return;
        }

        String digitString = map.get(digits.charAt(i)); // gives us the current digits string set

        for (char c : digitString.toCharArray()) {
            msg.append(c);
            dfs(digits, msg, i + 1);
            msg.deleteCharAt(msg.length() - 1);
        }
    } 
}


/*
    Digits 2 - 9 represent a set of chars
    GOAL: Given a number, find all possible char combination that those numbers make

    Idea
    Using a hashmap, we can determine what chars a number represents
    Ex. 34
    3: [d,e,f]
    4: [g,h,i]

    To get 34, we essentiatly get the dot product of both values
    In brute force, that's taking a char from the first, then adding it to each other which is (O4**n);
    where n is the length of the digit/

    So a hashmmap would store the keys for each digit
    then go thru each digit, and then fro each char, we create a sequence 

    Idea is that each digit branches out into 3/4 branches
    We can't use a for loop since we can't account for all teh values that way and it would be long
    Instead we need a recursive approach, specifiaclly dfs,
    we knwo that each branch is n long and has 4**n values

    How the tree nav would work
    We would hold all values in a map. 
    Then in that map we would look at those values
    Then recusively work on each of them looking at one digit at a time

*/