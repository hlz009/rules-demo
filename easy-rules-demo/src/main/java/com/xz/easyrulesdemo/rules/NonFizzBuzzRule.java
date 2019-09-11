package com.xz.easyrulesdemo.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import lombok.extern.slf4j.Slf4j;

/**
 * 规则：不被5或者不被7整除的数
 * @author Huxiaozhi
 * @date 2019年9月11日 下午4:04:37
 */
@Slf4j
@Rule(priority = 3)
public class NonFizzBuzzRule {

    @Condition
    public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
        // can return true, because this is the latest rule to trigger according to
        // assigned priorities
        // and in which case, the number is not fizz nor buzz
        return number % 5 != 0 || number % 7 != 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        log.info(number+"\n");
    }
}
