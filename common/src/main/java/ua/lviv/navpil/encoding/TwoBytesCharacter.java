package ua.lviv.navpil.encoding;

public class TwoBytesCharacter {
    public static void main(String[] args) {


        //battery"
        System.out.println("Showing battery");
        String s = "\uD83D\uDCF6";
        System.out.println(s);

        System.out.println("This is a Sumerian double-character");
        System.out.println("\uD800" + (char)57220);
        System.out.println("\uD800");
        System.out.println((char)57220);

        System.out.println("Chinese are two-byte chars, another one is four-byte character");
        char c = '\uDF1B';
        c = (char)57115;
        String chinese = "爱你\uD800" + c;
//        System.out.println((int)c);

        System.out.println("Chinese stats and chars one by one:");
        System.out.println(chinese);
        System.out.println("Length: " + chinese.length());
        System.out.println(chinese.charAt(0));
        System.out.println(chinese.charAt(1));
        System.out.println(chinese.charAt(2));
        System.out.println(chinese.charAt(3));



//        for (int i = 57000; i < 58000; i++) {
//            System.out.println(i + "\uD800" + (char)i);
//        }
        System.out.println("Just fun symbols");
        System.out.print("\uE1E5");
        System.out.print("\uE1E6");
        System.out.print("\uE1E7");
        System.out.print("\uE1E8");
        System.out.println("\uE1E9");


    }
}
