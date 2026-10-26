class LinkedList:
    
    def __init__(self):
        self.nodes = []
        self.head = None # pointer to first node
    
    def get(self, index: int) -> int:
        if index < 0:
            return -1

        cur = self.head
        for i in range(index):
            if cur == None:
                return -1
            
            cur = self.nodes[cur][0]

        return self.nodes[cur][1] if cur is not None else -1

    def insertHead(self, val: int) -> None:
        newNode = len(self.nodes)

        self.nodes.append([self.head, val])

        self.head = newNode # Last item in array becomes our new head

    def insertTail(self, val: int) -> None:
        # Find (None, val), replace None with new idx for tail
        newNode = len(self.nodes)
        self.nodes.append([None, val])

        if self.head is None:
            self.head = newNode
            return

        cur = self.head

        while self.nodes[cur][0] is not None:
            cur = self.nodes[cur][0]

        self.nodes[cur][0] = newNode

    def remove(self, index: int) -> bool:
        if index < 0 or self.head is None:
            return False

        if index == 0: # remove head
            self.head = self.nodes[self.head][0]
            return True

        prev = self.head
        for i in range(index - 1):
            prev = self.nodes[prev][0]
            
            if prev is None:
                return False

        cur = self.nodes[prev][0]

        if cur is None:
            return False

        self.nodes[prev][0] = self.nodes[cur][0]
        return True

    def getValues(self) -> List[int]:
        if self.head is None:
            return []
            
        values = []
        cur = self.head
        
        while cur is not None:
            values.append(self.nodes[cur][1])
            cur = self.nodes[cur][0]

        return values