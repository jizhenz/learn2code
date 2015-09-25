__author__ = 'jizhen'

# Creativity

# C-1.13	Write a pseudo-code description of a function that reverses a list of n integers, so that the numbers are
#         listed in the opposite order than they were before, and compare this method to an equivalent Python function
#         for doing the same thing.

class node(object):
    def __int__(self, v):
        self.value = v
        self.next = None

## http://interactivepython.org/courselib/static/pythonds/BasicDS/linkedlists.html




class MyList(object):
    def __init__(self):
        self.head = None

    def add(self,v):
        if self.head is None:
            self.head = node(v)
        else:
            n = self.head
            while n.next is not None:
                n = self.head.next
            n.next = node(v)

    def revert(self):
        next = self.head
        if next is None or next.next is None:
            return
        else:
            pre = None
            current = next
            while next:
                current.next = pre
                pre = current
                current = next
                next = next.next
            self.head = current




def test_normal_revert():
    aList = MyList()
    for v in range(10):
        aList.add(v)

    n = aList.head
    while n:
        print(n.value)
        n = n.next

    aList.revert()

    n = aList.head
    while n:
        print(n.value)
        n = n.next




if __name__ == '__main__':
    test_normal_revert
    pass