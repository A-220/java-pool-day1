package ex01;


import ex01.model.User;

public class Program {
    public static void main(String[] args) {
        User user = new User("Sasha", 200.0);
        User user1 = new User("Maksim", 300.0);
        System.out.println(user);
        System.out.println(user1);
    }
}
