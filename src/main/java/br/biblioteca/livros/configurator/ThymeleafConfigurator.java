package br.biblioteca.livros.configurator;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 5/19/19 7:35 PM
 */

@Configuration
public class ThymeleafConfigurator {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
