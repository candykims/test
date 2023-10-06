package com.jytpay.bean;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class OP1003_BodyRsp {

	private String refundState;

	private String merRefundFlowId; // 商户退款流水号

	private BigDecimal refundAmt; // 退款金额
     
    private String refundChannel; // 退款渠道
    
    private String refundReason; // 退款原因
    
    private String refundTranFlow;//金运通订单号

	public String getRefundState() {
		return refundState;
	}

	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}

	public String getMerRefundFlowId() {
		return merRefundFlowId;
	}

	public void setMerRefundFlowId(String merRefundFlowId) {
		this.merRefundFlowId = merRefundFlowId;
	}

	public BigDecimal getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(BigDecimal refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundTranFlow() {
		return refundTranFlow;
	}

	public void setRefundTranFlow(String refundTranFlow) {
		this.refundTranFlow = refundTranFlow;
	}

	
}
