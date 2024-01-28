package ex04;

import ex04.service.TransactionService;
import ex04.service.TransactionServiceImpl;

public class Program {
    public static void main(String[] args) {
        TransactionService service = new TransactionServiceImpl();
        // TODO: 28.01.2024 add menu 
    }

    public static void menu() {
        System.out.println("1. Add a user\n" +
                "2. View user balances\n" +
                "3. Perform a transfer\n" +
                "4. View all transactions for a specific user\n" +
                "5. DEV – remove a transfer by ID\n" +
                "6. DEV – check transfer validity\n" +
                "7. Finish execution");
    }
}
