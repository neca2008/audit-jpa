package com.jpa.audit.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AuditedAtCreation {
  @CreatedDate
  private ZonedDateTime createdAt;
}
