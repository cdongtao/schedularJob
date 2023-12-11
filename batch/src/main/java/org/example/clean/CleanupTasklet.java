package org.example.clean;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class CleanupTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // 执行清理逻辑，例如删除旧数据
        System.out.println("Executing cleanup task...");
        // 实际的清理逻辑在这里添加
        return RepeatStatus.FINISHED;
    }
}
