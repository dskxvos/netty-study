package reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class SampleMonoSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value+" from SampleSubscriber");
        request(1);
    }
}
