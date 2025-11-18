package home.spring_ecommerce.domain.entities.emp;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "emp")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    // @JoinColumn specifies the foreign key column name in the 'users' table
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    private String password;
}
