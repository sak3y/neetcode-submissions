class MyHashMap:

    def __init__(self):
        self.map = []

    def put(self, key: int, value: int) -> None:
        for i, (k, v) in enumerate(self.map):
            if key == k:
                self.map[i] = (key, value)
                return

        self.map.append((key, value))
            

    def get(self, key: int) -> int:
        for k, v in self.map:
            if key == k:
                return v
        return - 1

    def remove(self, key: int) -> None:
        for i, (k, v) in enumerate(self.map):
            if key == k:
                self.map.pop(i)
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

"""
    Going to be using a 2d array here
    - [(key, val), (key2, val2)...]


"""