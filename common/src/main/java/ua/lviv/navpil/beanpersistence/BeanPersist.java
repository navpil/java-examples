package ua.lviv.navpil.beanpersistence;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BeanPersist {

    public static void main(String[] args) throws FileNotFoundException {
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Beanarchive.xml")));
        xmlEncoder.writeObject(new User("Jim", 25));
        xmlEncoder.close();
    }

    public static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
