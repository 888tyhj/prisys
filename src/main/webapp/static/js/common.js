/**
 * 公共的js
 */
//屏幕的宽
var clientWidth=$(window).width();
//屏幕的高
var clientHeight=$(window).height();
//显示为"--"的值
var showBar=-1;

/**
 * 显示左面对应的导航
 * @param id  导航id
 * @return
 */
function showLeftStyle(id){
	$("#sidebar #"+id).attr("class","active open");
	$("#sidebar #"+id).parent().parent().attr("class","sub-menu active");
	$("#home_title").html("系统管理");
}
/**
 * 显示右上角TAB导航
 * @param id  导航id
 * @return
 */
function showRightHeadStyle(id){
	var span11_obj=$("#"+id)
	span11_obj.removeClass().addClass("active");
}

$(function(){
	gettime();
	
	$("div").on("keypress","input",function(event){
		return noNumbers(event);
	})
	
	$("div").on("keyup","input",function(event){
		    var value=$(this).val();
		    if(value){
		    	if(value.indexOf("%")>=0){
		    		$(this).val(value.replace(/%/g, ""))
		    	}
		    }
	})

});

// 显示头部时间
function gettime(){
	var date = new Date();
	this.year = date.getFullYear();
	this.month = date.getMonth() + 1;
	this.date = date.getDate();
	this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	var currentTime = "今天是" + this.year + "年" + this.month + "月" + this.date + "日 " + this.day;
	$("#rq").text(currentTime);
	//+ this.hour + ":" + this.minute + ":" + this.second + " " 
}

/**bootstrap*/
$("#main-content").height(clientHeight-100);


/**
 * 查看用户信息
 */
function showLoginUserDialog(){
    $('#showLoginUserDialog').dialog({
       iconCls:'icon-user',
	    title: '我的信息',
	    width: 600,
	    height: 500,
	    closed: false,
	    cache: false,
	    resizable:true,
	    href: getRootPath()+'/forwardindex?url=persys/user/showuser',
	    modal: true,
	    onLoad:function(){
		}
	});
	//$('#dd').dialog('refresh', 'addpwk.jsp');
}

function alert(v){
	top.$.messager.alert('提示信息',v,'info');
}

//增加对象的前缀
function addPrefix(o, prefix) {
	var obj = {};
	$.each(o, function(i, n) {
		obj[prefix + i] = n;
	});
	return obj;
}
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

String.prototype.Trim = function() {
    return this.trim();
}
//进度条代码
function showProcess(isShow, title, msg) {
    if (!isShow) {
        $.messager.progress('close');
       return;
   }
   var win = $.messager.progress({
      title: title,
      msg: msg
   });
}
function getOs() 
{ 
    var OsObject = ""; 
   if(isIE = navigator.userAgent.indexOf("MSIE")!=-1) { 
        return "MSIE"; 
   } 
   if(isFirefox=navigator.userAgent.indexOf("Firefox")!=-1){ 
        return "Firefox"; 
   } 
   if(isChrome=navigator.userAgent.indexOf("Chrome")!=-1){ 
        return "Chrome"; 
   } 
   if(isSafari=navigator.userAgent.indexOf("Safari")!=-1) { 
        return "Safari"; 
   }  
   if(isOpera=navigator.userAgent.indexOf("Opera")!=-1){ 
        return "Opera"; 
   } 

}
Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 
	if(/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 
	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
		format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		}
	}
	return format; 
}
//计算天数差的函数，通用  
function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式  
    var  aDate,  oDate1,  oDate2,  iDays  
    aDate  =  sDate1.split("-")  
    oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式  
    aDate  =  sDate2.split("-")  
    oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])  
    iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数  
    return  iDays  
}   
/**
 * 计算月份差的函数
 *   时间：yyyy-MM
 * @param date1 开始时间 
 * @param date2 结束时间
 * @return 结果
 */
function dateMonthDiff(date1,date2){
	// 拆分年月日
	date1 = date1.split('-');
	// 得到月数
	date1 = parseInt(date1[0]) * 12 + parseInt(date1[1]);
	// 拆分年月日
	date2 = date2.split('-');
	// 得到月数
	date2 = parseInt(date2[0]) * 12 + parseInt(date2[1]);
	var m = Math.abs(date1 - date2);
	return m;
}
/**
 * 计算目标日期的前N小时
 * @param targetDate 目标日期 date类型
 * @param hour 要减去的小时数 number类型
 * @param formatstr 格式化日期的格式 例如："yyyy-MM-dd hh"
 * @return 结果 
 */
