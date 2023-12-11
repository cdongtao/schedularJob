package org.example.common;

import org.springframework.batch.item.ItemProcessor;

public class CsvItemProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) throws Exception {
        // You can perform any processing/transformation on the Customer object here
        return item;
    }
}
