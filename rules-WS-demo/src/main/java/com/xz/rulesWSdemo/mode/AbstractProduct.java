package com.xz.rulesWSdemo.mode;

import java.io.Serializable;

import lombok.Data;

@Data
public class AbstractProduct implements Receiptable, Serializable {
	private static final long serialVersionUID = -2706004455006834586L;
	// 增加其他属性识别  比如 批次
}
