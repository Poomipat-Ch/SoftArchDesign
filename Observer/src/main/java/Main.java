import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class Main {
    public static void main (String[] arg){
        StringPublisher publisher = new StringPublisher();
        StringSubscriber alphabetSubscriber = new AlphabetSubscriber();
        StringSubscriber numberSubscriber = new NumberSubscriber();
        StringSubscriber symbolSubscriber = new SymbolSubscriber();
        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your text : ");
            String text = scanner.nextLine();
            if (!"q".equals(text)){
                publisher.submit(text);
            } else {
                break;
            }

        }
        publisher.finish();
    }
}
