package ex04.collection.linkedlist;

import ex04.model.Transaction;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void addAllTransactions(Transaction[] transactions);

    void deleteTransactionByUUID(UUID tranascationId);

    Transaction[] toArray();
}
