package ua.lviv.navpil.chain;

import java.util.function.Function;

public class SimpleChain<Param, Result> {

    private final Function<Param, Result> function;

    public SimpleChain(Function<Param, Result> function) {
        this.function = function;
    }

    public <NewResult> SimpleChain<Param, NewResult> withReturn(Function<Result, NewResult> chained) {
        return new SimpleChain<>(param -> chained.apply(function.apply(param)));
    }

    public Result execute(Param param) {
        return function.apply(param);
    }

}
