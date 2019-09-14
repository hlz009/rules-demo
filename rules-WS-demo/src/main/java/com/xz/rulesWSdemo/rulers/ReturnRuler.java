package com.xz.rulesWSdemo.rulers;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.xz.rulesWSdemo.constant.ReceiptEnum;
import com.xz.rulesWSdemo.mode.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Rule()
public class ReturnRuler {
    @Condition
    public boolean isCondition(@Fact("product") Product product) {
    	return ReceiptEnum.RETURN == product.getReceipt();
    }

    @Action
    public void action(@Fact("product") Product product) {
        log.info("编号：{} 名称：{} 进入退货集货位", product.getNumer(), product.getName());
    }
}
