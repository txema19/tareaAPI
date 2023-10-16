package cesur.edu.tareaAPI_fullstack.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cesur.edu.tareaAPI_fullstack.model.Employee;
import cesur.edu.tareaAPI_fullstack.services.EmployeeService;


@RestController
@RequestMapping("/empleados")
public class EmployeeRestController {

	EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<ArrayList<?>> listadoEmpleados() {
		ArrayList<Employee> empleados = employeeService.getAllEmployees();
		return ResponseEntity.ok(empleados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPersona(@PathVariable int id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}
		else {
			ArrayList<Employee> empleados = employeeService.getAllEmployees();
			for (Employee e : empleados) {
				if (e.getId() == id) {
					return ResponseEntity.ok(e);
				}
			}
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated Employee e) {
		employeeService.saveEmployee(e);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Employee> modifyEmployee(@RequestBody @Validated Employee e) {
		employeeService.modifyEmployee(e);
		return ResponseEntity.ok(e);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable @Validated int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
