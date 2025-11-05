package home.spring_ecommerce.domain.entities.log;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
@Table(name = "error_logs", schema = "log")
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String errorText;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @CreationTimestamp
    private Instant createDate; // Automatically set on creation
}
