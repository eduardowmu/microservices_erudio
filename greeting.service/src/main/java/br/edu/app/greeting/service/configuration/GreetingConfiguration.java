package br.edu.app.greeting.service.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@Getter
@Setter
@Component
@RefreshScope//Essa notação nos permite fazer alteração nas propriedades sem precisar interromper a execução
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}