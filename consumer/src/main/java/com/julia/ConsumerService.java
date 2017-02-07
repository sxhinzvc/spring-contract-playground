package com.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ConsumerService {

	private final RestTemplate restTemplate;
	private int port = 6565;

	@Autowired
	public ConsumerService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public ProducerResponse callProducer() {
		ResponseEntity<ProducerResponse> response =
				restTemplate.getForEntity(URI.create("http://localhost:" + port + "/"), ProducerResponse.class);

		return response.getBody();
	}
}