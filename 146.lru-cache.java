import java.util.*;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 * method1: 自己实现双端队列, Node 需要自带 pre, next 指针, 不然无法O(1)时间找到前后指针并删除 node.
 * method2: use LinkedHashMap
 */

// @lc code=start
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// method 1: one dequeue
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    {
        head.next = tail;
        tail.pre = head;
    }
    int capacity;

    /* methods for deque */
    private void addTail(Node node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private Node removeHead() {
        Node node = head.next;
        if (node == tail) {
            return null;
        }
        remove(node);
        return node;

    }

    public int remove(int key) {
        Node node = map.remove(key);
        remove(node);
        return node.value;
    }

    public void add(int key, int value) {
        Node node = new Node(key, value);
        map.put(key, node);
        addTail(node);
    }

    public void evict() {
        Node node = removeHead();
        map.remove(node.key);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = remove(key);
        add(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        }
        add(key, value);
        if (map.size() > capacity) {
            evict();
        }
    }
}

// @lc code=end

// method 2: use LinkedHashMap
class LRUCache1 {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public void makeRecent(int k) {
        if (map.containsKey(k)) {
            int val = map.remove(k);
            map.put(k, val);
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            makeRecent(key);
        }
        map.put(key, value);
        if (map.size() > capacity) {
            // remove last recent
            int last = map.keySet().iterator().next();
            map.remove(last);
        }
    }
}
