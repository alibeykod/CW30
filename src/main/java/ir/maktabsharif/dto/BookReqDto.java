package ir.maktabsharif.dto;

public record BookReqDto (
        String title,
        String author ,
        Integer publicationYear
) {
}
