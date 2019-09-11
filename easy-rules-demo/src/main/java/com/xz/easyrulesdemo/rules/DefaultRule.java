package com.xz.easyrulesdemo.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认规则：不做任何处理
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:01:59
 */
@Slf4j
@Rule
public class DefaultRule {
    @Condition
    public boolean isDefault(@Fact("number") Integer number) {
        return true;
    }

    @Action
    public void printDefault() {
        log.info("buzz\n");
    }
}
