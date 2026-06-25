class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String s : strs) {
            res.append(s.length()).append('@').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '@') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            String word = str.substring(start, start + length);
            res.add(word);
            i = start + length;
        }

        return res;
    }
}

/*
    Idea
    - Encode => takes in a List and must return a string
    - Decode => takes in a string (from encode) and has to return a list
    - From input to output => it is a list
    - We have to preserve the original string
    - It can contain any of the ASCII 256 chars

    Problem
    - Convertring a list of strings to a string so: List => String?
    - How do we preserve the string if it can contain any char?

    Solution
    - if we want to convert say: ["h3llo,", "world"]
    - Conversion => "h3llo,world" => easy enough
    - Conversion back: (this is where the problem is).
    - Well we could use a special char like '!' so that our string becomes "h3llo,!world!"
    - but since the list can contain ANY character, that won't work no matter what we choose.
    - So then how do we preserve the orginal string like: "h3llo," so that we know exactly what it
   was?
    - Length? => we can attach a number to denote the length of a string, e.g. "h3llo," is length 6
   and world is length 5 so we do "6h3llo5world". No when we use a pointer and find a number, we
   continue no matter what the char is. And this way the pointer will always land on another number.
   But, what if we had say: ["3ello,", "world"]. that becomes => "6!3ello,5!world". Is it one or two
   didigts? So we use a seperateor like "!" after that way it doesn't get mixed up

    Time complexity
    - Encoding: using .length, and for loop => O(n)
    - Decoding: O(n)

    So O(n + n) => O(n)

    Edge Cases:
    - Empty string => return empty string
    -

    */