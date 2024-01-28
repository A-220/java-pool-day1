package ex04.collection.linkedlist;

import ex04.exception.TransactionNotFoundException;
import ex04.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public class TransactionsLinkedList implements TransactionsList {
    private Node tail;
    private Node root;
    private int size;
    public static final String NOT_FOUND = "Transaction with UUID: %s doesn't exist";

    @Override
    public void addTransaction(Transaction transaction) {
        Node node = new Node(null, transaction);
        if (root == null) {
            root = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void addAllTransactions(Transaction[] transactions) {
        for(Transaction t : transactions) {
            addTransaction(t);
        }
    }

    @Override
    public void deleteTransactionByUUID(UUID transactionId) {
        Node current = root;
        Node previous = null;
        while (current != null) {
            if (current.getValue().getId().equals(transactionId)) {
                if (previous == null) {
                    root = current.getNext();
                    if (root == null) {
                        tail = null;
                    }
                } else {
                    previous.setNext(current.getNext());
                    if (current == tail) {
                        tail = previous;
                    }
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        throw new TransactionNotFoundException(String.format(NOT_FOUND, transactionId.toString()));
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] arr = new Transaction[size];
        Node current = root;
        for (int i = 0; current != null; i++) {
            arr[i] = current.getValue();
            current = current.getNext();
        }
        return arr;
    }


    @AllArgsConstructor
    @Getter
    @Setter
    private static class Node {
        private Node next;
        private Transaction value;
    }
}
