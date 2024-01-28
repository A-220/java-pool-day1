package ex03.model;

import ex01.utils.UserIdsGenerator;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {
    private Long uuid;
    private String name;
    private Double balance;

    public User(String name, Double balance) {
        this.uuid = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }
}
