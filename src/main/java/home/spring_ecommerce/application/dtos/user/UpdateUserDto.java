package home.spring_ecommerce.application.dtos.user;

public class UpdateUserDto {
    private String username;
    private String password;
    private Long userType;
    private EmployeeDetailsDto employeeDetails;

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

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public EmployeeDetailsDto getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsDto employeeDetails) {
        this.employeeDetails = employeeDetails;
    }
}
