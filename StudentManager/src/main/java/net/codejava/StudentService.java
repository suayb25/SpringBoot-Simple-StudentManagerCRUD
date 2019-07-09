package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll(){
		
		return repo.findAll();
	}
	public void save(Student student) {
		repo.save(student);		
	}
	
	public Student get(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
/*	public Student findByNameAndPassword(String name,String password) {
		return repo.findByNameAndPassword(name, password);
	}*/
}
