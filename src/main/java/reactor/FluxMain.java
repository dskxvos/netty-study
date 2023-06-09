package reactor;

import reactor.core.publisher.Flux;

public class FluxMain {

    public static void main(String[] args) {

        test2();

    }

    public static void test1(){
        Flux<Integer> integerFlux = Flux.just(1,2,3,4);
//        integerFlux.subscribe();
        integerFlux.subscribe(i->{
            System.out.println(i);
        });
    }

    public static void test2(){
        Flux<Integer> integerFlux = Flux.range(1,4)
                .map(i->{
                    if (i<=3){
                        return i;
                    }
                    throw new RuntimeException("the number is Greater than 4");
                });
        integerFlux.subscribe(i-> System.out.println(i),error-> System.err.println(error.getMessage()));
    }
}
