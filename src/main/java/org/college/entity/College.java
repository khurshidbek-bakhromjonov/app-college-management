package org.college.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "colleges")
@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "College name is required!")
    @Column(name = "college_name")
    private String collegeName;

    @NotBlank(message = "Course name is required!")
    @Column(name = "course_name")
    private String courseName;

    @NotBlank(message = "Course duration is required!")
    private String duration;

    @NotBlank(message = "Accommodation type is required!")
    private String type;

    @PositiveOrZero(message = "Accommodation fee must be a positive value or zero")
    @Column(name = "accommodation_fee")
    private int accommodationFee;

    @OneToOne(mappedBy = "college", cascade = CascadeType.ALL)
    private CourseFee courseFee;

    public void setCourseFee(CourseFee courseFee) {
        this.courseFee = courseFee;
        courseFee.setCollege(this);
    }
}
