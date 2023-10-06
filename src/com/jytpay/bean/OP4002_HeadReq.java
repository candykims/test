package com.jytpay.bean;

public class OP4002_HeadReq {

	/**标识本报文格式版本号。当前版本为：2.0.0*/
    private String version;
    /**报文类型包括:请求报文：01;响应报文：02。此处为01*/
    private String tranType;
    /**商户编号，由平台统一分配*/
    private String merchantId;
    /**客户端或服务端时间，格式：YYYYMMDDHHMMSS*/
    private String tranTime;
    /**交易流水号，唯一标识一笔交易，必须以商户号开头。格式建议为：商户号（12位）+ YYYYMMDDHHMMSS（14）+6位流水号*/
    private String tranFlowid;
    /**交易代码。此处为OP1001*/
    private String tranCode;
    /**返回码：处理成功：S0000000；错误：返回具体的响应码。*/
    private String respCode;
    /**中文描述*/
    private String respDesc;
    
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getTranFlowid() {
		return tranFlowid;
	}
	public void setTranFlowid(String tranFlowid) {
		this.tranFlowid = tranFlowid;
	}
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDesc() {
		return respDesc;
	}
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}
}
