import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber{
    private StringSubscription subscription;


    AlphabetSubscriber() {
        super("Alphabet");
    }

    @Override
    public boolean isContain(String item) {
        return item.matches(".*[a-zA-Z].*");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("AlphabetSubscribed");
        this.subscription = (StringSubscription) subscription;
//        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Alphabet : received");
        this.printWriter.printf("%s\n", item);
//        this.subscription.request(1);
    }

    @Override
    public void onComplete() {
        this.printWriter.close();
        System.out.println("-----------AlphabetCompleted------------");
    }
}
