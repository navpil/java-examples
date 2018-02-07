package ua.lviv.navpil.java_history;

public class Covariants {



    public static class AnimalFactory {
        public Animal createCreature() {
            return new Animal();
        }
    }

    public static class MammalFactory extends AnimalFactory {
        public Mammal createCreature() {
            return new Mammal();
        }
    }

    public static class Animal {
    }

    public static class Mammal extends Animal{
    }

}
