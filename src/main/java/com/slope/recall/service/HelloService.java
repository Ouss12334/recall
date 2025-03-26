package com.slope.recall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slope.recall.data.Hello;
import com.slope.recall.repository.HelloRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloService implements IHelloService {

    @Autowired
    private HelloRepository helloRepository;

    public Hello sayHello(String who) {
        var whois = Hello.builder().who(who).build();
        helloRepository.save(whois);
        log.info(whois.toString());
        return whois;
    }

    public List<Hello> findWhos(String likewho) {
        log.info("count* {}", helloRepository.count());
        // return helloRepository.findByWho(likewho);
        return helloRepository.findByWhoContainingIgnoreCase(likewho);
    }

}
