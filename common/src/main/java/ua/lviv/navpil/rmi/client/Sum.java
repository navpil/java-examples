package ua.lviv.navpil.rmi.client;

import ua.lviv.navpil.rmi.compute.Task;

import java.io.Serializable;
import java.math.BigDecimal;

public class Sum implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private final int i;

    public Sum(int i) {
        this.i = i;
    }

    @Override
    public BigDecimal execute() {
        return BigDecimal.valueOf(i + i);
    }
}
