package ua.lviv.navpil.collections;

import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDisregardsEquals {


    public static void main(String[] args) {
        Set<Animal> animals = new TreeSet<>();
        Animal rexDog = new Animal("Rex", "Dog");
        Animal rexCat = new Animal("Rex", "Cat");
        animals.add(rexDog);
        animals.add(rexCat);

        System.out.println("Animals size: " + animals.size());

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        //Javadoc for contains(): Returns true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
        System.out.println("animals.contains(rexCat): " + animals.contains(rexCat));
        System.out.println("animals.contains(rexDog): " + animals.contains(rexDog));

        System.out.println("cat.equals(dog): " + rexCat.equals(rexDog));

        animals.remove(rexCat);

        System.out.println(animals.size());

    }

    public static class Animal implements Comparable<Animal> {

        private final String name;
        private final String breed;

        public Animal(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        @Override
        public int compareTo(@NotNull Animal o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
            return breed != null ? breed.equals(animal.breed) : animal.breed == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (breed != null ? breed.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", breed='" + breed + '\'' +
                    '}';
        }
    }
}
