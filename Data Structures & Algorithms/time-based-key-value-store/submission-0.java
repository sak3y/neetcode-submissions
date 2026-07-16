class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore; 

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new ArrayList<>());
        }
        keyStore.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());

        int l = 0;
        int r = values.size() - 1;

        String res = "";

        while (l <= r) {
            int mid = (l + r) / 2;

            if (values.get(mid).getKey() <= timestamp) {
                res = values.get(mid).getValue();
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }
    
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

/*
    Design funcitions 
    - TimeMap => 
*/