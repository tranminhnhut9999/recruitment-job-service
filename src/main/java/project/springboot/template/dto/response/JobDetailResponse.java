package project.springboot.template.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class JobDetailResponse {
    private Long id;
    private String department;
    private String title;
    private String description;
    private Integer targetNumber = 0;
    private BigDecimal salaryRangeFrom = BigDecimal.ZERO;
    private BigDecimal salaryRangeTo = BigDecimal.ZERO;
    private List<String> keywords = new ArrayList<>();
    private Instant endDate;
    private String position;
    private boolean status = false;
    private Float requiredExperience = 0.0F;
}