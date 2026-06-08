class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!resMap.containsKey(sortedStr)) {
                resMap.put(sortedStr, new ArrayList<>());
            }
            resMap.get(sortedStr).add(s);
        }

        return new ArrayList<>(resMap.values());
    }
}