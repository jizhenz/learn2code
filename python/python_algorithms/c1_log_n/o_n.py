
from c0_utils.decorators import Timing
import logging
from c0_utils.logger import StreamLogger

logger = StreamLogger(__name__, logging.DEBUG)

@Timing
def contains_native(collection, target):
    """Determine whether collection contains target."""
    return target in collection

@Timing
def insert_into_sorted(sorted, target):
    """Insert target into its proper location in the ordered collection: ordered from small to big."""
    for i in range(len(sorted)):
        if sorted[i] > target:
            sorted.insert(i, target)
            return
    sorted.append(target)

def test_contains_native():
    n = 1024
    while n < 50000000:
        collection = range(n)
        result, m_sec = contains_native(collection, n/2)
        n *= 2
        logger.info('Search %s in %s elements: used %s ms.' % (n/2, n, m_sec))

def test_insert_into_sorted():
    n = 1024
    while n < 50000000:
        sorted = range(n)
        result, m_sec = insert_into_sorted(sorted, n/2)
        n *= 2
        logger.info('Insert %s into %s sorted elements: used %s ms.' % (n/2, n, m_sec))

if __name__ == "__main__":
    test_contains_native()
    test_insert_into_sorted()

