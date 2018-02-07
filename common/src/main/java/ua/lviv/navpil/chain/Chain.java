package ua.lviv.navpil.chain;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chain<Param, Result> {

    public static <Param, Result> SimpleChain<Param, Result> from(Function<Param, Result> function) {
        return new SimpleChain<>(function);
    }

    public static <Param, Result, CallbackParam> CallbackableChain<Param, Result, CallbackParam> from(BiFunction<Param, Function<CallbackParam, Result> ,Result> biFunction) {
        return new CallbackableChain<>(biFunction);
    }

}


