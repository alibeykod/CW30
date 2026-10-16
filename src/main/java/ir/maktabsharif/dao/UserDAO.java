package ir.maktabsharif.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(
        name = "users"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private List<BookDAO> books;
}
