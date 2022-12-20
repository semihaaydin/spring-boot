package com.saydin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    //@Configuration etiketi ile spring ayağa kalkarken bu configürasyonu aktive eder.
    //http://localhost:8257/v2/api-docs : bu kısmı consoledan aldık.
    //http://localhost:8257/swagger-ui.html my port


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.saydin")) // hangi paketteki dokümentasyon yapılacaksa o yolu veririz
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());

    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot Swagger Örnegi")
                .description("Customer  Api Dokümantasyonu")
                .contact(new Contact("Test Semiha Swagger Entegration", "", "")) //company information
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html") //licence
                .version("1.12.3")
                .build();
    }
}
