import java.util.*;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private final Flow.Subscriber<? super String> subscriber;
    private boolean completed;
    private final LinkedList<String> payloads;
    StringSubscription(Flow.Subscriber<? super String> subscriber){
        this.subscriber = subscriber;
        this.payloads = new LinkedList<>();
    }

    public void submit(String text) {
        this.payloads.push(text);
        this.request(1);
    }

    @Override
    public void request(long n) {
        if (n != 0 && !this.completed){
            if (n < 0){
                IllegalArgumentException ex = new IllegalArgumentException();
                this.subscriber.onError(ex);
            } else {
                if (!this.payloads.isEmpty()) {
                    this.subscriber.onNext(this.payloads.pop());
                }
            }
        }else {
            this.completed = true;
            this.subscriber.onComplete();
        }
    }

    @Override
    public void cancel() {
        this.completed = true;
        this.subscriber.onComplete();
    }
}
