package ex00;

import ex00.enums.TransferCategory;
import ex00.model.Transaction;
import ex00.model.User;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user = User.builder()
                .uuid(UUID.randomUUID())
                .name("Test name for User 1")
                .balance(15000.0)
                .build();
        System.out.println(user);

        User user1 = User.builder()
                .uuid(UUID.randomUUID())
                .name("Test name for User 2")
                .balance(15000.0)
                .build();
        System.out.println(user1);

        Transaction transaction = Transaction.builder()
                .id(UUID.randomUUID())
                .recipient(user)
                .sender(user1)
                .transferCategory(TransferCategory.CREDITS)
                .transferAmount(user1.getBalance())
                .build();
        System.out.println(transaction);
    }


}
