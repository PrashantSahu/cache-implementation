package org.prashant.data_structure;

public class DoublyLinkedList<E> {

     public DoublyLinkedListNode<E> dummyHead, dummyTail;

        public DoublyLinkedList() {
            dummyHead = new DoublyLinkedListNode<>(null);
            dummyTail = new DoublyLinkedListNode<>(null);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

     public void addAtHead(DoublyLinkedListNode<E> node) {

                node.next = dummyHead.next;
                node.prev = dummyHead;
                dummyHead.next.prev = node;
                dummyHead.next = node;
            }

     public void removeNode(DoublyLinkedListNode<E> node) {

                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
}
