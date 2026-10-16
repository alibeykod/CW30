package ir.maktabsharif.dto;

public record BookRespDto(
        Long id ,
        String title ,
        String author,
        Integer publicationYear
) {
}
