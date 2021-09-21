
package ru.unit.techno.arris.log.action.test.module.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.unit.techno.ariss.log.action.lib"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public SwaggerOperationParameterReader swaggerOperationParameterReader(TypeNameExtractor nameExtractor,
                                                                           TypeResolver resolver) {
        return new SwaggerOperationParameterReader(nameExtractor, resolver);
    }
}