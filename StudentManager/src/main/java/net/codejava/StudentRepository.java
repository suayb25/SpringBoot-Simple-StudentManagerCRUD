package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
//public Student findByNameAndPassword(String name,String password);
}
