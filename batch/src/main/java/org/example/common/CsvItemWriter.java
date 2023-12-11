package org.example.common;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class CsvItemWriter extends JdbcBatchItemWriter<Customer> {

    public CsvItemWriter(DataSource dataSource) {
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        setSql("INSERT INTO customer (name, age) VALUES (:name, :age)");
        setDataSource(dataSource);
    }
}