function getPreNHourDate(targetDate,hour,formatstr){
	var nowTime=targetDate.getTime();
	var threeHourTime=hour*60*60*1000;
	var minusTime=nowTime-threeHourTime;
	var nowdate=new Date(minusTime);
	return nowdate.format(formatstr);
}
function getDateByDate(zdate,day){
    var sdate=zdate.getTime()-(1*24*60*60*1000);
    var edate=new Date(sdate-(day*24*60*60*1000)).format("yyyy-MM-dd");
    return edate;
}
function strToDate(str) {
	  var dateStrs = str.split("-");
	  var year = parseInt(dateStrs[0], 10);
	  var month = parseInt(dateStrs[1], 10)-1;
	  var day = parseInt(dateStrs[2], 10)+1;
	  var date = new Date(year, month, day);
	  return date;
}
/**
 * 计算当前时间减去规定的时间
 * @param strdate 开始日期
 * @param minus 减去多少天
 * @return
 */
function getPreNDate(strdate,minus){
	var arr=strdate.split("-");
    var year=parseInt(arr[0],10);
    var month=parseInt(arr[1],10);
    var sub=arr[2].split(" ");
    var day=parseInt(sub[0],10);
    var v="";
    if(day<=minus){
        if(month==1){
        	year=year-1;
        	v=year+"-12-"+(month+31-minus);
        }else{
        	var arr1 = new Array([31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);
        	if((year%4==0&&year%100!=0)||year%400==0)   {    
            	arr1[1]++; 
        	}
        	var mm=arr1[month-1-1]-minus;
        	v=year+"-"+((month-1)<10?"0"+(month-1):(month-1))+"-"+(day+(mm=0?"":mm));
        }
    }else{
    	v=year+"-"+(month<10?"0"+month:month)+"-"+((day-minus)<10?"0"+(day-minus):(day-minus));
    }
    if(sub[1]!=null&&sub[1]!=""){
    	v=v+" "+sub[1];
    }
   return v;
 }


function getYestoday(date){
	var yesterday_milliseconds=date.getTime()-1000*60*60*24;     
	var yesterday = new Date();     
	yesterday.setTime(yesterday_milliseconds);     
	  
	var strYear = yesterday.getFullYear();  
	var strDay = yesterday.getDate();  
	var strMonth = yesterday.getMonth()+1;
	if(strMonth<10)  
	{  
		strMonth="0"+strMonth;  
	}
	if(strDay<10)  
	{  
		strDay="0"+strDay;  
	}
	datastr = strYear+"-"+strMonth+"-"+strDay;
	return datastr;
}

//明天
function getTomorrow(date){
	var yesterday_milliseconds=date.getTime()+1000*60*60*24;     
	var yesterday = new Date();     
	yesterday.setTime(yesterday_milliseconds);     
	  
	var strYear = yesterday.getFullYear();  
	var strDay = yesterday.getDate();  
	var strMonth = yesterday.getMonth()+1;
	if(strMonth<10)  
	{  
		strMonth="0"+strMonth;  
	}
	if(strDay<10)  
	{  
		strDay="0"+strDay;  
	}
	datastr = strYear+"-"+strMonth+"-"+strDay;
	return datastr;
}

function getYestodayTime(date){
	var yesterday_milliseconds=date.getTime()-1000*60*60*24;     
	var yesterday = new Date();     
	yesterday.setTime(yesterday_milliseconds);     
	  
	var strYear = yesterday.getFullYear();  
	var strDay = yesterday.getDate();  
	var strMonth = yesterday.getMonth()+1;
	var strHour=yesterday.getHours();
	var strMin=yesterday.getMinutes();
	var strSec=yesterday.getSeconds();
	if(strMonth<10)
	{
		strMonth="0"+strMonth;  
	}
	if(strDay<10)
	{
		strDay="0"+strDay;  
	}
	if(strHour<10)
	{
		strHour="0"+strHour;  
	}
	if(strMin<10)
	{
		strMin="0"+strMin;  
	}
	if(strSec<10)
	{
		strSec="0"+strSec;  
	}
	datastr = strYear+"-"+strMonth+"-"+strDay+" "+strHour+":"+strMin+":"+strSec;
	return datastr;
}
  
  //获得上个月在昨天这一天的日期
  function getLastMonthYestdy(date){
     var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);
	 var strYear = date.getFullYear();  
	 var strDay = date.getDate();  
	 var strMonth = date.getMonth()+1;
	 if(strYear%4 == 0 && strYear%100 != 0){
		daysInMonth[2] = 29;
	 }
	 if(strMonth - 1 == 0)
	 {
		strYear -= 1;
		strMonth = 12;
	 }
	 else
	 {
		strMonth -= 1;
	 }
     strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
	 if(strMonth<10)  
	 {  
		strMonth="0"+strMonth;  
	 }
	 if(strDay<10)  
	 {  
		strDay="0"+strDay;  
	 }
	 datastr = strYear+"-"+strMonth+"-"+strDay;
	 return datastr;
  }
  
  //获得上一年在昨天这一天的日期
  function getLastYearYestdy(date){
	 var strYear = date.getFullYear() - 1;  
	 var strDay = date.getDate();  
	 var strMonth = date.getMonth()+1;
	 if(strMonth<10)  
	 {  
		strMonth="0"+strMonth;  
	 }
	 if(strDay<10)  
	 {  
		strDay="0"+strDay;  
	 }
	 datastr = strYear+"-"+strMonth+"-"+strDay;
	 return datastr;
  }
