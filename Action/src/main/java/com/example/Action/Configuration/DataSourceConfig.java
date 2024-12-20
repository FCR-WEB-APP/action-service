package com.example.Action.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean(name="datasource1")
    //@ConfigurationProperties(prefix = "spring.hikariConfig.db1")
    public HikariDataSource dataSource1(){
        HikariConfig hikariConfig=new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/fcr_case_dev");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new HikariDataSource(hikariConfig);
//        return  DataSourceBuilder.create()
//                .url("jdbc:mysql://10.0.2.15:3306/fcr_case_dev")
//                .username("root")
//                .password("root")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .build();

    }


    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create()
                .url("jdbc:oracle:thin:@192.168.1.240:1521:xe")
                .username("system")
                .password("sarasu10")
                .driverClassName("oracle.jdbc.driver.OracleDriver")
                .build();
    }
}
