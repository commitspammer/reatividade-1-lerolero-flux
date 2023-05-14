package com.lerolero.nouns.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class NounService {

	private int increment = 0;

	private String next() {
		return "Hello " + increment++ + "!";
	}

	public Mono<String> randomNoun() {
		return Mono.just(next());
	}

	public Flux<String> randomNounList(Integer size) {
		return Flux.range(1, size)
			.map(i -> next())
			.subscribeOn(Schedulers.boundedElastic());
	}

	public Flux<String> randomNounProducer(Integer interval) {
		return Flux.interval(Duration.ofMillis(interval))
			.map(i -> next())
			.subscribeOn(Schedulers.parallel());
	}

}