function noNumbers(e) {
	var keynum;
	var keychar;
	var numcheck;
	var flag=true;

	if (window.event) // IE  
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera  
	{
		keynum = e.which
	}
	keychar = String.fromCharCode(keynum);
	numcheck = /[%'"<>$&^￥-\s]/g;
	flag=!numcheck.test(keychar);
	return  flag;
}
function cjkEncode(text) {                                                                             
    if (text == null) {          
      return "";          
    }          
    var newText = "";          
    for (var i = 0; i < text.length; i++) {          
      var code = text.charCodeAt (i);           
      if (code >= 128 || code == 91 || code == 93) {  //91 is "[", 93 is "]".          
        newText += "[" + code.toString(16) + "]";          
      } else {          
        newText += text.charAt(i);          
      }          
    }          
    return newText;          
}

function clearNoNum(obj){  
	obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
	obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是. 
	 obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.   
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	//obj.value =Math.round(obj.value*100)/100;
	var re = /([0-9]+\.[0-9]{2})[0-9]*/;
	obj.value=obj.value.replace(re,"$1");
} 

/**
 * @return 项目的根
 */
function getRootPath() {
    //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/ems
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPath + projectName);
};


/**********************************Cookies操作函数*******************************/
//hours为空字符串时,cookie的生存期至浏览器会话结束。hours为数字0时,建立的是一个失效的cookie,这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。   
function setCookie(name,value,hours,path){
  var name = escape(name);   
  var value = escape(value);   
  var expires = new Date();   
  expires.setTime(expires.getTime() + hours*3600000);   
  path = path == "" ? "" : ";path=" + path;   
  _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();   
  document.cookie = name + "=" + value + _expires + path;   
}   
//获取cookie值    方法
function getCookieValue(name){   
  var name = escape(name);   
  //读cookie属性，这将返回文档的所有cookie   
  var allcookies = document.cookie;          
  //查找名为name的cookie的开始位置   
  name += "=";   
  var pos = allcookies.indexOf(name);       
  //如果找到了具有该名字的cookie，那么提取并使用它的值   
  if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败   
      var start = pos + name.length;                  //cookie值开始的位置   
      var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置   
      if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie   
      var value = allcookies.substring(start,end);  //提取cookie的值   
      return unescape(value);                           //对它解码         
      }      
  else return "";                                             //搜索失败，返回空字符串   
}   
//删除cookie
function delCookie(name)         
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=this.GetCookie(name);
  if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
