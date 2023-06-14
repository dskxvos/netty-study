package reactor;

import reactor.core.publisher.Mono;

public class MonoMain {

    public static void main(String[] args) {

    }

    public static void test1(){
        Mono<String> stringMono = Mono.just("aa");
        stringMono.subscribe(data-> data= data+"dadaism");

    }
}
