package ua.lviv.navpil.idogs;

import java.util.Collection;
import java.util.List;

public class AngryDogFactory extends DogFactory {
    @Override
    public Collection<Dog> getDogs() {
        return List.of(new AngryDog(), new VeryAngryDog());
    }

    private static class AngryDog implements Dog {

        @Override
        public String barkBark() {
            return "BARK-BARK";
        }
    }

    private static class VeryAngryDog implements Dog {

        @Override
        public String barkBark() {
            return "BARK-BARK-BARK";
        }
    }

}
