class Node:
    def __init__(self):
        self.prev = None;
        self.next = None;

    def __init__(self, value, prev = None, next = None):
        self.value = value;
        self.prev = prev;
        self.next = next;

class Deque:
    
    def __init__(self):
        self.head = None;
        self.tail = None;

    def isEmpty(self) -> bool:
        if (self.head is None):
            return True;
        else:
            return False;

    def append(self, value: int) -> None:
        newTail = Node(value, None, None);

        if (self.head is None): #q is empty
            self.head = newTail;
            self.tail = newTail;

        #there is at least 1 element in the queue

        #head is pointing to the first element, 
        #tail is pointing to the last

        prevTail = self.tail;
        newTail.prev = prevTail
        prevTail.next = newTail;
        self.tail = newTail;

    def appendleft(self, value: int) -> None:
        newHead = Node(value, None, None);
        
        if (self.head is None): #q is empty
            self.head = newHead;
            self.tail = newHead;

        prevHead = self.head;
        newHead.next = prevHead
        prevHead.prev = newHead;
        self.head = newHead;


    def pop(self) -> int:
        if (self.tail is None): #q is empty
            return -1;
        
        #if there is only one element, head is = tail

        if (self.head == self.tail):
            val = self.head.value;
            self.head = None;
            self.tail = None;
            return val;

        #more than one element

        val = self.tail.value;
        self.tail = self.tail.prev
        self.tail.next = None;
        return val;
        

    def popleft(self) -> int:
        if (self.head is None):
            return -1;

        if (self.head == self.tail):
            val = self.head.value;
            self.head = None;
            self.tail = None;
            return val;

        val = self.head.value;
        self.head = self.head.next;
        self.head.prev = None;
        return val;
