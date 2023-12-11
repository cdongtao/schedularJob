package org.example.test;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class PersonTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // 在这里编写你的任务逻辑，例如，从数据库读取人员信息并执行相应的操作。
        System.out.println("PersonTasklet executed!");

        // 返回RepeatStatus.FINISHED表示任务执行完成
        return RepeatStatus.FINISHED;
    }
}
