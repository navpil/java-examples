package ua.lviv.navpil.collections;

public class HashCodes {

    public static void main(String[] args) {

        /*
         -XX:hashCode=0 - global Park-Miller RNG (default until Java 7)
         -XX:hashCode=1 - function(obj_address, global_state)
         -XX:hashCode=2 - constant 1. All objects will have the same hashCode. Just for testing.
         -XX:hashCode=3 - incremental counter.
         -XX:hashCode=4 - lower 32 bits of the object address in the Heap
         -XX:hashCode=5 - thread-local Marsaglia's Xor-shift RNG (default since Java 8)
         */

        for (int i = 0; i < 10; i++) {
            System.out.println(new Object().hashCode());
        }

    }
}
