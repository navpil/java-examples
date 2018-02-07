package ua.lviv.navpil.chain;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CallbackableChain<Param, Result, CallbackParam> {

    private final BiFunction<Param, Function<CallbackParam, Result>, Result> function;

    public CallbackableChain(BiFunction<Param, Function<CallbackParam, Result>, Result> function) {
        this.function = function;
    }

    public SimpleChain<Param, Result> withCallback(Function<CallbackParam, Result> callback) {
        return new SimpleChain<>(
                param -> function.apply(param, callback)
        );
    }

//    public CallbackableChain withCallback(BiFunction<CallbackParam, Function<CallbackParam, Result>, Result> callback) {
//        return new CallbackableChain(
//                param -> function.apply(param, callback)
//        );
//    }



    public Result execute(Param param, Function<CallbackParam, Result> callback) {
        return function.apply(param, callback);
    }


}
