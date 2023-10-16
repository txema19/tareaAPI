package cesur.edu.tareaAPI_fullstack.services;

import java.util.ArrayList;
import java.util.Arrays;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cesur.edu.tareaAPI_fullstack.model.Employee;

//import lombok.extern.slf4j.Slf4j;

@Primary
@Service
public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> listaEmpleados = new ArrayList<>(Arrays.asList(
            new Employee(1, "Juan", "juan@email.com", "EMP-XYZ-1234"),
            new Employee(2, "Ana", "ana@email.com", "EMP-ABC-5678"),
            new Employee(3, "Carlos", "carlos@email.com", "EMP-DEF-9876"),
            new Employee(4, "Laura", "laura@email.com", "EMP-GHI-4567"),
            new Employee(5, "Pedro", "pedro@email.com", "EMP-JKL-7890")
        ));
	
	public EmployeeServiceImpl() {
		//log.info("Creado bean PersonaServiceImpl");
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		return listaEmpleados;
	}
	
	@Override
	public Employee saveEmployee(Employee e) {
		this.listaEmpleados.add(e);
		return e;
	}

	@Override
	public Employee modifyEmployee(Employee e) {
		for (Employee employee : listaEmpleados) {
			if (employee.getId() == e.getId()) {
				employee.setName(e.getName()); 
				employee.setEmail(e.getEmail());
				return e;
			}
		}
		return null; 
	}

	@Override
	public void deleteEmployee(int id) {
		for (Employee emp : new ArrayList<>(listaEmpleados)) {
			if (emp.getId() == id) {
				listaEmpleados.remove(emp);
			}
		}
	}



}
