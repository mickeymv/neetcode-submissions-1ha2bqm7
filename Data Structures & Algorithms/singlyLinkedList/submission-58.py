class LinkedList:

    class Node:
        def __init__(self, value, next = None):
            self.value = value;
            self.next = next;

    
    def __init__(self):
        self.head = None;

    
    def get(self, index: int) -> int:
        curr = self.head;
        i = 0;

        while(curr is not None):
            if (i == index):
                return curr.value;
            else: 
                i += 1;
                curr = curr.next;
        
        return -1;

    def insertHead(self, val: int) -> None:
        newHead = self.Node(val, self.head);
        self.head = newHead;
        

    def insertTail(self, val: int) -> None:
        newTail = self.Node(val);
        ##empty list
        if (self.head is None):
            self.head = newTail;
            return;
        ##single element list
        if (self.head.next is None):
            self.head.next = newTail;
            return;
        ##multiple element list
        prev = self.head;
        curr = self.head.next;
        while(curr is not None):
            prev = curr;
            curr = curr.next;
        prev.next = newTail;
        

    def remove(self, index: int) -> bool:
        ##empty list
        if (self.head is None):
            return False;
        ##remove head
        if (index == 0):
            self.head = self.head.next;
            return True;
        ## multiple elements (also handle index too large)
        i = 1 # start at the second element
        prev = self.head;
        curr = self.head.next;

        while (curr is not None):
            if (i == index): ## element to remove
                prev.next = curr.next;
                return True;
            else: 
                i += 1;
                prev = curr;
                curr = curr.next;
        
        return False;

    def getValues(self) -> List[int]:
        if (self.head is None):
            return [];
        if (self.head.next is None):
            return [self.head.value];
        ##multiple elements in the list
        values = [];
        curr = self.head;
        while (curr is not None):
            values.append(curr.value);
            curr = curr.next;
        return values;
        
