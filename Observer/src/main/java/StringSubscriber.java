import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {

    protected FileWriter fileWriter;
    protected PrintWriter printWriter;

    StringSubscriber(String name) {
        try {
            this.fileWriter = new FileWriter("src/main/resources/"+name+".txt");
            this.printWriter = new PrintWriter(fileWriter);
        }    catch (IOException ex){
            System.out.println("Cannot write file due to IOException");
        }
    }

    @Override
    public abstract void onSubscribe(Flow.Subscription subscription);

    @Override
    public abstract void onNext(String item);

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public abstract void onComplete();

    public abstract boolean isContain(String item);
}
