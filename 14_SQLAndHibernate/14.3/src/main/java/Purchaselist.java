import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class Purchaselist {
    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
