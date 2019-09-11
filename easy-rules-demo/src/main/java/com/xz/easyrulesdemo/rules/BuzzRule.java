package com.xz.easyrulesdemo.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import lombok.extern.slf4j.Slf4j;

/**
 * 规则：是否被7整除
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:01:14
 */
@Slf4j
@Rule(priority = 2)
public class BuzzRule {
    @Condition
    public boolean isBuzz(@Fact("number") Integer number) {
        return number % 7 == 0;
    }

    @Action
    public void printBuzz() {
        log.info("buzz\n");
    }
}
