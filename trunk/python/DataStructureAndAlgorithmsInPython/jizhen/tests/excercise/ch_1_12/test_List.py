from unittest import TestCase

__author__ = 'jizhen'

from jizhen.excercise.ch_1_12.List import Node

class TestNode(TestCase):
    def test_getData(self):
        n = Node(10)
        assert 10 == n.getData()

    def test_getNext(self):
        n = Node(1)
        n.next = Node(2)
        assert 2 == n.getNext().getData()

    def test_setData(self):
        n = Node(-1)
        assert -1 == n.getData()
        n.setData(1)
        assert 1 == n.getData()

    def test_setNext(self):
        n = Node(1)
        assert None == n.getNext()
        n.setNext(Node(2))
        assert 2 == n.getNext().getData()