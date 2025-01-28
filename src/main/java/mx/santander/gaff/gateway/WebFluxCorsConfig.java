package mx.santander.gaff.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration

public class WebFluxCorsConfig  {

	   @Bean
	    CorsWebFilter corsWebFilter() {
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(false);
	        config.addAllowedOrigin("*"); // Change "*" to specific origins for security
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*"); // Allow specific methods like GET, POST, etc.
	       
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", config);
	       
	        return new CorsWebFilter(source);
	    }
}