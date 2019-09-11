package com.xz.easyrulesdemo.rules;

import org.jeasy.rules.support.UnitRuleGroup;

/**
 * 合并规则
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:02:26
 */
public class FizzBuzzRule extends UnitRuleGroup {
	
    public FizzBuzzRule(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
