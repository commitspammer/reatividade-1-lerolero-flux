package com.lerolero.nouns.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import com.lerolero.nouns.repositories.NounRepository;

@Service
public class NounService {

	private NounRepository repo = new NounRepository();

	private Mono<String> next() {
		return repo.pullRandom();
	}

	public Mono<String> randomNoun() {
		return next()
			.subscribeOn(Schedulers.boundedElastic());
	}

	public Flux<String> randomNounList(Integer size) {
		return Flux.range(1, size)
			.flatMap(i -> next())
			.subscribeOn(Schedulers.boundedElastic());
	}

	public Flux<String> randomNounProducer(Integer interval) {
		return Flux.interval(Duration.ofMillis(interval))
			.flatMap(i -> next())
			.subscribeOn(Schedulers.boundedElastic());
	}

}
