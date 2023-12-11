package org.example.test;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class PersonProcessor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person item) throws Exception {
        System.out.println(item.toString());
        return item;
    }
}
