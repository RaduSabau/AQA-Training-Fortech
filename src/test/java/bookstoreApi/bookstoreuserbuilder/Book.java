package bookstoreApi.bookstoreuserbuilder;

import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;

@Data
public class Book {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private ZonedDateTime publish_date;
    private String publisher;
    private Integer pages;
    private String description;
    private URI website;
}
