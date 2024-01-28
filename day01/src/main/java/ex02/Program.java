package ex02;

import ex02.collection.UsersArrayList;
import ex02.collection.UsersList;
import ex02.exception.UserNotFoundException;
import ex02.model.User;

public class Program {
    public static void main(String[] args) {
        User user = new User("Sasha", 150.0);
        UsersList usersList = new UsersArrayList();
        usersList.addUser(user);
        System.out.println(usersList.findUserById(1L));
        try {
            System.out.println(usersList.findUserById(100l));
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(usersList.findUserByIndex(0));
        try {
            System.out.println(usersList.findUserByIndex(100));
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        usersList.addUser(user);
        System.out.println("get User count: " + usersList.getUsersCount());

    }
}
