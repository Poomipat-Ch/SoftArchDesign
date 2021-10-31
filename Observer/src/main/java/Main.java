import java.util.Scanner;

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
            System.out.print("Enter your text (enter 'q' to exit) : ");
            String text = scanner.nextLine();
            if (!"q".equals(text)){
                publisher.submit(text);
            } else {
                publisher.finish();
                break;
            }
        }
    }
}
