class MyHashSet:

    def __init__(self):
        self.arr = []

    def add(self, key: int) -> None:
        # unique instanes, check that nums isn't in there
        for val in self.arr:
            if val == key:
                return

        self.arr.append(key)

    def remove(self, key: int) -> None:
        for i, val in enumerate(self.arr):
            if val == key:
                self.arr.pop(i)
                return

    def contains(self, key: int) -> bool:
        # parse arr for match
        for val in self.arr:
            if val == key:
                return True

        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

# We can use a map or an array imlementation. Map -> faster