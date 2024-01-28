package ex04.collection.arraylist;

import ex04.exception.UserNotFoundException;
import ex04.model.User;

public class UsersArrayList implements UsersList {

    private int currLength = 0;
    private User[] arr = new User[10];
    public static final String NOT_FOUND_ID = "User with id: %d doesn't exist";
    public static final String NOT_FOUND_INDEX = "User with index: %d doesn't exist";

    @Override
    public void addUser(User user) {
        if (currLength == arr.length - 1) {
            makeBigger();
        }
        arr[currLength++] = user;
    }

    @Override
    public User findUserById(Long id) {
        for (int i = 0; i < currLength; i++) {
            if (arr[i].getUuid() == id) {
                return arr[i];
            }
        }
        throw new UserNotFoundException(String.format(NOT_FOUND_ID, id));
    }

    @Override
    public User findUserByIndex(int index) {
        if (index < 0 || index > arr.length) {
            throw new UserNotFoundException(String.format(NOT_FOUND_INDEX, index));
        }
        return arr[index];
    }

    @Override
    public User[] getAllUsers() {
        User[] users = new User[currLength];
        for (int i = 0; i < currLength; i++) {
            users[i] = arr[i];
        }
        return  users;
    }

    @Override
    public int getUsersCount() {
        return arr.length;
    }

    private void makeBigger() {
        User[] cashArray = new User[(currLength + 1) * 2];
        for (int i = 0; i < arr.length; i++) {
            cashArray[i] = arr[i];
        }
        arr = cashArray;
    }

}
