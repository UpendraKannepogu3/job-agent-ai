package com.jobagent.job_agent_backend.entity;

import com.jobagent.job_agent_backend.enums.JobType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job_listings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", unique = true)
    private String externalId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType;

    @Column(name = "salary_min")
    private Integer salaryMin;

    @Column(name = "salary_max")
    private Integer salaryMax;

    @Column(name = "apply_url")
    private String applyUrl;

    @Column(name = "source_board")
    private String sourceBoard;

    @Column(name = "is_remote")
    private boolean remote;

    @ElementCollection
    @CollectionTable(name = "job_required_skills",
            joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> requiredSkills;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;

    @CreationTimestamp
    @Column(name = "fetched_at")
    private LocalDateTime fetchedAt;
}