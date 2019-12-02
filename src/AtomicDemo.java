/**
 * https://www.jianshu.com/p/84c75074fa03
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User name: " + name + ", age: " + age;
    }
}

public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    private static int[] intArray = new int[]{1, 2, 3};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArray);

    private static AtomicReference<User> atomicReference = new AtomicReference<>();

    private static AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        System.out.println("## Demo 1 ##");
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());

        System.out.println("## Demo 2 ##");
        System.out.println(atomicIntegerArray.getAndAdd(0, 5));
        System.out.println(atomicIntegerArray.get(0));

        System.out.println("## Demo 3 ##");
        atomicReference.set(new User("Tony Yang", 41));
        System.out.println(atomicReference.get());
        atomicReference.getAndSet(new User("Kelly Shi", 11));
        System.out.println(atomicReference.get());

        System.out.println("## Demo 4 ##");
        User user = new User("Terry Yan", 10);
        System.out.println(user);
        atomicIntegerFieldUpdater.getAndAdd(user, 10);
        System.out.println(user);
    }
}
