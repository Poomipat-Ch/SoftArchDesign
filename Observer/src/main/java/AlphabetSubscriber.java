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
        return item.matches(".*[a-zA-z].*");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("AlphabetSubscribed");
        this.subscription = (StringSubscription) subscription;
    }

    @Override
    public void onNext(String item) {
        System.out.println("Alphabet : received");
        this.printWriter.printf("%s\n", item);
    }

    @Override
    public void onComplete() {
        this.printWriter.close();
        System.out.println("-----------AlphabetCompleted------------");
    }
}
