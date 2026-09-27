class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.cap = capacity

        self.left = Node(0, 0)
        self.right = Node(0, 0)

        self.left.next = self.right
        self.right.prev = self.left

    def insert(self, node):
        prev = self.right.prev
        nxt = self.right

        prev.next = node
        nxt.prev = node

        node.next = nxt
        node.prev= prev

    def delete(self, node):
        nxt = node.next
        prev = node.prev

        nxt.prev = prev
        prev.next = nxt

    def get(self, key: int) -> int:
        if key in self.cache:
            # shift LRU, update pointer, deelte then re insert
            self.delete(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        return -1

    def put(self, key: int, value: int) -> None:
        #insert from right, update the left adn ritht pointer to add new node
        if key in self.cache:
            self.delete(self.cache[key])
        self.cache[key] = Node(key, value)
        self.insert(self.cache[key])
    
        if len(self.cache) > self.cap:
            lru = self.left.next
            self.delete(lru)
            del self.cache[lru.key]
        
