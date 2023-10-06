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
<form action="jsPay" method="post">
<div class="error_500">
<h1>金运通JS支付测试页面</h1>
<table>
 <tr>
    <td>merchant_no</td> 
    <td><input name="merchantId" value="391079330001"/>&nbsp;&nbsp;商户号</td><!-- 602056610001 -->
  </tr>
  <tr>
    <td>pay_channel</td> 
    <td> <select id="s1_text1_italic" name="payChannel">
          <option  value="00" selected="selected">微信</option>
          <option  value="01">支付宝</option>
          <option  value="02">QQ</option>
          </select>&nbsp;&nbsp;支付渠道</td>
  </tr>
   <tr>
    <td>pay_mode</td> 
    <td><input name="payMode" value="02" />&nbsp;&nbsp;支付模式</td>
  </tr>
   <tr>
    <td>order_id</td> 
    <td><input name="orderId" value="<%=bill%>"/>&nbsp;&nbsp;订单号</td>
  </tr>
   <tr>
    <td>total_amt</td> 
    <td><input name="totalAmt" value="0.02"/>&nbsp;&nbsp;支付金额</td>
  </tr>
   <tr>
    <td>subject</td> 
    <td><input name="subject" value="Apple/苹果 iPhone 7 Plus¥ 6388.00-7988.00"/>&nbsp;&nbsp;订单描述</td>
  </tr>
   <tr>
    <td>notify_url</td> 
    <td><input name="notifyUrl" value="http://192.168.50.12:8082/jyt-pay/resiveResult"/>&nbsp;&nbsp;异步通知地址</td>
  </tr>
   <tr>
    <td>body</td> 
    <td><input name="body" value="Apple/苹果 iPhone7Plus"/>&nbsp;&nbsp;支付描述</td>
  </tr>
   <tr>
    <td>spbill_create_ip</td> 
    <td><input name="spbillCreatIp" value="192.168.50.12"/>&nbsp;&nbsp;支付ip</td>
  </tr>
   <tr>
    <td>wx_call_back_url</td> 
    <td><input name="wxCallBackUrl" value="https://www.baidu.com"/>&nbsp;&nbsp;同步跳转地址</td>
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