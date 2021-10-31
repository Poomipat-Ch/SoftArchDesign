import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{
    private StringSubscription subscription;


    NumberSubscriber(){
        super("Number");
    }
    @Override
    public boolean isContain(String item) {
        return item.matches(".*\\d.*");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("NumberSubscribed");
        this.subscription = (StringSubscription) subscription;
    }

    @Override
    public void onNext(String item) {
        System.out.println("Number received");
        this.printWriter.printf("%s\n", item);
    }

    @Override
    public void onComplete() {
        this.printWriter.close();
        System.out.println("-----------NumberCompleted------------");
    }
}
