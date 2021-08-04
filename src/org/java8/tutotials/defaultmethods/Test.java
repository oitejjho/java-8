package org.java8.tutotials.defaultmethods;

public class Test {


    public static void main(String args[]){

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
        Formula formula1 = a  -> a * 100;
        System.out.println(formula1.calculate(10));
        System.out.println(formula1.sqrt(10));



        //conventional way
        FormulaWithFunctionalInterface formulaWithFunctionalInterface = new FormulaWithFunctionalInterface() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
        };
        System.out.println(formulaWithFunctionalInterface.calculate(10));
        System.out.println(formulaWithFunctionalInterface.sqrt(10));
        //lambda way
        FormulaWithFunctionalInterface formulaWithFunctionalInterface1 = a  -> a * 100;
        System.out.println(formulaWithFunctionalInterface1.calculate(10));
        System.out.println(formulaWithFunctionalInterface1.sqrt(10));


    }
}
