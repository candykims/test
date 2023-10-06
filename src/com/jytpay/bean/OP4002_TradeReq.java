package com.jytpay.bean;

public class OP4002_TradeReq {

	private OP4002_HeadReq head;
	
	private OP4002_BodyReq body;

	public OP4002_TradeReq() {
		super();
	}

	public OP4002_TradeReq(OP4002_HeadReq head, OP4002_BodyReq body) {
		super();
		this.head = head;
		this.body = body;
	}

	public OP4002_HeadReq getHead() {
		return head;
	}

	public void setHead(OP4002_HeadReq head) {
		this.head = head;
	}

	public OP4002_BodyReq getBody() {
		return body;
	}

	public void setBody(OP4002_BodyReq body) {
		this.body = body;
	}
}
