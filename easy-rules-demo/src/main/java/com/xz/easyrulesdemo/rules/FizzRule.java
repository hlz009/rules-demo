package com.xz.easyrulesdemo.rules;


import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import lombok.extern.slf4j.Slf4j;

/**
 * 规则：是否被5整除
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:03:59
 */
@Slf4j
@Rule(priority = 1) /** 规则设定优先级 */
public class FizzRule {
    @Condition
    public boolean isFizz(@Fact("number") Integer number) {
        return number % 5 == 0;
    }

    @Action
    public void printFizz() {
        log.info("fizz\n");
    }
}
