package org.example.test;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PersonMultiReader{

    @Bean
    @StepScope
    public MultiResourceItemReader<Person> multiResourceItemReader()   {

        // 使用FlatFileItemReader去读cvs文件，一行即一条数据
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        // 设置文件处在路径
        reader.setResource(new FileSystemResource(FileConstants.PERSONPATH));
        // 设置编码格式
        reader.setEncoding(FileConstants.UTF_8);
        // entity与csv数据做映射
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                // FileSeparatorConstant.SEPARATOR_COMMA 设置文件的字段分隔符
                setLineTokenizer(new DelimitedLineTokenizer(FileConstants.SEPARATOR_COMMA) {
                    {
                        setNames(new String[]{"id", "name", "age", "gender"});
//                        setNames(POJOConvertUtils.pojoToStrings(Person.class));
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
                    {
                        setTargetType(Person.class);
                    }
                });
            }
        });

        MultiResourceItemReader itemReader = new MultiResourceItemReader();
        itemReader.setDelegate(reader);
        // 多路径下多文件
        FileSystemResource[] fileSystemResource = new FileSystemResource[]{
                new FileSystemResource("D:\\tmp\\newFile\\person1.csv"),
                new FileSystemResource("D:\\tmp\\person.csv")
        };
        // 相同路径下 文件同类型文件
/*        FileSystemResource[] fileSystemResource = new FileSystemResource[]{
                new FileSystemResource("D:\\tmp\\newFile\\person-20211113-*.csv")
        };*/

        itemReader.setResources(fileSystemResource);
        return itemReader;
    }
}
