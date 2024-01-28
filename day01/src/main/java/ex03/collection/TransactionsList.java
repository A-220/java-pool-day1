package ex03.collection;

import ex03.model.Transaction;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);

    void deleteTransactionByUUID(UUID tranascationId);

    Transaction[] toArray();
}
