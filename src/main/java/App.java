public class App {
    public static void main(String... args) {
        MyArrayList<String> myArr = new MyArrayList<>();
        myArr.add("Hello!");
        myArr.add("Yo!");

        for (int i = 0; i < 10; i++) {
            myArr.add("Boss" + i);
        }

        System.out.println(myArr.get(0));
        System.out.println(myArr.get(1));
        System.out.println(myArr.get(9));
        System.out.println(myArr.contains("Boss9"));
    }
}
