package ua.lviv.navpil.spi;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreSPIWayTest {

    @Test@Ignore("Ignoring because it will fail")
    public void getAllDogsBarking() {
        PreSPIWay preSPIWay = new PreSPIWay();

        System.out.println(preSPIWay.getAllDogsBarking());

    }
}