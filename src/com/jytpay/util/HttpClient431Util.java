package com.jytpay.util;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.jyt.baseUtil.exception.AppException;

public class HttpClient431Util {

	private static final RequestConfig config;

	public static final String DEFAULT_SEND_CHARSET = "UTF-8";

	public static final String DEFAULT_RES_CHARSET = "UTF-8";

	static {
		config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(60000).build();
	}

	public static String doPost(Map<String, String> params, String url) {
		return doPost(params, url, DEFAULT_SEND_CHARSET, DEFAULT_RES_CHARSET);
	}

	/**
	 * HTTP Post 获取内容
	 * 
	 * @param params
	 *            请求的参数
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param reqCharset
	 *            编码格式
	 * @param resCharset
	 *            编码格式
	 * @return 页面内容
	 */
	public static String doPost(Map<String, String> params, String url, String reqCharset, String resCharset) {
		CloseableHttpClient httpClient = getSingleSSLConnection(config);

		CloseableHttpResponse response = null;
		if (StringUtils.isBlank(url)) {
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			httpPost.addHeader("Connection", "close");
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(
						new UrlEncodedFormEntity(pairs, reqCharset == null ? DEFAULT_SEND_CHARSET : reqCharset));
			}
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new AppException("状态码" + statusCode, "HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, resCharset == null ? DEFAULT_RES_CHARSET : resCharset);
			}
			EntityUtils.consume(entity);
			response.close();
			return result;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw new AppException(e);
			// TODO LOG
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * 创建单向ssl的连接
	 * 
	 * @return
	 * @throws AppException
	 */
	private static CloseableHttpClient getSingleSSLConnection(RequestConfig config) throws AppException {
		CloseableHttpClient httpClient = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
						throws CertificateException {
					return true;
				}
			}).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultRequestConfig(config).build();
			return httpClient;
		} catch (Exception e) {
			throw new AppException(e);
		}

	}

}
