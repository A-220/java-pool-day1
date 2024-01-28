package ex04.collection.arraylist;

import ex04.model.User;

public interface UsersList {
    void addUser(User user);
    User findUserById(Long id);
    User findUserByIndex(int index);
    User[] getAllUsers();
    int getUsersCount();
}
