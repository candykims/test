package com.jytpay.bean;

public class OP4002_BodyReq {

	// 商户AppId
    private String subAppId;

	// 支付授权目录
    private String jsapiPath;

    // 支付费率模式
    private String payRateMode;
    
    // 配置类型
    private String deployType;

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getJsapiPath() {
		return jsapiPath;
	}

	public void setJsapiPath(String jsapiPath) {
		this.jsapiPath = jsapiPath;
	}

	public String getPayRateMode() {
		return payRateMode;
	}

	public void setPayRateMode(String payRateMode) {
		this.payRateMode = payRateMode;
	}

	public String getDeployType() {
		return deployType;
	}

	public void setDeployType(String deployType) {
		this.deployType = deployType;
	}
    
}
