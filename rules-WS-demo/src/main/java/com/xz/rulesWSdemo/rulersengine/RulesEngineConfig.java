package com.xz.rulesWSdemo.rulersengine;

import java.util.List;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.xz.rulesWSdemo.util.PackageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RulesEngineConfig {
	/**
	 * 单条规则过滤
	 * @return
	 */
	@Bean
	public RulesEngine singleRulesEngine() {
		return new DefaultRulesEngine(new RulesEngineParameters().skipOnFirstAppliedRule(true));
	}

	/**
	 * 多条规则过滤
	 * @return
	 */
	@Bean
	public RulesEngine multiplyRulesEngine() {
		return new DefaultRulesEngine(new RulesEngineParameters().skipOnFirstNonTriggeredRule(true));
	}

	@Bean("rules")
	public Rules rules() {
        // create rules
		Rules rules = new Rules();
		try {
			List<Class<?>> classes = PackageUtil.getClassName("com.xz.rulesWSdemo.rulers");
			for (Class<?> c : classes) {
				rules.register(c.newInstance());
			}		
		} catch (Exception e) {
			log.info("规则加载错误， {}", e.getMessage());
		}
		return rules;
	}
}
