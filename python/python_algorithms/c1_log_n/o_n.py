# Binary Search template file

from c0_utils.decorators import Timing

@Timing
def contains_native(collection, target):
    """Determine whether collection contains target."""
    return target in collection

@Timing
def insertInPlace(ordered, target):
    """Insert target into its proper location in the ordered collection"""
    for i in range(len(ordered)):
        if ordered[i] > target:
            ordered.insert(i, target)
            return

    ordered.append(target)


# def performance():
#     """Demonstrate execution performance of contains"""
#     n = 1024
#     while n < 50000000:
#         sorted = range(n)
#         now = time()
#
#         # Code whose performance is to be evaluated
#         insertInPlace(sorted, n/2)
#
#         done = time()
#
#         print n, (done-now)*1000
#         n *= 2

def test_01():
    n = 1024
    while n < 50000000:
        collection = range(n)
        contains_native(collection, n/2)
        n *= 2

if __name__ == "__main__":
    test_01()

