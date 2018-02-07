package ua.lviv.navpil.collections;

//https://stackoverflow.com/questions/28689203/why-does-jvm-heap-keep-growing
public class LoopOOM {
    public static void main(String[] args) {
        //Infinite loops can't cause OutOfMemory exceptions
        //-Xmx15M
        while (true){}
    }
}
