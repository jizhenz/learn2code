
from time import time
import logging
from logger import StreamLogger

logger = StreamLogger(__name__, logging.DEBUG)

def Timing(func):
    def inner(*args, **kwargs): #1
        now = time()
        results = func(*args, **kwargs) #2
        done = time()
        logger.info('Running %s in %s ms.' % (func.__name__, (done-now)*1000))
        return results
    return inner