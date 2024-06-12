package project.springboot.template.entity.common;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {

    @Column(name = "created")
    @CreatedDate
    private Instant created;

    @Column(name = "last_modified")
    @LastModifiedDate
    private Instant lastModified;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;
}
