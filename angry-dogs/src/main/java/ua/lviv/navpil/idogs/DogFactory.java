package ua.lviv.navpil.idogs;

import java.util.Collection;

public abstract class DogFactory {

    public static DogFactory create() {
        return new AngryDogFactory();
    }

    public abstract Collection<Dog> getDogs();


}
