package com.source.problems;

import java.util.HashMap;

class LRUCache {
	private int capactiy;
	private HashMap<Integer, Node> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capactiy = capacity;
		head.next = tail;
		tail.prev = head;
	}

	class Node {
		int key;
		int val;
		Node prev;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	private void addNode(Node newnode) {
		Node temp = head.next;

		newnode.next = temp;
		newnode.prev = head;

		head.next = newnode;
		temp.prev = newnode;
	}

	private void deleteNode(Node delnode) {
		Node prevv = delnode.prev;
		Node nextt = delnode.next;

		prevv.next = nextt;
		nextt.prev = prevv;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node resNode = map.get(key);
			int ans = resNode.val;

			map.remove(key);
			deleteNode(resNode);
			addNode(resNode);

			map.put(key, head.next);
			return ans;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node curr = map.get(key);
			map.remove(key);
			deleteNode(curr);
		}

		if (map.size() == capactiy) {
			map.remove(tail.prev.key);
			deleteNode(tail.prev);
		}

		addNode(new Node(key, value));
		map.put(key, head.next);
	}
}

