package com.jytpay.bean;

public class OP1003_BodyReq {

    private String oriMerOrderId; // 原商户订单号
    
    private String merRefundFlowId; // 商户退款流水号

    private String refundAmt; // 退款金额
    
    private String refundChannel; // 退款渠道
    
    private String merNotifyUrl; // 商户通知地址
    
    private String refundReason; // 退款原因

    private String splitRefundAmt; // 分账退款金额，即为退款至代理商金额

	public String getOriMerOrderId() {
		return oriMerOrderId;
	}

	public void setOriMerOrderId(String oriMerOrderId) {
		this.oriMerOrderId = oriMerOrderId;
	}

	public String getMerRefundFlowId() {
		return merRefundFlowId;
	}

	public void setMerRefundFlowId(String merRefundFlowId) {
		this.merRefundFlowId = merRefundFlowId;
	}

	public String getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(String refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	public String getMerNotifyUrl() {
		return merNotifyUrl;
	}

	public void setMerNotifyUrl(String merNotifyUrl) {
		this.merNotifyUrl = merNotifyUrl;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getSplitRefundAmt() {
		return splitRefundAmt;
	}

	public void setSplitRefundAmt(String splitRefundAmt) {
		this.splitRefundAmt = splitRefundAmt;
	}
	
    
    
}
