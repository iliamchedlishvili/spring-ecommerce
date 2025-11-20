package home.spring_ecommerce.domain.entities.emp;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_types", schema = "emp")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserType() {
    }

    private String name;

    public Long getId() {
        return id;
    }

    public UserType(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType(Long id) {
        this.id = id;
    }

    @OneToMany(
            mappedBy = "userType", // Name of the field in the 'many' side (User)
            cascade = CascadeType.ALL, // Cascade operations (e.g., delete UserType, delete all Users)
            fetch = FetchType.LAZY, // Only load Users when explicitly requested (best practice)
            orphanRemoval = true // Remove child Users if they are disassociated from the parent UserType
    )
    private Set<UserEntity> users = new HashSet<>();
}
