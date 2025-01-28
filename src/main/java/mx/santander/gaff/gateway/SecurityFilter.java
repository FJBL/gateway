package mx.santander.gaff.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
//@Configuration
public class SecurityFilter implements GatewayFilter {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String authorizationHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		log.info("-----------------------");
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unauthorized");
		}
		return chain.filter(exchange);
	}
}
