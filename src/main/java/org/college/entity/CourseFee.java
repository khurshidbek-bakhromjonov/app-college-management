package org.college.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course_fees")
public class CourseFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @PositiveOrZero(message = "Course fee must be a positive value or zero")
    @Column(name = "course_fee")
    private int courseFee;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "college_id")
    private College college;

    public CourseFee(int courseFee) {
        this.courseFee = courseFee;
    }
}
