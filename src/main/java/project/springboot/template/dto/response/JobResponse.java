package project.springboot.template.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class JobResponse {
    private Long id;
    private String department;
    private String title;
    private BigDecimal salaryRangeFrom = BigDecimal.ZERO;
    private BigDecimal salaryRangeTo = BigDecimal.ZERO;
    private List<String> keywords = new ArrayList<>();
    private Instant endDate;
    private String position;
}