package com.xz.rulesWSdemo.constant;

public enum ReceiptEnum {
	PURCHASE("purchase"),
	RETURN("return");
	
	private String type;
	private ReceiptEnum(String type) { 
        this.type = type; 
	} 
}
