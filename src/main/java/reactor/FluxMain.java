package reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxMain {

    public static void main(String[] args) {

        test3();

    }

    public static void test1(){
        Flux<Integer> integerFlux = Flux.just(1,2,3,4);
//        integerFlux.subscribe();
        integerFlux.subscribe(i->{
            System.out.println(i);
        });
    }

    public static void test2(){
        SampleFluxSubscriber<Integer> ss = new SampleFluxSubscriber();
        Flux<Integer> integerFlux = Flux.range(1,4);
        integerFlux.subscribe(i-> System.out.println(i),error-> System.err.println(error.getMessage()),()-> System.out.println("Done"));

        integerFlux.subscribe(ss);
    }

    public static void test3(){
        Flux<String> stringFlux = Flux.generate(
                ()->0,
                (state,skin)->{
                    skin.next("3 * "+state+ " = "+ 3*state);
                    if (state == 10){
                        skin.complete();
                    }
                    return state+1;
                },(state)->{
                    System.out.println(state);
                });
        stringFlux.subscribe(doc-> System.out.println(doc));

    }

    public static void test4(){

    }


}
