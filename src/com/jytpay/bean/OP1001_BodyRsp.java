package com.jytpay.bean;

public class OP1001_BodyRsp {

    /**订单状态: 10已受理 ;11交易成功;12处理中;13交易失败 */
    private String tranState;
    /**此参数可直接生成二维码展示出来进行扫码支付*/
    private String codeUrl;
    /**直接用此链接请求二维码图片*/
    private String codeImgUrl;
    /**jyt平台订单号*/
    private String jytOrderId;
    
    /**小程序支付返回的支付参数*/
    private String wc_pay_data;
    
    private String urlScheme;
    
	public String getTranState() {
		return tranState;
	}
	public void setTranState(String tranState) {
		this.tranState = tranState;
	}
	public String getCodeUrl() {
		return codeUrl;
	}
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	public String getCodeImgUrl() {
		return codeImgUrl;
	}
	public void setCodeImgUrl(String codeImgUrl) {
		this.codeImgUrl = codeImgUrl;
	}
	public String getJytOrderId() {
		return jytOrderId;
	}
	public void setJytOrderId(String jytOrderId) {
		this.jytOrderId = jytOrderId;
	}
	public String getWc_pay_data() {
		return wc_pay_data;
	}
	public void setWc_pay_data(String wc_pay_data) {
		this.wc_pay_data = wc_pay_data;
	}
	public String getUrlScheme() {
		return urlScheme;
	}
	public void setUrlScheme(String urlScheme) {
		this.urlScheme = urlScheme;
	}

}
