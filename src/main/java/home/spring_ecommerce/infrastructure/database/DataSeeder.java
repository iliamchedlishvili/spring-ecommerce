/*package home.spring_ecommerce.infrastructure.database;

import home.spring_ecommerce.domain.entities.UserType;
import home.spring_ecommerce.infrastructure.repositories.UserTypeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSeeder {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @PostConstruct
    public void seed(){
        if(userTypeRepository.count() == 0){
            userTypeRepository.save(new UserType("admin"));
            userTypeRepository.save(new UserType("manager"));
            userTypeRepository.save(new UserType("operator"));
        }
    }
}
*/