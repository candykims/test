<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
body,ul,ol{margin:auto;text-align:center;}
div{vertical-align:middle;margin:auto;}
#box{width: 450px; overflow:hidden;text-align:center;padding-top:65px; padding-bottom:30px;border: 1px solid #A7A6A2;margin-top: 15%;
-moz-box-shadow: 2px 2px 10px #909090;/*firefox*/
-webkit-box-shadow: 2px 2px 10px #909090;/*safari或chrome*/
box-shadow:2px 2px 10px #909090;/*opera或ie9*/
}
#line{width: 450px;height:5px; background-color:#FAC802;z-index:10; border-bottom: 1px solid rgb(216, 140, 27);overflow: hidden;}
</style>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<title>金运通-收银台</title>
</head>
<body style="">

<div id="box">	
	<div> <p style="font-size:14px;">正在跳转至银行页面，请稍候...</p>
	</div>
 	<div id="line"></div>
	<div>
	<p style="color: rgb(218, 114, 1);font-size: 12px; padding-top:10px;">提示：由于网络原因，到达银行页面可能需要一点时间，请不要关闭窗口。</p>
    </div>
    <input type="hidden"  readonly="readonly" id="urlScheme" name="urlScheme" value="${param.urlScheme}" />			
</div>
<script type="text/javascript">

	$(document).ready(function() {
		var urlScheme =$("#urlScheme").val();
	    console.log(urlScheme);
	    window.location.href=urlScheme; 
	}); 

</script>
</body>
</html>