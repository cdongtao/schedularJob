package org.example.clean;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchCleanConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    CleanupTasklet cleanupTasklet;

    @Bean
    public Step cleanupStep() {
        return stepBuilderFactory.get("cleanupStep")
                .tasklet(cleanupTasklet)
                .build();
    }

    @Bean
    public Job cleanupJob(Step cleanupStep) {
        return jobBuilderFactory.get("cleanupJob")
                .incrementer(new RunIdIncrementer())
                .start(cleanupStep)
                .build();
    }
}
