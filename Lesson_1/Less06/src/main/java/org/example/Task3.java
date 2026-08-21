package org.example;

@FunctionalInterface
interface QuadFunction<T, R> {
    R apply(T a, T b, T c, T d);
}

public class Task3 {

    public void lambdaRun(){
        QuadFunction<Integer, Integer> maxOfFour = (a,b,c,d) ->
                Math.max((Math.max(a,b)), Math.max(c,d));

        QuadFunction<Integer, Integer> minOfFour = (a,b,c,d) ->
                Math.min((Math.min(a,b)), Math.min(c,d));

        System.out.println(maxOfFour.apply(1,5,8,6));
        System.out.println(minOfFour.apply(7,9,5,2));
    }

}
