package com.xz.rulesWSdemo.mode;

import java.io.Serializable;

import com.xz.rulesWSdemo.constant.ReceiptEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Product extends AbstractProduct implements Serializable {
	private static final long serialVersionUID = -2706004455006834586L;

	/** 单据编号 */
	private String numer;

	/** 单据类型 */
	private ReceiptEnum receipt;
	private String name;
}
