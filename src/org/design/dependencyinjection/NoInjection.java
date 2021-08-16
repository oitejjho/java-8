package org.design.dependencyinjection;


class A {
    private StringBuffer b;

    public A() {
        // here A is totally dependent o B
        this.b = new StringBuffer(); // A *depends on* B
    }

    public void DoSomeStuff() {
        // Do something with B here
    }
}
public class NoInjection {

    public static void Main(String[] args) {
        A a = new A();
        a.DoSomeStuff();
    }
}
