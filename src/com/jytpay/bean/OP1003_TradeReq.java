package com.jytpay.bean;

public class OP1003_TradeReq {

	private OP1003_HeadReq head;
	
	private OP1003_BodyReq body;

	public OP1003_TradeReq() {
		super();
	}

	public OP1003_TradeReq(OP1003_HeadReq head, OP1003_BodyReq body) {
		super();
		this.head = head;
		this.body = body;
	}

	public OP1003_HeadReq getHead() {
		return head;
	}

	public void setHead(OP1003_HeadReq head) {
		this.head = head;
	}

	public OP1003_BodyReq getBody() {
		return body;
	}

	public void setBody(OP1003_BodyReq body) {
		this.body = body;
	}

}
