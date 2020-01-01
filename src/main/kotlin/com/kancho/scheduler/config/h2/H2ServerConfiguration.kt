package com.kancho.scheduler.config.h2

import org.h2.tools.Server
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class H2ServerConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun h2TcpServer(): DataSource {
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
        return com.zaxxer.hikari.HikariDataSource();
    }
}