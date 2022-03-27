package com.jpa.audit.audit;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

/**
 * Automatically set createdAt and updatedAt properties through Spring Data JPA AuditingEntityListener.
 */
@Getter
@MappedSuperclass
public abstract class Audited extends AuditedAtCreation {
    @LastModifiedDate
    private ZonedDateTime updatedAt;
}
