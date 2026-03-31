class Node:
    def __init__(self):
        self.next = None;

    def __init__(self, value, next = None):
        self.value = value;
        self.next = next;

class LinkedList:
    def __init__(self):
        self.head = None;
    
    def get(self, index: int) -> int:
        if (self.head is None or index < 0):
            return -1; # get on an empty list is OOB

        i = 0;

        curr = self.head;

        while (curr is not None):
            if (i == index):
                return curr.value;
            else:
                curr = curr.next;
                i += 1;
        
        return -1; # index is too big 

    def insertHead(self, val: int) -> None:
        newHead = Node(val, self.head);
        self.head = newHead;

    def insertTail(self, val: int) -> None:
        newTail = Node(val, None);
        if (self.head is None):
            self.head = newTail;
            return;

        prev = self.head;
        cur = self.head.next;

        while (cur is not None):
            prev = cur;
            cur = cur.next;

        prev.next = newTail;

      
        

    def remove(self, index: int) -> bool:
        if (self.head is None or index < 0):
            return False; # remove on an empty list is OOB
        
        if (index == 0):
            self.head = self.head.next;
            return True;

        i = 1;
        prev = self.head;
        curr = self.head.next;

        while (curr is not None):
            if (index == i):
                prev.next = curr.next;
                return True;
            else:
                prev = curr;
                curr = curr.next;
                i += 1;

        return False; # index is out of bounds

    def getValues(self) -> List[int]:
        if (self.head is None):
            return [];

        vals = [];

        curr = self.head;

        while (curr is not None):
            vals.append(curr.value);
            curr = curr.next;

        return vals;
        
