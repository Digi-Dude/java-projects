package entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private Key id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
}
