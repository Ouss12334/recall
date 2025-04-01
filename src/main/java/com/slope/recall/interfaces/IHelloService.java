package com.slope.recall.interfaces;

import java.util.List;

import com.slope.recall.data.Hello;

public interface IHelloService {
    Hello sayHello(String who);
    List<Hello> findWhos(String likewho);
}
