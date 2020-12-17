package buckets.framework.base.swagger2.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author buckets
 * @date 2020/11/27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name:Buckets}")
    private String applicationName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(String.format("%s API Doc",applicationName))
                .description(String.format("This is a restful api document of %s.",applicationName))
                .version("1.0.0")
//                        .contact(new Contact("Buckets","blog.csdn.net","buckets@gmail.com"))
//                        .license("The Buckets License")
//                        .licenseUrl("http://www.Buckets.com")
                .build();
    }
}
