package com.jpa.audit;

import com.jpa.audit.audit.Audited;
import com.jpa.audit.configuration.PersistenceConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import({PersistenceConfiguration.class})
class AuditedTest {

  @PersistenceContext
  private EntityManager entityManager;

  private AuditedEntity auditedEntity;

  @Entity
  static class AuditedEntity extends Audited {
    @Id
    @GeneratedValue
    private long id;
  }

  @BeforeEach
  void persistNewEntity() {
    auditedEntity = new AuditedEntity();
    entityManager.persist(auditedEntity);
  }

  @Test
  void updatedAtIsNotNull() {
    assertThat(auditedEntity.getUpdatedAt())
      .isNotNull();
  }

  @Test
  void createdAtIsNotNull() {
    assertThat(auditedEntity.getCreatedAt())
      .isNotNull();
  }
}
