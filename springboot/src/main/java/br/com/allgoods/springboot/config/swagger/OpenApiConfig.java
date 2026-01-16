package br.com.allgoods.springboot.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API All Goods")
                .version("0.1.7")
                .description("Esta é a documentação da API Foods All Goods.")
                .termsOfService("https://github.com/Rodrigo-Kelven/Api-Spring-Boot")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .name("Suporte API")
                    .url("https://github.com/Rodrigo-Kelven/Api-Spring-Boot")
                    .email("https://github.com/Rodrigo-Kelven/Api-Spring-Boot"))
            );
    }

    // Bean para impedir que os endpoints de actuador sejam exibidos no swagger!
    /*
    @Bean
    public GroupedOpenApi actuatorApi() {
        // Configura para não exibir os endpoints do actuator na documentação
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToExclude("/actuator/**") // Exclui os endpoints do actuator
                .build();
    }
    */
}