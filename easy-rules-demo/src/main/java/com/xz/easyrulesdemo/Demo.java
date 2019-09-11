package com.xz.easyrulesdemo;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * easy-rules实例
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:06:36
 */
@Slf4j
@Component
public class Demo implements CommandLineRunner {

	@Autowired
	private RulesEngineParameters singleRulesEngine;
	@Autowired
	private RulesEngineParameters multiplyRulesEngine;

	@Autowired
	private Rules rules;
	/**
	 * 具体执行的业务逻辑
	 */
	@Override
	public void run(String... args) throws Exception {
	    // create a rules engine
//        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(multiplyRulesEngine);

        // create rules
//        Rules rules = new Rules();
//        rules.register(new FizzRule());
//        rules.register(new BuzzRule());
//        rules.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
//        rules.register(new NonFizzBuzzRule());
//        rules.register(new DefaultRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            log.info("");
        }
	}
}
