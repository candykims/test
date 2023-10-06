package com.jytpay.bean;

/**
 * 集中收银,预下单请求接口
 */
public class OP1001_BodyReq{
	
	/**支付渠道代码:00-WX;01-ALI;02-QQ;05-银联二维码*/
    private String payChannel;
    /**支付模式代码:00-主动扫码;01-被动扫码;02-公众号支付*/
    private String payMode;
    /**商户系统内部的订单号 ,32个字符内、 可包含字母,确保在商户系统唯一，最少6位*/
    private String orderId;
    /**商户终端设备号*/
    private String deviceInfo;
    /**订单描述*/
    private String subject;
    /**订单详情*/
    private String body;
    /**商户附加信息，可做扩展参数， 128 字符内*/
    private String attach;
    /**总金额，以元为单位，不允许包含任何字、符号*/
    private String totalAmt;
    /**订单生成的机器 IP*/
    private String spbillCreatIp;
    /**接收信运付通知的 URL，需给绝对路径.确保信运付能通过互联网访问该地址(主扫和JS支付)*/
    private String notifyUrl;
    /**订单失效时间，格式为 yyyyMMddHHmmss*/
    private String exprieTime;
    /**商品标记，用于优惠券或者满减使用*/
    private String goodsTag;
    /**预留字段，此 id 为静态可打印的二维码中包含的商品ID，商户自行维护。*/
    private String productId;
    /**扫码支付授权码，设备读取用户展示的条码或者二维码信息（被扫）*/
    private String authCode;
    /**是否原生态:值为 1：由商户自行调用微信支付;值为 0：由平台完成支付;不传默认是 0(JS)*/
    private String wxIsRaw;
    /**用户 openid(JS)*/
    private String wxSubOpenid;
    /**支付用户ID(JS)*/
    private String userId;
    /**合作方微信公众账号ID(JS)*/
    private String subAppId;
    /**前台地址(JS)*/
    private String wxCallbackUrl;
    
    private String js_code;
    
	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getSpbillCreatIp() {
		return spbillCreatIp;
	}

	public void setSpbillCreatIp(String spbillCreatIp) {
		this.spbillCreatIp = spbillCreatIp;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getExprieTime() {
		return exprieTime;
	}

	public void setExprieTime(String exprieTime) {
		this.exprieTime = exprieTime;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getWxIsRaw() {
		return wxIsRaw;
	}

	public void setWxIsRaw(String wxIsRaw) {
		this.wxIsRaw = wxIsRaw;
	}

	public String getWxSubOpenid() {
		return wxSubOpenid;
	}

	public void setWxSubOpenid(String wxSubOpenid) {
		this.wxSubOpenid = wxSubOpenid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getWxCallbackUrl() {
		return wxCallbackUrl;
	}

	public void setWxCallbackUrl(String wxCallbackUrl) {
		this.wxCallbackUrl = wxCallbackUrl;
	}

	public String getJs_code() {
		return js_code;
	}

	public void setJs_code(String js_code) {
		this.js_code = js_code;
	}

}
