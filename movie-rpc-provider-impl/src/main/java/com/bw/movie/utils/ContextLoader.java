package com.bw.movie.utils;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration("movieConfig")
@EnableTransactionManagement
@ComponentScan("com.bw")
@ImportResource("classpath:/spring/*.xml")
@PropertySource("classpath:/properties/log4j.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextLoader {
}
