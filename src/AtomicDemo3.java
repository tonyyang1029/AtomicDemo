import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo3 {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        atomicReference.compareAndSet(0,1);
        atomicReference.compareAndSet(0,2);
        System.out.println(atomicReference.get());
    }
}
