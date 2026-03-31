class LinkedList:
    class Node:
        def __init__(self):
            self.next = None;

        def __init__(self, value, next = None):
            self.value = value;
            self.next = next;
    
    def __init__(self):
        self.head = None;

    def get(self, index: int) -> int:
        curr = self.head;
        while(curr != None):
            if (index == 0):
                return curr.value;
            else: 
                curr = curr.next;
                index -= 1;
        return -1;

    def insertHead(self, val: int) -> None:
        newHead = self.Node(val, self.head);
        self.head = newHead;

    def insertTail(self, val: int) -> None:
        newTail = self.Node(val, None);
        if (self.head == None):
            self.head = newTail;
            return;
        curr = self.head;
        while(curr != None and curr.next != None):
            curr = curr.next;
        curr.next = newTail;

    def remove(self, index: int) -> bool:
        if (self.head == None):
            return False;

        prev = self.head;
        if (index == 0): # one element list
            self.head = prev.next;
            return True;
        
        curr = prev.next;

        while (curr is not None):
            index -= 1;
            if (index == 0):
                prev.next = curr.next;
                return True;
            else:
                prev = curr;
                curr = curr.next;

        return False; # index is too large 
        
    def getValues(self) -> List[int]:
        if (self.head == None):
            return [];
        if (self.head.next == None):
            return [head.value];
        values = [];
        curr = self.head;
        values.append(curr.value);

        while(curr.next != None):
            curr = curr.next;
            values.append(curr.value);
        return values;

        
