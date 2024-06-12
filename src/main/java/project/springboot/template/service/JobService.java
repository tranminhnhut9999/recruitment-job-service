package project.springboot.template.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.springboot.template.dto.request.CreateJobRequest;
import project.springboot.template.dto.response.JobDetailResponse;
import project.springboot.template.dto.response.JobResponse;
import project.springboot.template.entity.Job;
import project.springboot.template.entity.common.ApiException;
import project.springboot.template.repository.JobRepository;
import project.springboot.template.util.ObjectUtil;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobDetailResponse createJob(CreateJobRequest createJobRequest) {
        Job.JobBuilder jobBuilder = Job.builder().department(createJobRequest.getDepartment())
                .endDate(createJobRequest.getEndDate())
                .description(createJobRequest.getDescription())
                .title(createJobRequest.getTitle())
                .position(createJobRequest.getPosition())
                .targetNumber(createJobRequest.getTargetNumber())
                .salaryRangeTo(createJobRequest.getSalaryRangeTo())
                .salaryRangeFrom(createJobRequest.getSalaryRangeFrom())
                .status(createJobRequest.isStatus())
                .requiredExperience(createJobRequest.getRequiredExperience());

        if (!createJobRequest.getKeywords().isEmpty()) {
            String keyworkAsString = String.join("-", createJobRequest.getKeywords());
            jobBuilder.keywords(keyworkAsString);
        }
        Job job = jobBuilder.build();
        Job savedJob = jobRepository.save(job);
        return ObjectUtil.copyProperties(savedJob, new JobDetailResponse(), JobDetailResponse.class, true);
    }

    public List<JobResponse> getHiringJob() {
        List<Job> hiringJobs = jobRepository.findAllByStatusIs(true);
        List<JobResponse> jobResponses = hiringJobs.stream()
                .map(job -> {
                    JobResponse jobResponse = ObjectUtil.copyProperties(job, new JobResponse(), JobResponse.class, true);
                    jobResponse.setKeywords(this.extractKeyword(job.getKeywords()));
                    return jobResponse;
                }).collect(Collectors.toList());

        return jobResponses;
    }

    public List<JobResponse> getAllJob() {
        List<Job> hiringJobs = jobRepository.findAll();
        List<JobResponse> jobResponses = hiringJobs.stream()
                .map(job -> {
                    JobResponse jobResponse = ObjectUtil.copyProperties(job, new JobResponse(), JobResponse.class, true);
                    jobResponse.setKeywords(this.extractKeyword(job.getKeywords()));
                    return jobResponse;
                }).collect(Collectors.toList());

        return jobResponses;
    }

    public JobDetailResponse getHiringDetailJob(Long id) {
        Job hiringJob = jobRepository.findJobByIdAndStatus(id, true)
                .orElseThrow(() -> ApiException.create(HttpStatus.BAD_REQUEST).withMessage("Không tìm thấy job:" + id));
        JobDetailResponse jobResponse = ObjectUtil.copyProperties(hiringJob, new JobDetailResponse(), JobDetailResponse.class, true);
        jobResponse.setKeywords(this.extractKeyword(hiringJob.getKeywords()));
        return jobResponse;
    }

    public JobDetailResponse getDetailJob(Long id) {
        Job hiringJob = jobRepository.findById(id)
                .orElseThrow(() -> ApiException.create(HttpStatus.BAD_REQUEST).withMessage("Không tìm thấy job:" + id));
        JobDetailResponse jobResponse = ObjectUtil.copyProperties(hiringJob, new JobDetailResponse(), JobDetailResponse.class, true);
        jobResponse.setKeywords(this.extractKeyword(hiringJob.getKeywords()));
        return jobResponse;
    }


    private List<String> extractKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(keyword.split("-"));
    }
}
