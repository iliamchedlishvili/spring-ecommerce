package home.spring_ecommerce.infrastructure.repositories;

import home.spring_ecommerce.domain.entities.emp.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
