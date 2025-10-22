package home.spring_ecommerce.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "emp")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
