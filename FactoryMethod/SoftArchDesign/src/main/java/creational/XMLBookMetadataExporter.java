package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter{

    @Override
    public BookMetadataFormatter getFormatter() throws ParserConfigurationException {
        return new XMLBookMetadataFormatter();
    }
}
