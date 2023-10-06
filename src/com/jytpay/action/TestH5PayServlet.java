package com.jytpay.action;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jyt.baseUtil.utils.StringUtil;
import com.jytpay.bean.OP1001_BodyReq;
import com.jytpay.bean.OP1001_HeaderReq;
import com.jytpay.bean.OP1001_TradeReq;
import com.jytpay.bean.OP1001_TradeRsp;
import com.jytpay.util.BeanToMapUtil;
import com.jytpay.util.DESHelper;
import com.jytpay.util.DateTimeUtils;
import com.jytpay.util.HttpClient431Util;
import com.jytpay.util.RSAUtil;
/**
 * 主动扫码
 *
 */
public class TestH5PayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String TRAN_CODE = "OP1001";
	public static String VERSION = "2.0.0";
	public static String REQUEST_TRAN_TYPE = "01";
	public static String RESP_MSG_PARAM_SEPARATOR = "&";
	/** 返回报文merchant_id字段前缀 */
	public static String RESP_MSG_PARAM_PREFIX_MERCHANT_ID = "merchant_id=";

	public static String RESP_MSG_PARAM_PREFIX_MSG_ENC = "msg_enc=";
	/** 返回报文xml_enc字段前缀 */
	public static String RESP_MSG_PARAM_PREFIX_XML_ENC = "xml_enc=";
	/** 返回报文xml_enc字段前缀 */
	public static String RESP_MSG_PARAM_PREFIX_KEY_ENC = "key_enc=";

	/** 返回报文sign字段前缀 */
	public static String RESP_MSG_PARAM_PREFIX_SIGN = "sign=";

	public static String ONEPAY_SERVER_URL = "https://test.jytpay.com/onePayService/test/onePay.do";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");  //这种方式有用
		
		SortedMap<String, String> map = BeanToMapUtil.getParameterMap(req);
		OP1001_BodyReq body = null;
		OP1001_HeaderReq head = null;

		try {
			body = (OP1001_BodyReq) BeanToMapUtil.convertMap(OP1001_BodyReq.class, map);
			head = (OP1001_HeaderReq) BeanToMapUtil.convertMap(OP1001_HeaderReq.class, map);
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
				| IntrospectionException e1) {
			e1.printStackTrace();
		}
		head = this.getOp1001Header(head, body.getOrderId());
		OP1001_TradeReq reqBean = new OP1001_TradeReq(head, body);
		String reqBeanStr = JSONArray.toJSONString(reqBean);

		String sign = RSAUtil.signMsg(reqBeanStr);
		System.out.println("报文明文：" + reqBeanStr);
		System.out.println("报文签名：" + sign);

		byte[] des_key = DESHelper.generateDesKey();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("merchant_id", head.getMerchantId());
		paramMap.put("msg_enc", RSAUtil.encryptMsg(reqBeanStr, des_key));
		paramMap.put("key_enc", RSAUtil.encryptKey(des_key));
		paramMap.put("sign", sign);
		paramMap.put("mer_order_id", head.getTranFlowid());

		// 获取执行结果
		String res = HttpClient431Util.doPost(paramMap, ONEPAY_SERVER_URL);
		System.out.println(res);
		if (res == null) {
			System.err.println("服务器连接失败");
			return;
		} else {
			System.out.println("连接服务器成功,返回结果" + res);
		}
		String[] respMsg = res.split(RESP_MSG_PARAM_SEPARATOR);

		String merchantId = respMsg[0].substring(RESP_MSG_PARAM_PREFIX_MERCHANT_ID.length());
		String respMsgEnc = respMsg[1].substring(RESP_MSG_PARAM_PREFIX_MSG_ENC.length());
		String respKeyEnc = respMsg[2].substring(RESP_MSG_PARAM_PREFIX_KEY_ENC.length());
		String respSign = respMsg[3].substring(RESP_MSG_PARAM_PREFIX_SIGN.length());

		byte respKey[] = RSAUtil.decryptKey(respKeyEnc);

		String respMsgContext = RSAUtil.decrytXml(respMsgEnc, respKey);

		System.out.println("返回报文merchantId:" + merchantId);
		System.out.println("返回报文Json:" + respMsgContext);
		System.out.println("返回报文签名:" + respSign);

		if (!RSAUtil.verifyMsgSign(respMsgContext, respSign)) {
			System.err.println("返回报文校验失败");
			return;
		}
		JSON json = JSONObject.parseObject(respMsgContext);
		OP1001_TradeRsp tradeResp = (OP1001_TradeRsp) JSONObject.toJavaObject(json, OP1001_TradeRsp.class);
		String urlScheme = tradeResp.getBody().getUrlScheme();
		resp.sendRedirect("h5pay-commit.jsp?urlScheme="+urlScheme);
	}

	private OP1001_HeaderReq getOp1001Header(OP1001_HeaderReq headerBean, String orderId) {
		headerBean.setVersion(VERSION);
		headerBean.setTranType(REQUEST_TRAN_TYPE);
		headerBean.setTranTime(
				DateTimeUtils.getDateTimeToString(new Date(), DateTimeUtils.DATETIME_FORMAT_YYYYMMDDHHMMSS));
		headerBean.setTranFlowid(orderId);
		headerBean.setTranCode(TRAN_CODE);
		return headerBean;
	}

	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
