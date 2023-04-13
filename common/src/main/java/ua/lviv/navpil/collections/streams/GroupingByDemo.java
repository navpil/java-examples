package ua.lviv.navpil.collections.streams;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

public class GroupingByDemo {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i < 5 ? "John": "Bill", i + 40));
        }

        users.stream().collect(groupingBy(User::getName,
                mapping(User::getAge, toList())));
    }


    static class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

}

