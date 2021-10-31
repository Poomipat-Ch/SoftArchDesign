import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber{
    private StringSubscription subscription;

    SymbolSubscriber(){
        super("Symbol");
    }

    @Override
    public boolean isContain(String item){
        return item.matches(".*[/[!-/:-@{-~\\\"^_`\\[\\]]/].*");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("SymbolSubscribed");
        this.subscription = (StringSubscription) subscription;
//        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Symbol received");
        printWriter.printf("%s\n", item);
//        this.subscription.request(1);
    }

    @Override
    public void onComplete() {
        this.printWriter.close();
        System.out.println("-----------SymbolCompleted------------");
    }
}
