package com.xz.rulesWSdemo;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xz.rulesWSdemo.constant.ReceiptEnum;
import com.xz.rulesWSdemo.mode.Product;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class demo implements CommandLineRunner {
	@Autowired
	private RulesEngine singleRulesEngine;
//	@Autowired
//	private RulesEngine multiplyRulesEngine;

	@Autowired
	private Rules rules;

	@Override
	public void run(String... args) throws Exception {
		log.info("货物入库 ...");
        // fire rules
        Facts facts = new Facts();
        Product stock = new Product("WH00011", ReceiptEnum.PURCHASE, "浏阳河酒");
        facts.put("product", stock);
        singleRulesEngine.fire(rules, facts);
        
        Product stock2 = new Product("WH00012", ReceiptEnum.RETURN, "茅台酒");
        facts.put("product", stock2);
        singleRulesEngine.fire(rules, facts);
        
        //多条数据批量处理
        // for循环处理数据
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("WH00011", ReceiptEnum.STOCK, "浏阳河酒"));
//        products.add(new Product("WH00012", ReceiptEnum.RETURN, "茅台酒"));
//        products.add(new Product("WH00013", ReceiptEnum.RETURN, "茅台酒"));
//        for (Product p: products) {
//            facts.put("product", p);
//            singleRulesEngine.fire(rules, facts);
//        }
	}
}
