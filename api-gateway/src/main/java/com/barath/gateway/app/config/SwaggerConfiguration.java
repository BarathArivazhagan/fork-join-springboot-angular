package com.barath.gateway.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Primary
public class SwaggerConfiguration implements SwaggerResourcesProvider {

    private static final String SWAGGER_API_DOCS = "/v2/api-docs";
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ZuulProperties zuulProperties;

    public SwaggerConfiguration(ZuulProperties zuulProperties) {
        this.zuulProperties = zuulProperties;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public List<SwaggerResource> get() {

        List<SwaggerResource> swaggerResources = new ArrayList<>();
        if(logger.isInfoEnabled()){
           logger.info("zuul properties {}",zuulProperties);
        }
        zuulProperties.getRoutes().entrySet().stream()
                .forEach( entry ->{
                    if(logger.isInfoEnabled()) {
                        logger.info("zuul route key {}",entry.getKey());
                    }
                    SwaggerResource resource = new SwaggerResource();
                    resource.setName(entry.getKey());
                    resource.setSwaggerVersion("1.0");
                    resource.setUrl("/".concat(entry.getValue().getPath().split("/")[1]).concat(SWAGGER_API_DOCS));
                    swaggerResources.add(resource);
                });

        return swaggerResources;
    }
}
