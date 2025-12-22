package com.deloitte.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false)
	private int durationInHours;

	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private Set<Student> students = new HashSet<>();

	protected Course() {
		// JPA
	}

	public Course(String title, int durationInHours) {
		this.title = title;
		this.durationInHours = durationInHours;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public Set<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", durationInHours=" + durationInHours + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Course))
			return false;
		Course other = (Course) o;
		return id != 0 && id == other.id;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
