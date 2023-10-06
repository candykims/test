package com.jytpay.util;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.jyt.baseUtil.des.CryptoUtils;
import com.jyt.baseUtil.utils.StringUtil;

public class RSAUtil {
	
	public static  RSAHelper rsaHelper = new RSAHelper();
	

	private static final String privateStr = "*************";
	private static final String publicStr = "*************";
			
	static{
		try {
//            String pfxPath = RSAUtil.class.getClassLoader().getResource("cert/merchantTest.pfx").getPath();
//            String pubCertPath = RSAUtil.class.getClassLoader().getResource("cert/jytpayserver.cer").getPath();
//            rsaHelper.initKey(rsaHelper.getPrivateKeyFromPfx(pfxPath, "password"), rsaHelper.getPublicKeyFromCer(pubCertPath));
            
            /**
             * 自建证书
             */
            String privateKeyStr = privateStr;
            String publicKeyStr= publicStr;
            PrivateKey privateKey = rsaHelper.getPrivateKey(privateKeyStr);
            PublicKey publicKey  = rsaHelper.getPublicKey(publicKeyStr);
            rsaHelper.initKey(privateKey, publicKey);
		} catch (Exception e) {
			System.out.println("密钥初始化异常");
			e.printStackTrace();
		}
	}

	public static String signMsg( String xml ){
		String hexSign = null ;
		
		try {
			byte[] sign = rsaHelper.signRSA(xml.getBytes("UTF-8"), false, "UTF-8") ;
			
			hexSign = StringUtil.bytesToHexString(sign) ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hexSign;
	}
	
	public static String encryptKey( byte[] key){
		
		byte[] enc_key = null ;
		try {
			enc_key = rsaHelper.encryptRSA(key, false, "UTF-8") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return StringUtil.bytesToHexString(enc_key) ;
	}
	
	public static  byte[] decryptKey(String hexkey){
		byte[] key = null ;
		byte[] enc_key = StringUtil.hexStringToBytes(hexkey) ;
		
		try {
			key = rsaHelper.decryptRSA(enc_key, false, "UTF-8") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return key ;
	}
	
	public static String encryptMsg(String msg, byte[] key) {
		String enc_msg = CryptoUtils.desEncryptToHex(msg, key);
		return enc_msg;
	}
	
	public static String decrytXml(String xml_enc, byte[] key) {
		String xml = CryptoUtils.desDecryptFromHex(xml_enc, key);
		return xml;
	}

	
	public static boolean verifyMsgSign(String xml, String sign)
	{
		byte[] bsign = StringUtil.hexStringToBytes(sign) ;
		
		boolean ret = false ;
		try {
			ret = rsaHelper.verifyRSA(xml.getBytes("UTF-8"), bsign, false, "UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
