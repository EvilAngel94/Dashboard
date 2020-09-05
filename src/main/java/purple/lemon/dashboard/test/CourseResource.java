package purple.lemon.dashboard.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class CourseResource {

    private final CoursesHardcodedService courseManagementService;

    public CourseResource(CoursesHardcodedService courseManagementService) {
        this.courseManagementService = courseManagementService;
    }

    @GetMapping("/api/{username}/courses")
    public List<CoursesHardcodedService.Course> getAllCourses(@PathVariable String username) {
        return courseManagementService.findAll();
    }
}
