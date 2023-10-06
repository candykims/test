package com.jytpay.bean;

/**
* <B>系统名称：</B><BR>
* <B>模块名称：</B><BR>
* <B>中文类名：</B><BR>
* <B>概要说明：</B><BR>
* @author WY
* @since 2018年11月6日下午3:22:32
*/

public class OP1001_TradeReq {
	
	private OP1001_HeaderReq head;
	
	private OP1001_BodyReq body;
	
	public OP1001_TradeReq(OP1001_HeaderReq head,OP1001_BodyReq body) {
		this.head = head;
		this.body = body;
	}

	public OP1001_HeaderReq getHead() {
		return head;
	}

	public void setHead(OP1001_HeaderReq head) {
		this.head = head;
	}

	public OP1001_BodyReq getBody() {
		return body;
	}

	public void setBody(OP1001_BodyReq body) {
		this.body = body;
	}
	
}
