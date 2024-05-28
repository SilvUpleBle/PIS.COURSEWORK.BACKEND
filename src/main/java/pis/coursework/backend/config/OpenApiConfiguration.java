package pis.coursework.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html#/
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI postMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API курсовой работы")
                        .description("Методы и их описание")
                        .version("1.0"));
    }
}
