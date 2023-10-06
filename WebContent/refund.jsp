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
<form action="refund" method="post">
<div class="error_500">
<h1>金运通退款测试页面</h1>
<table>
 <tr>
    <td>merchantId</td> 
    <td><select name = "merchantId">
    		<option value="368041190098" selected="selected">368041190098</option>
    		<option value="602056610001">602056610001</option>
    		<option value="101100040110004">ms2_101银联测试商户号101100040110004</option>
    		<option value="100100047220004" >ms2_100网联测试商户号100100047220004</option>
    		<option value="368048140002" >&nbsp;&nbsp;113测试商户号368048140002</option>
    		<option value = "363015200001">&nbsp;&nbsp;13测试商户号363015200001</option>
    		<option value="290060100052">&nbsp;&nbsp;生产测试商户号290060100052</option>
    	</select>
    	</td>
  </tr>
  <tr>
    <td>ori_mer_order_id</td> 
    <td><input name="oriMerOrderId" value=""/>&nbsp;&nbsp;原商户订单号</td>
  </tr>
   <tr>
    <td>mer_refund_flow_id</td> 
    <td><input name="merRefundFlowId" value="<%=bill%>"/>&nbsp;&nbsp;商户退款流水号</td>
  </tr>
   <tr>
    <td>total_amt</td> 
    <td><input name="refundAmt" value="0.01"/>&nbsp;&nbsp;退款金额</td>
  </tr>
   <tr>
    <td>refund_channel</td> 
    <td>
    	<select id="s1Text1Italic" name="refundChannel">
    	   <option  value="00" selected="selected">原路退回</option>
           <option value="01">退回到余额</option>
    	</select>&nbsp;&nbsp;退款渠道
    </td>
  </tr>
   <tr>
    <td>mer_notify_url</td> 
    <td><input name="merNotifyUrl" value="http://192.168.50.12:8082/jyt-pay/resiveResult"/>&nbsp;&nbsp;异步通知地址</td>
  </tr>
   <tr>
    <td>refund_reason</td> 
    <td><input name="refundReason" value="测试退款"/>&nbsp;&nbsp;退款原因</td>
  </tr>
  <tr>
    <td>split_refund_amt</td> 
    <td><input name="splitRefund_amt" />&nbsp;&nbsp;分账退款金额</td>
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