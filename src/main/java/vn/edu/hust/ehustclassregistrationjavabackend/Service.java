package vn.edu.hust.ehustclassregistrationjavabackend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.edu.hust.ehustclassregistrationjavabackend.model.entity.Course;
import vn.edu.hust.ehustclassregistrationjavabackend.repository.CourseRepository;

@Component
@RequiredArgsConstructor

public class Service {
    final CourseRepository courseRepository;
    public void test() {
        Course course = courseRepository.findById(1L).orElseThrow();
        System.out.println(course.getPreCourse());
    }
}
