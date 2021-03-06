package com.hanlinbode.hlbd.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"id", "teacher", "students", "teacherHomeworkList"})
@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String teamIntroduction;

    private int teamVolume;
    private String teacherId;
    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "team_student",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "teamId")},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")})
    private List<Student> students;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "team_homework",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "teamId")},
            inverseJoinColumns = {@JoinColumn(name = "homework_id", referencedColumnName = "homeworkId")})
    private List<TeacherHomework> teacherHomeworkList;

    public Team() {
    }

    @JsonBackReference(value = "2")
    public List<TeacherHomework> getTeacherHomeworkList() {
        return teacherHomeworkList;
    }
    @JsonBackReference(value = "2")
    public void setTeacherHomeworkList(List<TeacherHomework> teacherHomeworkList) {
        this.teacherHomeworkList = teacherHomeworkList;
    }
    @JsonBackReference(value = "3")
    public List<Student> getStudents() {
        return students;
    }
    @JsonBackReference(value = "3")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamIntroduction() {
        return teamIntroduction;
    }

    public void setTeamIntroduction(String teamIntroduction) {
        this.teamIntroduction = teamIntroduction;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeamVolume() {
        return teamVolume;
    }

    public void setTeamVolume(int teamVolume) {
        this.teamVolume = teamVolume;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamIntroduction='" + teamIntroduction + '\'' +
                ", students=" + students +

                '}';
    }
}
