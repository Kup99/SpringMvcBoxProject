package spring.example.config;

import org.springframework.context.annotation.Bean;
import spring.example.model.Type;

public class TypeValuesConfig {

    @Bean
    public Type[] getValues() {

        return Type.values();
    }
}


