package creational;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private ArrayList<JSONObject> books;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }


    @Override
    public BookMetadataFormatter reset() {
        books = new ArrayList<>();
        return null;
    }
    @Override
    public BookMetadataFormatter append(Book b) {
//        HashMap can be used, but when passed to a JSONObject it will not be sequential.
//        HashMap<String, Object> book = new HashMap<>();
        JSONObject book = new JSONObject();
        List<String> author = Arrays.asList(b.getAuthors());
        book.put(Book.Metadata.AUTHORS.value, author);
        book.put(Book.Metadata.TITLE.value, b.getTitle());
        book.put(Book.Metadata.ISBN.value, b.getISBN());
        book.put(Book.Metadata.PUBLISHER.value, b.getPublisher());
//        JSONObject b = new JSONObject(book);
        books.add(book);
        return this;
    }

    @Override
    public String getMetadataString() {
        HashMap<String, Object> b = new HashMap<>();
        b.put("Books", books);
        JSONObject book = new JSONObject(b);
        return book.toString();
    }
}
