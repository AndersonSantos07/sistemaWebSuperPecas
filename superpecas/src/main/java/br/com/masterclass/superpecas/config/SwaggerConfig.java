package br.com.masterclass.superpecas.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springSuperPecasOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto SuperPecas")
                        .description("Projeto SuperPecas da Master Class - Starter")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Master Class - Starter")
                                .url(""))
                        .contact(new Contact()
                                .name("Anderson Santos")
                                .url("https://github.com/AndersonSantos07")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/AndersonSantos07/sistemaWebSuperPecas"));
    }

    @Bean
    OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser(){
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
                    .forEach(operation -> {
                        ApiResponses apiResponses = operation.getResponses();

                        apiResponses.addApiResponse("200",createApiResponse("Sucesso!"));
                        apiResponses.addApiResponse("201",createApiResponse("Objeto Persistido!"));
                        apiResponses.addApiResponse("204",createApiResponse("Objeto Excluído!"));
                        apiResponses.addApiResponse("400",createApiResponse("Erro na Requisição!"));
                        apiResponses.addApiResponse("404",createApiResponse("Objeto Não Encontrado!"));
                        apiResponses.addApiResponse("500",createApiResponse("Erro na Aplicação!"));
                    }));

        };
    }

    private ApiResponse createApiResponse(String message) {

        return new ApiResponse().description(message);
    }
}
