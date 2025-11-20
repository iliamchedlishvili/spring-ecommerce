package home.spring_ecommerce.infrastructure.repositories;

import home.spring_ecommerce.application.dtos.user.UserListViewDto;
import home.spring_ecommerce.domain.entities.emp.UserEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT new home.spring_ecommerce.application.dtos.user.UserListViewDto( "
            + "u.id, "
            + "u.username, "
            + "e.firstname, "
            + "e.lastname, "
            + "ut.name) "
            + "FROM UserEntity u "
            + "JOIN u.employee e "
            + "JOIN u.userType ut")
    List<UserListViewDto> getUsersList();

    @Query("SELECT new home.spring_ecommerce.application.dtos.user.UserListViewDto( "
            + "u.id, "
            + "u.username, "
            + "e.firstname, "
            + "e.lastname, "
            + "ut.name) "
            + "FROM UserEntity u "
            + "JOIN u.employee e "
            + "JOIN u.userType ut "
            + "WHERE u.id = :userId")
    Optional<UserListViewDto> findUserViewById(@Param("userId") Long userId);
}
