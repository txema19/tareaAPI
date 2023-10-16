package cesur.edu.tareaAPI_fullstack.model;

import com.example.tareaAPIfullStack.validators.ValidEmployeeCode;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Positive
	@NotNull
	private Integer id;
	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@ValidEmployeeCode
	private String employeeCode;

	public Employee(@Positive @NotNull Integer id, @NotBlank String name, @Email String email, String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeCode = employeeCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	

}
