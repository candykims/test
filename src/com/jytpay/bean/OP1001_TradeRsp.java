package com.jytpay.bean;

/**
* <B>系统名称：</B><BR>
* <B>模块名称：</B><BR>
* <B>中文类名：</B><BR>
* <B>概要说明：</B><BR>
* @author WY
* @since 2018年11月6日下午3:22:32
*/

public class OP1001_TradeRsp {
	
	private OP1001_HeaderRsp head;
	
	private OP1001_BodyRsp body;
	
	public OP1001_TradeRsp(OP1001_HeaderRsp head,OP1001_BodyRsp body) {
		this.head = head;
		this.body = body;
	}

	public OP1001_TradeRsp() {
		
	}
	public OP1001_HeaderRsp getHead() {
		return head;
	}

	public void setHead(OP1001_HeaderRsp head) {
		this.head = head;
	}

	public OP1001_BodyRsp getBody() {
		return body;
	}

	public void setBody(OP1001_BodyRsp body) {
		this.body = body;
	}

}
