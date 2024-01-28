package ex04.service;

import ex04.collection.arraylist.UsersArrayList;
import ex04.collection.arraylist.UsersList;
import ex04.collection.linkedlist.TransactionsLinkedList;
import ex04.collection.linkedlist.TransactionsList;
import ex04.enums.TransferCategory;
import ex04.model.Transaction;
import ex04.model.User;

import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {
    UsersList usersList = new UsersArrayList();

    @Override
    public void addUser(User user) {
        usersList.addUser(user);
    }

    @Override
    public Double getBalance(Long id) {
        return usersList.findUserById(id).getBalance();
    }

    @Override
    public Double getBalance(User user) {
        return usersList.findUserById(user.getUuid()).getBalance();
    }

    @Override
    public void executeTransaction(Long recipientId, Long senderId, Double amount) {
        User sender = usersList.findUserById(senderId);
        User recipient = usersList.findUserById(recipientId);

        Transaction credit = Transaction.builder()
                .id(UUID.randomUUID())
                .recipient(sender)
                .sender(recipient)
                .transferCategory(TransferCategory.CREDITS)
                .transferAmount(-amount)
                .build();

        Transaction debit = Transaction.builder()
                .id(credit.getId())
                .recipient(recipient)
                .sender(sender)
                .transferCategory(TransferCategory.DEBITS)
                .transferAmount(amount)
                .build();

        recipient.setTransaction(debit);
        sender.setTransaction(credit);

        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
    }

    @Override
    public Transaction[] getTransactionsOfUser(Long userId) {
        return usersList.findUserById(userId).getTransactionsLinkedList().toArray();
    }

    @Override
    public Transaction[] checkValidityOfTransactions() {
        Transaction[] allTransactions = getAllTransactions();
        TransactionsList result = new TransactionsLinkedList();
        if (allTransactions != null) {
            int size = allTransactions.length;
            for (int i = 0; i < size; i++) {
                int count = 0;
                for (int j = 0; j < size; j++) {
                    if (allTransactions[i].getId().equals(allTransactions[j].getId())) {
                        count++;
                    }
                }
                if (count != 2) {
                    result.addTransaction(allTransactions[i]);
                }
            }
        }
        return result.toArray();
    }

    private Transaction[] getAllTransactions() {
        TransactionsList transactionsList = new TransactionsLinkedList();
        for (User user : usersList.getAllUsers()) {
            if (user != null) {
                transactionsList.addAllTransactions(user.getTransactionsLinkedList().toArray());
            }
        }
        return transactionsList.toArray();
    }
}
