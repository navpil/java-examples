package ua.lviv.navpil.idogs;

import java.util.Collection;

public abstract class DogFactory {

    public static DogFactory create() {
        throw new UnsupportedOperationException("Need to use implementation instead");
    }

    public abstract Collection<Dog> getDogs();


}
