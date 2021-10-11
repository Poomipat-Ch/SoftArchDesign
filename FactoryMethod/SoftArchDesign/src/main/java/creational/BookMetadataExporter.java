package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) throws IOException, ParserConfigurationException {
        BookMetadataFormatter formatter = getFormatter();
        for (Book b : books){
            formatter.append(b);
        }
        stream.println(formatter.getMetadataString());
    }

    public abstract BookMetadataFormatter getFormatter() throws IOException, ParserConfigurationException;
}
