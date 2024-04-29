package vn.edu.hust.ehustclassregistrationjavabackend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Column(name = "createdBy")
    @JsonIgnore
    String createdById;

    @JoinColumn(name = "createdBy", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    User createdBy;

    @Column(name = "updatedBy")
    @JsonIgnore
    String updatedById;

    @JoinColumn(name = "updatedBy", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    User updatedBy;

    @CreationTimestamp
    @Column(name = "createdTime", updatable = false)
    @JsonIgnore
    Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updatedTime")
    @JsonIgnore
    Timestamp updatedTime;

    public void update(String userId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (createdTime == null) {
            createdTime = now;
        }
        if (createdById == null) {
            createdById = userId;
        }
        updatedTime = now;
        updatedById = userId;
    }
}
