package home.spring_ecommerce.infrastructure.repositories;

import home.spring_ecommerce.domain.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
