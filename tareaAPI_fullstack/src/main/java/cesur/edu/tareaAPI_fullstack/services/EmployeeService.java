package cesur.edu.tareaAPI_fullstack.services;

import java.util.ArrayList;

import cesur.edu.tareaAPI_fullstack.model.Employee;


public interface EmployeeService {

	public ArrayList<Employee> getAllEmployees();

	public Employee saveEmployee(Employee empleado);
	
	public Employee modifyEmployee(Employee p);

	public void deleteEmployee(int id);



}
