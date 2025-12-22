package com.deloitte.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(length = 15)
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	// Owning side
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	protected Student() {
	}

	public Student(String name, String email, String phone, Gender gender) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Gender getGender() {
		return gender;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
		course.getStudents().add(this);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student other = (Student) o;
		return id != 0 && id == other.id;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
