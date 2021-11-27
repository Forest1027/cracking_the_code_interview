package com.interview.basic.algorithms.real_world_problem;

import java.util.HashMap;

/**
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 * Explanation: https://leetcode.com/problems/lfu-cache/discuss/513157/Java-O(1)-16-ms-(beating-97)-using-2-HashMaps-and-DoublyLinkedList-with-detailed-explanations
 */
public class LFUCache {
    int capacity;
    // map to track key value
    HashMap<Integer, Node> keyNodeMap = new HashMap<>();
    // maintain a map that tracks a linkedlist for each frequency
    HashMap<Integer, NodeDLinkedList> freqNodeDLLMap = new HashMap<>();
    int minumumFrequency = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if (node != null) {                                                               //Item exists
            incrementFrequency(node);                                                   //Increment frequency
            return node.value;                                                          //Return value
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (capacity <= 0) return;

        if (keyNodeMap.containsKey(key)) {                                                //Item exists

            Node node = keyNodeMap.get(key);                                            //Get old node
            node.value = value;                                                         //Update with new value
            incrementFrequency(node);                                                   //Increment frequency
            keyNodeMap.put(key, node);                                                  //Put (update) in cache
        } else {                                                                           //Item doesn't exist

            Node node = new Node(key, value);                                           //Create new node

            if (keyNodeMap.size() == capacity) {                                          //Cache is full
                Node removedLastNode = freqNodeDLLMap.get(minumumFrequency)
                        .removeLastNode();                              //Remove LFU node from removedLastNode
                keyNodeMap.remove(removedLastNode.key);                                 //Remove LFU node from cache
            }

            incrementFrequency(node);                                                   //Add to frequency map
            keyNodeMap.put(key, node);                                                  //Add to cache

            minumumFrequency = 1;                                                       //Since new node is having freqency as 1,
            //update minumumFrequency to be 1
        }

    }


    private void incrementFrequency(Node node) {

        int oldFrequency = node.frequency;

        if (freqNodeDLLMap.containsKey(oldFrequency)) {                                   //Frequency already exists
            NodeDLinkedList oldNodeDLinkedList = freqNodeDLLMap.get(oldFrequency);      //Get frequency linkedlist
            oldNodeDLinkedList.remove(node);                                            //Remove current node
            if (node.frequency == minumumFrequency &&                                    //If this frequency was the minumum freq.
                    oldNodeDLinkedList.length == 0) {                                        //and no node is having this freq anymore
                minumumFrequency++;                                                     //Increment minumum frequency
            }
        }

        int newFrequency = oldFrequency + 1;                                            //Increment frequency
        node.frequency = newFrequency;                                                  //Set new frequency to node
        NodeDLinkedList newNodeDLinkedList =                                            //Get or create the LinkedList for
                freqNodeDLLMap.getOrDefault(                                                //this new frequency
                        newFrequency, new NodeDLinkedList()
                );
        newNodeDLinkedList.add(node);                                                   //Add node to the freq linkedlist
        freqNodeDLLMap.put(newFrequency, newNodeDLinkedList);                           //Put freq linkedlist to freqNodeDLLMap
    }


    private class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class NodeDLinkedList {

        Node head, tail;
        int length;

        //Add a node to top
        void add(Node node) {

            //Remove old pointers
            node.prev = null;
            node.next = null;

            if (head == null) {                                                               //Empty list
                head = node;
                tail = node;
            } else {
                node.next = head;                                                         //Forward linking
                head.prev = node;                                                         //Backward linking
                head = node;
            }

            length++;
        }

        //Remove a node
        void remove(Node node) {

            if (node == head) {                                                               //Need to remove head node
                if (node == tail) {                                                           //Tail node is the same (list size = 1)
                    tail = null;                                                            //Make tail null
                }
                head = head.next;                                                         //Make head point to the next node
            } else {                                                                         //Need to remove later node
                node.prev.next = node.next;                                               //Forward linking

                if (node == tail) {                                                           //Need to remove tail node
                    tail = node.prev;                                                     //Point tail to prev node
                } else {
                    node.next.prev = node.prev;                                           //Backward linking
                }
            }

            length--;

        }

        //Remove last node
        Node removeLastNode() {

            Node tailNode = tail;

            if (tailNode != null) {                                                         //LastNode exists
                remove(tailNode);
            }
            return tailNode;
        }
    }
}
