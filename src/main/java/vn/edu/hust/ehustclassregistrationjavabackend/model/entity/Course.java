package vn.edu.hust.ehustclassregistrationjavabackend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.Where;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "course")
@Getter
public class Course extends BaseEntity {
    @Id
    Long id;
    String courseCode;
    String courseName;
    String courseNameE;
    String description;
    Integer credit;
    String creditInfo;
    String gdCreditInfo;
    Integer courseType;
    Integer theoryHour;
    Integer assignmentHour;
    Integer practiceHour;
    Integer selfStudyHour;
    Integer internHour;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Where(clause = "relation = 'PREREQUISITE'")
    @JsonIgnore
    List<CourseRelationship> preRequisiteCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Where(clause = "relation = 'PRECOURSE'")
    @JsonIgnore
    List<CourseRelationship> preCourse;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Where(clause = "relation = 'COREQUISITECOURSE'")
    @JsonIgnore
    List<CourseRelationship> coreQuisiteCourse;


    public Course[] getPreRequisiteCourses() {
        Course[] courses = new Course[preRequisiteCourses.size()];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = preRequisiteCourses.get(i).getCourseConstraint();
        }
        return courses;
    }
}
