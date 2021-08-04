package org.java8.tutotials.defaultmethods;

public class Test {


    public static void main(String[] args) {

        //conventional way
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
            /*@Override
            public double calculate1(int a, int b){
                return a * b;
            }*/
            //in the old way we can override as many as methods we can
            // but using lambda we can only override one method, which means we can have only one abstract method
            // and its called functional interface
        };
        System.out.println(formula.calculate(10));
        System.out.println(formula.sqrt(10));

        //lambda way
        Formula formula1 = a -> a * 100;
        System.out.println(formula1.calculate(10));
        System.out.println(formula1.sqrt(10));


        //conventional way
        // instantiate interface using conventional overiding
        FormulaWithFunctionalInterface formulaWithFunctionalInterfaceConventional = new FormulaWithFunctionalInterface() {
            @Override
            public void calculate(int a) {
                System.out.println("Functional interface with conventional way value " + a);
            }
        };
        formulaWithFunctionalInterfaceConventional.calculate(10);
        System.out.println(formulaWithFunctionalInterfaceConventional.sqrt(10));
        //lambda way
        // instantiate using lambda expression
        FormulaWithFunctionalInterface formulaWithFunctionalInterfaceLambda = (a) -> System.out.println("Functional interface with lambda way value " + a);
        formulaWithFunctionalInterfaceLambda.calculate(10);
        System.out.println(formulaWithFunctionalInterfaceLambda.sqrt(10));
        //instantiate using static method reference
        FormulaWithFunctionalInterface formulaWithFunctionalInterfaceStaticMethodReference = StaticClass::staticMethod;
        formulaWithFunctionalInterfaceStaticMethodReference.calculate(10);
        System.out.println(formulaWithFunctionalInterfaceStaticMethodReference.sqrt(10));
        //instantiate using non static method reference
        FormulaWithFunctionalInterface formulaWithFunctionalInterfaceNonStaticMethodReference = new NonStaticClass()::nonStaticMethod;
        formulaWithFunctionalInterfaceNonStaticMethodReference.calculate(10);
        System.out.println(formulaWithFunctionalInterfaceNonStaticMethodReference.sqrt(10));
        //instantiate using constructor method reference
        FormulaWithFunctionalInterface formulaWithFunctionalInterfaceConstructorMethodReference = NonStaticConstructorClass::new;
        formulaWithFunctionalInterfaceConstructorMethodReference.calculate(10);
        System.out.println(formulaWithFunctionalInterfaceConstructorMethodReference.sqrt(10));


    }
}

class StaticClass {
    public static void staticMethod(int a){
        System.out.println("Functional interface with static method reference way value " + a);
    }
}

class NonStaticClass{
    public void nonStaticMethod(int a){
        System.out.println("Functional interface with non static method reference way value " + a);
    }
}

class NonStaticConstructorClass{

    public NonStaticConstructorClass(int a){
        System.out.println("Functional interface with constructor method reference way value " + a);
    }
}
