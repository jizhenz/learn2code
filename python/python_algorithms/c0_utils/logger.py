import logging

class Logger(object):
    def __init__(self, name, log_level):
        self.logger = None
        logger = logging.getLogger(name)
        logger.setLevel(log_level)
        self.logger = logger
        if not self.logger:
            raise Exception('StreamLogger initialization failed!')

    def setLevel(self,lvl):
        self.logger.setLevel(lvl)

    def isEnabledFor(self,lvl):
        return self.logger.isEnabledFor(lvl)

    def debug(self, msg, *args, **kwargs):
        self.logger.debug(msg, *args, **kwargs)

    def info(self, msg, *args, **kwargs):
        self.logger.info(msg, *args, **kwargs)

    def warning(self, msg, *args, **kwargs):
        self.logger.warning(msg, *args, **kwargs)

    def error(self, msg, *args, **kwargs):
        self.logger.error(msg, *args, **kwargs)

    def critical(self, msg, *args, **kwargs):
        self.logger.critical(msg, *args, **kwargs)

    def log(self, msg, *args, **kwargs):
        self.logger.log(msg, *args, **kwargs)

    def exception(self, msg, *args, **kwargs):
        self.logger.exception(msg, *args, **kwargs)

class StreamLogger(Logger):
    def __init__(self, name, log_level):
        super(StreamLogger, self).__init__(name, log_level)
        # create console handler and set level to debug
        ch = logging.StreamHandler()
        ch.setLevel(logging.DEBUG)
        # create formatter
        formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
        # add formatter to ch
        ch.setFormatter(formatter)
        # add ch to logger
        self.logger.addHandler(ch)