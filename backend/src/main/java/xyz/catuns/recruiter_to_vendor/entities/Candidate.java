package xyz.catuns.recruiter_to_vendor.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String jobTitle;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    private PayRange payRange;

    @Enumerated(value = EnumType.STRING)
    private EmploymentType employmentType;

    @Enumerated(value = EnumType.STRING)
    private VisaStatus visaStatus;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private final List<Skill> skills = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PayRange getPayRange() {
        return payRange;
    }

    public void setPayRange(PayRange payRange) {
        this.payRange = payRange;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public VisaStatus getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(VisaStatus visaStatus) {
        this.visaStatus = visaStatus;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", location=" + location +
                ", payRange=" + payRange +
                ", employmentType=" + employmentType +
                ", visaStatus=" + visaStatus +
                ", skills=" + skills +
                '}';
    }
}
