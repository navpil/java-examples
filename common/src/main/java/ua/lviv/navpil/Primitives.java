package ua.lviv.navpil;

public class Primitives {

    public static void main(String[] args) {
//        System.out.println(Byte.parseByte("10000001", 2));
        byte b = (byte) 0b11111111;
        System.out.println(b);

        String x = Integer.toBinaryString(-1);
        System.out.println(x);

        System.out.println(Integer.parseUnsignedInt(x, 2));

        System.out.println((byte)Integer.parseUnsignedInt("11111111",2));

//        Integer.parseUnsignedInt()

    }

}
