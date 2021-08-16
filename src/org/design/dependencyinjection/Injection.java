package org.design.dependencyinjection;


class C {
    private StringBuffer b;

    public C(StringBuffer b) {
        // here A is totally dependent o B
        this.b = b; // A *is not dependent on* B
        // and b can be injected from outside from a central point
        // this is how dependency is inverted to caller code
        // StringBuffer should be actually an interface variable
        // so that in runtime it'll behave polymorphic
        // it also covered the L in SOLID principal
        // it also covers the D in SOLID principal
    }

    public void DoSomeStuff() {
        // Do something with B here
    }
}

public class Injection {

    public static void Main(String[] args) {
        StringBuffer b = new StringBuffer();
        C c = new C(b);
        c.DoSomeStuff();
    }
}
