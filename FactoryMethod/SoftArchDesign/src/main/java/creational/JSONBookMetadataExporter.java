package creational;

import java.io.IOException;

public class JSONBookMetadataExporter extends BookMetadataExporter{

    @Override
    public BookMetadataFormatter getFormatter() throws IOException {
        return new JSONBookMetadataFormatter();
    }
}
