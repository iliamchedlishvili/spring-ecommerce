package home.spring_ecommerce.application.services;

import home.spring_ecommerce.application.dtos.user.CreateUserDto;
import home.spring_ecommerce.application.dtos.user.EmployeeDetailsDto;
import home.spring_ecommerce.application.dtos.user.UpdateUserDto;
import home.spring_ecommerce.application.dtos.user.UserListViewDto;
import home.spring_ecommerce.domain.entities.emp.Employee;
import home.spring_ecommerce.domain.entities.emp.UserEntity;
import home.spring_ecommerce.domain.entities.emp.UserType;
import home.spring_ecommerce.infrastructure.repositories.EmployeeRepository;
import home.spring_ecommerce.infrastructure.repositories.UserRepository;
import home.spring_ecommerce.infrastructure.repositories.UserTypeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserService(ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       EmployeeRepository employeeRepository,
                       UserTypeRepository userTypeRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.userTypeRepository = userTypeRepository;
    }

    public void addUser(CreateUserDto createUserDto) {
        Employee employee = modelMapper.map(createUserDto.getEmployeeDetails(), Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        UserEntity user = modelMapper.map(createUserDto, UserEntity.class);
        user.setUserType(new UserType(createUserDto.getUserType()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmployee(savedEmployee);
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, UpdateUserDto updateUserDto) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow();
        Employee existingEmployee = existingUser.getEmployee();

        UserType newUserType = userTypeRepository.getReferenceById(updateUserDto.getUserType());
        existingUser.setUserType(newUserType);

        EmployeeDetailsDto employeeDetailsDto = updateUserDto.getEmployeeDetails();

        existingEmployee.setFirstname(employeeDetailsDto.getFirstname());
        existingEmployee.setLastname(employeeDetailsDto.getLastname());
        existingEmployee.setMobile(employeeDetailsDto.getMobile());
        userRepository.save(existingUser);
    }

    public List<UserListViewDto> getUsersList() {
        return userRepository.getUsersList();
    }

    public Optional<UserListViewDto> getUserViewById(Long userId) {
        return userRepository.findUserViewById(userId);
    }
}