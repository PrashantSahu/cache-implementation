package org.prashant.data_structure;

public class DoublyLinkedListNode<E> {

    public DoublyLinkedListNode<E> prev;
    public DoublyLinkedListNode<E> next;
    public E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
    }

}
