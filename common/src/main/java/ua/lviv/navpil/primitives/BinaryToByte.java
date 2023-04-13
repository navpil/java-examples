package ua.lviv.navpil.primitives;

public class BinaryToByte {

    public static void main(String[] args) {
        String zeroes = "00000000";
        int i = Integer.parseUnsignedInt("10000000" + zeroes + zeroes + zeroes, 2);

        assert i == Integer.MIN_VALUE;

        byte b1 = (byte)-0b10000000;
        byte b2 = (byte)0b10000000;
        System.out.println(b1 == b2);
        System.out.println((byte)-0b10000000 == (byte)0b10000000);

        System.out.println((byte)-0b00000001 == (byte)0b11111111);

        compareIntAsBytes(0b10000000);
    }

    public static void compareIntAsBytes(int a) {
        if (a != 0 && (byte)-a == (byte)a) {
            System.out.println("" + a + " is magical");
        }
    }
}
