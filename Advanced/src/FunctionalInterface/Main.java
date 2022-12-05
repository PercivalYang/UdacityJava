package FunctionalInterface;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
//        BinaryOperator<Integer> add = (a, b) -> a + b;
//        assert 5 == add.apply(2, 3);
//        System.out.println(add.apply(2,3));
        Main d = new Main();
        d.test();
    }
    public void test(){
        Runnable r = () -> System.out.println(this.getClass());
        r.run();
    }
}
