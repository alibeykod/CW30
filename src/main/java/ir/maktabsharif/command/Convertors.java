package ir.maktabsharif.command;
import ir.maktabsharif.dao.BookDAO;
import ir.maktabsharif.dao.UserDAO;
import ir.maktabsharif.dto.BookReqDto;
import ir.maktabsharif.dto.BookRespDto;
import ir.maktabsharif.dto.UserRequestDto;
import ir.maktabsharif.dto.UserResponseDto;

public class Convertors {
    public static UserResponseDto userDaoToUserRespDto(UserDAO userDAO) {
        UserResponseDto userResponseDto = new UserResponseDto(
                userDAO.getId(),
                userDAO.getUsername()
        );
        return userResponseDto;
    }

    public static UserDAO userReqDtoToUserDao(UserRequestDto userRequestDto){
        UserDAO userDAO = UserDAO.builder()
                .username(userRequestDto.username())
                .password(userRequestDto.password())
                .build();
        return userDAO;
    }

    public static BookDAO bookRequestDtoToBookDao(BookReqDto bookReqDto){
        BookDAO bookDAO = BookDAO.builder()
                .author(bookReqDto.author())
                .publicationYear(bookReqDto.publicationYear())
                .title(bookReqDto.title())
                .build();
        return bookDAO;
    }

    public static BookRespDto bookDaoToBookRespDto(BookDAO bookDAO){
        BookRespDto bookRespDto = new BookRespDto(
                bookDAO.getId(),
                bookDAO.getAuthor(),
                bookDAO.getTitle(),
                bookDAO.getPublicationYear()
        );
        return bookRespDto;
    }
}
