__author__ = 'jizhen'

class Node(object):
    def __init__(self,initdata):
        self.data = initdata
        self.next = None

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def setData(self,newdata):
        self.data = newdata

    def setNext(self,newnext):
        self.next = newnext


class UnorderedList(object):

    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    def add(self,item):
        temp = Node(item)
        temp.setNext(self.head)
        self.head = temp

    def append(self, item):
        if self.head is None:
            self.head = Node(item)
            return
        current = self.head
        while current.next is not None:
            current = current.next
        current.next = Node(item)

    def insert(self, pos, item):
        count = 0
        node = self.head
        while count<pos:
            node = node.getNext()
            count+=1
        if node:
            node.setNext(Node(item))
        else:
            node = Node(item)

    def index(self, item):
        inx = -1
        node = self.head
        while node and node.getData() != item:
            node = node.getNext()
            inx += 1
        return inx

    def pop(self):
        pre = None
        node = self.head
        self.head = pre
        while node.getNext():
            pre = node
            node = node.getNext()
        if pre:
            pre.setNext(None)
        return node

    def pop(self, pos):
        if self.size() < pos:
            return None
        count = 0
        pre=None
        node = self.head
        self.head=pre
        while count<pos:
            pre=node
            node=node.getNext()
            count += 1
        pre.setNext(node.getNext())
        return node

    def size(self):
        current = self.head
        count = 0
        while current != None:
            count = count + 1
            current = current.getNext()
        return count

    def search(self,item):
        current = self.head
        found = False
        while current != None and not found:
            if current.getData() == item:
                found = True
            else:
                current = current.getNext()

        return found

    def remove(self,item):
        current = self.head
        previous = None
        found = False
        while not found:
            if current.getData() == item:
                found = True
            else:
                previous = current
                current = current.getNext()

        if previous == None:
            self.head = current.getNext()
        else:
            previous.setNext(current.getNext())

    def __str__(self):
        aStr = ''
        node = self.head
        while node:
            aStr += str(node.getData()) + ','
            node = node.getNext()
        return aStr

def testUnorderedList():
    mylist = UnorderedList()

    mylist.add(31)
    mylist.add(77)
    mylist.add(17)
    mylist.add(93)
    mylist.add(26)
    mylist.add(54)

    print(mylist)

    print(mylist.size())
    print(mylist.search(93))
    print(mylist.search(100))

    mylist.add(100)
    print(mylist.search(100))
    print(mylist.size())

    mylist.remove(54)
    print(mylist.size())
    mylist.remove(93)
    print(mylist.size())
    mylist.remove(31)
    print(mylist.size())
    print(mylist.search(93))

    print(mylist.__str__())

if __name__ == '__main__':
    testUnorderedList()
    pass