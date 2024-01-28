package ex04.util;

public class UserIdsGenerator {
    private Long id = 0L;

    private UserIdsGenerator() {
    }

    private static class Holder {
        private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    }

    public static UserIdsGenerator getInstance() {
        return Holder.INSTANCE;
    }

    public Long generateId() {
        return ++id;
    }
}

