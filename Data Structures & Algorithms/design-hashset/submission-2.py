class MyHashSet:

    def __init__(self):
        self.map = {}

    def add(self, key: int) -> None:
        self.map[key] = True

    def remove(self, key: int) -> None:
        self.map.pop(key, True)

    def contains(self, key: int) -> bool:
        return key in self.map


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

# We can use a map or an array imlementation. Map -> faster