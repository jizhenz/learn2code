
from c0_utils.decorators import Timing
import logging
from c0_utils.logger import StreamLogger

logger = StreamLogger(__name__, logging.DEBUG)

@Timing
def contains_native(collection, target):
    """Determine whether collection contains target."""
    return target in collection

@Timing
def bs_contains(sorted, target):
    """Use binary array search to return index position of target in collection"""
    low = 0
    high = len(sorted)-1
    while low <= high:
        mid = (low + high) / 2
        if target == sorted[mid]:
            return mid # positive or 0: contains
        elif target < sorted[mid]:
            high = mid-1
        else:
            low = mid+1
    return -(low + 1)  # negative: not contains;
                       # index transformation to make the location can be restored,

@Timing
def insertInPlace(ordered, target):
    """Inserts target into it proper location"""
    idx, m_sec = bs_contains(ordered, target)
    if idx < 0:
        ordered.insert(-(idx + 1), target)
        return
    ordered.insert(idx, target)

def test_contains():
    logger.info('Native Search:')
    n = 1024
    while n < 50000000:
        collection = range(n)
        result, m_sec = contains_native(collection, n+1)
        n *= 2
        logger.info('Search %s in %s elements: used %s ms.' % (n+1, n, m_sec))
    logger.info('Binary Search:')
    n = 1024
    while n < 50000000:
        collection = range(n)
        result, m_sec = bs_contains(collection, n+1)
        n *= 2
        logger.info('Search %s in %s elements: used %s ms.' % (n+1, n, m_sec))

def test_insertInPlace():
    """Demonstrate execution performance of contains"""
    n = 1024
    while n < 50000000:
        sorted = range(n)
        # Code whose performance is to be evaluated
        result, m_sec = insertInPlace(sorted, n + 1)
        n *= 2
        logger.info('Insert %s into %s elements: used %s ms.' % (n+1, n, m_sec))

if __name__ == "__main__":
    test_contains()
    test_insertInPlace()