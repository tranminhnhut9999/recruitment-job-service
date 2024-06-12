package project.springboot.template.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import project.springboot.template.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Entity
@Data
@Table(name = "_job")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String department;
    private String title;
    @Lob
    private String description;
    private Integer targetNumber = 0;
    private BigDecimal salaryRangeFrom = BigDecimal.ZERO;
    private BigDecimal salaryRangeTo = BigDecimal.ZERO;
    private String keywords = "";
    private Instant endDate;
    private String position;
    private boolean status = false;
    private Float requiredExperience = 0.0F;
}