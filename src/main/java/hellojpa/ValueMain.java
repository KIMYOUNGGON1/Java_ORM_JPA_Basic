package hellojpa;

public class ValueMain {

    public static void main(String[] args) {

        Integer a = new Integer(10);
        Integer b = a;

//        int a = 10;
//        int b = a;
//
//        a = 20;

//        a.setValue(20);
//        와 같이 변경하면 둘 다 20 출력

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

}
