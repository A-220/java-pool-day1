package ex02.collection;

import ex02.model.User;

public interface UsersList {
    void addUser(User user);
    User findUserById(Long id);
    User findUserByIndex(int index);
    int getUsersCount();
}
