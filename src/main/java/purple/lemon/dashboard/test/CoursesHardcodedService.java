package purple.lemon.dashboard.test;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesHardcodedService {

    private final static List<Course> courses = new ArrayList<>();
    private static long idCounter = 0;

    static {
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and Angular"));
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and React"));
        courses.add(new Course(++idCounter, "in28minutes", "Master Microservices with Spring Boot and Spring Cloud"));
        courses.add(new Course(++idCounter, "in28minutes",
                "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
    }

    public List<Course> findAll() {
        return courses;
    }

    public static class Course {
        private final long id;
        private final String username;
        private final String description;

        public Course(long id, String username, String description) {
            this.id = id;
            this.username = username;
            this.description = description;
        }

        public String getUsername() {
            return username;
        }

        public String getDescription() {
            return description;
        }

        public long getId() {
            return id;
        }
    }
}


