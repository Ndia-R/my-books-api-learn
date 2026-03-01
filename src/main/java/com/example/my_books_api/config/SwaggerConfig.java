package com.example.my_books_api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme bearerScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT");

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
            .info(
                new Info()
                    .title("My Books API")
                    .description(
                        "書籍管理API - このAPIドキュメントはMy Books管理システムのAPIエンドポイントを説明します。\n\n" +
                            "## 認証方法（Bearer トークン）\n" +
                            "1. 別途アクセストークンを取得する（例: Keycloakのトークンエンドポイントから取得）\n" +
                            "2. 「Authorize」ボタンをクリックする\n" +
                            "3. 「Value」欄にアクセストークンを貼り付けて「Authorize」をクリックする\n" +
                            "4. 以降のAPIリクエストに `Authorization: Bearer <token>` が自動的に付与される"
                    )
                    .version("1.0.0")
            )
            .components(
                new Components()
                    .addSecuritySchemes("bearerAuth", bearerScheme)
            )
            .addSecurityItem(securityRequirement);
    }
}
