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
public class PurchaseRuler {
    @Condition
    public boolean isCondition(@Fact("product") Product product) {
    	return ReceiptEnum.PURCHASE == product.getReceipt();
    }

    @Action
    public void action(@Fact("product") Product product) {
        log.info("编号：{} 名称：{} 进入暂存货位", product.getNumer(), product.getName());
    }
}
