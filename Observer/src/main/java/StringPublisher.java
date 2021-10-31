import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String> {
    private final List<StringSubscription> subscriptions;
    private final List<StringSubscriber> subscribers;

    StringPublisher() {
        this.subscriptions = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void submit(String text){
        for (int i = subscribers.size() - 1; i >= 0; i--) {
            if (this.subscribers.get(i).isContain(text))
                this.subscriptions.get(i).submit(text);
        }
    }

    public void finish(){
        for (StringSubscription subscription : this.subscriptions){
            subscription.request(0);
        }
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber);
        this.subscriptions.add(subscription);
        this.subscribers.add((StringSubscriber) subscriber);
        subscriber.onSubscribe(subscription);
    }
}
