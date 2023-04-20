package ua.lviv.navpil.testingprespi;

import ua.lviv.navpil.spi.PreSPIWay;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> allDogsBarking = new PreSPIWay().getAllDogsBarking();
        System.out.println(allDogsBarking);
    }
}
