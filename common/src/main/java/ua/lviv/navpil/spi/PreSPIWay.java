package ua.lviv.navpil.spi;

import ua.lviv.navpil.idogs.Dog;
import ua.lviv.navpil.idogs.DogFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PreSPIWay {

    public List<String> getAllDogsBarking() {
        DogFactory dogFactory = DogFactory.create();
        return dogFactory.getDogs().stream().map(Dog::barkBark).collect(Collectors.toList());
    }

}
