<%@ page contentType="text/html;charset=utf-8" import="java.util.*"  import="java.text.*"  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>模拟商户提交订单支付请求</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
<style>
.error_500{
            margin:100px auto;
            background: #fff;
            box-shadow: 1px 1px 2px 0 rgba(0,0,0,.3);
            padding:30px 50px 50px;
            font-family: "microsoft yahei";
            font-size: 14px;
            color:#404040;
        }
td{font-size:12px;font-weight:normal; font-family:Arial, Lucida, Verdana, Helvetica, SimSun,sans-serif;}
</style>
<%
Random random = new Random(System.currentTimeMillis());
int iRandom = random.nextInt(10000)+10000000;
String bill = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"-"+String.valueOf(iRandom);
%>
</head>
<body>
<form action="mchConfig" method="post">
<div class="error_500">
<h1>金运通商户配置测试页面</h1>
<table>
 <tr>
    <td>merchant_id</td> 
    <td><input name="merchantId" value="368041190100"/>&nbsp;&nbsp;商户号</td>
  </tr>
  <tr>
    <td>pay_rate_mode</td> 
    <td> 
    	<select id="s1_text1_italic" name="payRateMode">
          <option  value="00" selected="selected">线上费率</option>
          <option  value="01">线下费率</option>
          <option  value="02">优惠费率</option>
          <option  value="03">保险费率</option>
          <option  value="04">减免费率</option>
          <option  value="05">12</option>
        </select>&nbsp;&nbsp;支付费率模式
    </td>
  </tr>
   <tr>
    <td>deploy_type</td> 
    <td>
    	<select id="s1_text2_italic" name="deployType">
          <option  value="00" selected="selected">绑定appId</option>
          <option  value="01">配置支付授权目录</option>
        </select>&nbsp;&nbsp;配置类型
    </td>
  </tr>
  <tr>
    <td>sub_app_id</td> 
    <td><input name="subAppId"/>&nbsp;&nbsp;subAppId</td>
  </tr>
  <tr>
    <td>jsapi_path</td> 
    <td><input name="jsapiPath"/>&nbsp;&nbsp;支付授权目录</td>
  </tr>
  <tr>
    <td></td>
    <td><input  type="submit" value="提       交" /></td>
  </tr>
</table>
</div>
</form>
</body>
</html>