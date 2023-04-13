class Script {
//
//    private String name;
//
//    public Script(String name) {
//        this.name = name;
//    }

    public Script() {

    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        args[2] = args[1] + args[0];

        System.out.println("Hello from Java Script");
    }

    public static String getName() {
        return "Dima";
    }
}