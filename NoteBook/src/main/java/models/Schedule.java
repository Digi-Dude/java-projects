package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements Comparable<Schedule> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private int time;

    @Column(name = "affair")
    private String affair;

    public String toString() {
        return affair + " " + date.format(DateTimeFormatter.BASIC_ISO_DATE);
    }


    @Override
    public int compareTo(Schedule o) {
        if (this.getDate().equals(o.getDate())) {
            return Integer.compare(this.getTime(), o.getTime());
        }
        else return this.getDate().compareTo(o.getDate());
    }
}
