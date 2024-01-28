package ex04.model;

import ex04.collection.linkedlist.TransactionsLinkedList;
import ex04.collection.linkedlist.TransactionsList;
import ex04.util.UserIdsGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {
    private Long uuid;
    private String name;
    private Double balance;
    private final TransactionsList transactionsLinkedList = new TransactionsLinkedList();

    public User(String name, Double balance) {
        this.uuid = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }

    public void setTransaction(Transaction transaction)  {
        transactionsLinkedList.addTransaction(transaction);
    }
}