/**********************************页面操作函数*******************************/
/*加入收藏*/
function AddBookmark(site, url){
  if(navigator.userAgent.toLowerCase().indexOf('ie') > -1) {
      window.external.addFavorite(url,site)
  } else if (navigator.userAgent.toLowerCase().indexOf('opera') > -1) {
      alert ("请使用Ctrl+T将本页加入收藏夹");
  } else {
      alert ("请使用Ctrl+D将本页加入收藏夹");
  }
}
/*设为首页，如有参数就设置成参数*/
function SetHome()
{
  var img=new Image();
  img.style.behavior='url(#default#homepage)';
  if(arguments.length>0){
      img.setHomePage(arguments[0]);
  }
  else{
      img.setHomePage(location.href);
  }
}
/**********************************文件加载函数*******************************/
//页面必须有head元素,Loadfile("test.js", "js"),Loadfile("javascript.php", "js"),Loadfile("test.css", "css")
function loadfile(filename, filetype)
{
var fileref;
//判断文件类型 
switch(filetype)
{
    case "js":
        fileref=document.createElement('script');
        fileref.setAttribute("lang ge", "javascript");
        fileref.setAttribute("type","text/javascript");
        fileref.setAttribute("src", filename);
        break;
    case "css":
        fileref=document.createElement("link");
        fileref.setAttribute("rel", "stylesheet");
        fileref.setAttribute("type", "text/css");
        fileref.setAttribute("href", filename);
        break;
    default:
        break;
}
if (typeof fileref!="undefined") 
  document.getElementsByTagName("head")[0].appendChild(fileref);
} 
/***********************************验证类函数**********************************/
/*  检测字符长度
  @str        字符集
  @s          开始长度
  @l          结束长度
*/
function isLen(str,s,l){
  str=Trim(str);
  if(str.length>s && str.length<l){
      return true;
  }
  else{
      return false;
  }
}
/*  是否是数字型数据
  @str        字符集
*/
function isNumber(str){
  if (/^\d+$/.test(str)){return true;}else{return false;}
}
/*  是否是自然数型数据
  @str        字符集
*/
function isInt(str){
  if (/^(\+|-)?\d+$/.test(str)){return true;}else{return false;}
}
/*是否为字母和数字（字符集）*/
function isLetters(str)
{
   if (/^[A-Za-z0-9]+$/.test(str)){return true;}else{return false;}
}
/*是否为英文字母（字符集）*/
function isLetter(str)
{
   if (/^[A-Za-z]+$/.test(str)){return true;}else{return false;}
}
/*是否为大写字母（字符集）*/
function isUpper(str)
{
   if (/^[A-Z]+$/.test(str)){return true;}else{return false;}
}
/*是否为小写字母（字符集）*/
function isLower(str)
{
   if (/^[a-z]+$/.test(str)){return true}else{return false;}
}
/*  是否为正确的网址
  @str        字符集
*/
function isUrl(str)
{
  var myReg = /^((http:[/][/])?\w+([.]\w+|[/]\w*)*)?$/;    
  if(myReg.test(str)){return true;}else{return false;}
}
/*  是否为正确的Email形式
  @str        字符集
*/
function isEmail(str)
{
  var myReg = /^([-_A-Za-z0-9\.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;    
  if(myReg.test(str)){return true;}else{return false;}
}
/*  是否为正确的手机号码
  @str        字符集
*/
function isMobile(str)
{
  var regu =/(^[1][3][0-9]{9}$)|(^0[1][3][0-9]{9}$)/;   
  var re = new RegExp(regu);   
  if (re.test(str)){return true;}else{return false;}
}
/**
* 只软许输入设定精度的double值
* 写法：onkeyup="keyUpDouble(this,2)"
* @param obj input对象
* @param num 精度 如果为0 精度就是1;
*                如果大于0 就是 1,num
*/
function keyUpDouble(obj, num){
	 var str="1";
	 var targetValue=$(obj).val();
	 if(String(parseInt(targetValue))=='NaN'){
		 newValue="";
	 }
	 if(parseInt(num)>0){
		 str="1,"+num;
	 }
	 eval("var re = /^((\\d*?)(\\.?)((\\d{"+str+"})?))$/;"); 
	 if(!targetValue.match(re)){
		 $(obj).val(newValue);
   }else{
  	 newValue=targetValue;
   }
}