package com.xz.easyrulesdemo.rulesengine;

import java.util.List;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.xz.easyrulesdemo.utils.PackageUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 引擎配置类
 * @author Huxiaozhi
 * @date 2019年9月11日 下午3:01:02
 */
@Slf4j
@Component
public class RulesEngineConfig {
	
	/**
	 * 单条规则过滤引擎
	 * @return
	 */
	@Bean
	public RulesEngineParameters singleRulesEngine() {
		return new RulesEngineParameters().skipOnFirstAppliedRule(true);
	}

	/**
	 * 多条规则过滤引擎
	 * @return
	 */
	@Bean
	public RulesEngineParameters multiplyRulesEngine() {
		return new RulesEngineParameters().skipOnFirstNonTriggeredRule(true);
	}

	@Bean("rules")
	public Rules rules() {
        // create rules
		Rules rules = new Rules();
		try {
			List<Class<?>> classes = PackageUtil.getClassName("com.xz.easyrulesdemo.rules");
			for (Class<?> c : classes) {
				rules.register(c.newInstance());
			}		
		} catch (Exception e) {
			log.info("规则加载错误， {}", e.getMessage());
		}

//		rules.register(new FizzRule());
//		rules.register(new BuzzRule());
//		rules.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
//		rules.register(new NonFizzBuzzRule());
//		rules.register(new DefaultRule());
		return rules;
	}
}
