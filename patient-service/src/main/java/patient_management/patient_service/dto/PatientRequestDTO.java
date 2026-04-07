package patient_management.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(String registeredDate) {
    this.registeredDate = registeredDate;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @NotBlank(message="Patient Name is required")
  @Size(max=100, message="name should not be more than 100 characters")
  private String name;

  @NotNull(message="email is required")
  @Email(message="email should be valid")
  private String email;

  @NotBlank(message="address is required")
  private String address;

  @NotBlank(message="register date is required")
  private String registeredDate;

  @NotBlank(message="date of birth is required")
  private String dateOfBirth;
}
