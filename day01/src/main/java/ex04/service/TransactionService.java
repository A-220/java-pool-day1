package ex04.service;

import ex04.model.Transaction;
import ex04.model.User;

public interface TransactionService {
    void addUser(User user);
    Double getBalance(Long id);
    Double getBalance(User user);
    void executeTransaction(Long recipientId, Long senderId, Double amount);
    Transaction[] getTransactionsOfUser(Long userId);
    Transaction[] checkValidityOfTransactions();

}
