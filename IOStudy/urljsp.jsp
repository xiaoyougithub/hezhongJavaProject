












<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>逍幽博客--博客文章</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">


  </head>
<style type="text/css">
	#left{
		color:yellow;
	}
	#main_view{
		background:url(../image/sky.jpg);
		color:green;
	}
	.post_blog_list a{
		color:yellow;
	}
</style>  
  <body>
   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  <script language =javascript >
var curIndex=0;
//时间间隔(单位毫秒)，每秒钟显示一张，数组共有5张图片放在Photos文件夹下。
var timeInterval=2000;
var arr=new Array();
arr[0]="image/hmj/hmj1.jpg";
arr[1]="image/hmj/hmj2.jpg";
arr[2]="image/hmj/hmj3.jpg";
arr[3]="image/hmj/hmj4.jpg";
arr[4]="image/hmj/hmj5.jpg";
arr[5]="image/hmj/hmj6.jpg";
arr[6]="image/hmj/hmj7.jpg";
arr[7]="image/hmj/hmj8.jpg";
arr[8]="image/hmj/hmj9.jpg";
arr[9]="image/hmj/hmj10.jpg";
arr[10]="image/hmj/hmj11.jpg";
arr[11]="image/hmj/hmj12.jpg";
arr[12]="image/hmj/hmj13.jpg";
arr[13]="image/hmj/hmj14.jpg";
arr[14]="image/hmj/hmj15.jpg";
arr[15]="image/hmj/hmj16.jpg";
arr[16]="image/hmj/hmj17.jpg";
arr[17]="image/hmj/hmj18.jpg";
arr[18]="image/hmj/hmj19.jpg";
arr[19]="image/hmj/hmj20.jpg";
arr[20]="image/hmj/hmj21.jpg";
arr[21]="image/hmj/hmj22.jpg";
arr[22]="image/hmj/hmj23.jpg";
arr[23]="image/hmj/hmj24.jpg";
arr[24]="image/hmj/hmj1.jpg";
arr[25]="image/hmj/hmj25.jpg";
arr[26]="image/hmj/hmj26.jpg";
arr[27]="image/hmj/hmj27.jpg";
arr[28]="image/hmj/hmj28.jpg";
arr[29]="image/hmj/hmj29.jpg";
arr[30]="image/hmj/hmj30.jpg";
arr[31]="image/hmj/hmj31.jpg";
arr[32]="image/hmj/hmj32.jpg";
arr[33]="image/hmj/hmj33.jpg";
arr[34]="image/hmj/hmj34.jpg";
arr[35]="image/hmj/hmj35.jpg";
arr[36]="image/hmj/hmj36.jpg";
arr[37]="image/hmj/hmj37.jpg";
arr[38]="image/hmj/hmj38.jpg";
arr[39]="image/hmj/hmj39.jpg";
arr[40]="image/hmj/hmj40.jpg";
arr[41]="image/hmj/hmj41.jpg";
arr[42]="image/hmj/hmj42.jpg";
arr[43]="image/hmj/hmj43.jpg";
arr[44]="image/hmj/hmj44.jpg";
arr[45]="image/hmj/hmj45.jpg";
arr[46]="image/hmj/hmj46.jpg";

setInterval(changeImg,timeInterval);
function changeImg()
{
var obj=document.getElementById("obj");
if (curIndex==arr.length-1)
{
curIndex=0;
}
else
{
curIndex+=1;
}
obj.src=arr[curIndex];
}
</script>
  <body>
    <div id="top">
   <img id="obj" src="image/hmj/hmj0.jpg" width="1100px" height="800px">
   </div>
  </body>
</html>

    <div id="main">
    	



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">


  </head>
  <style type="text/css"> 
  	
  </style>
  <body>
	<div id="menu">
    		<ul class="menu">
    			<li><a href="index.jsp"><b>首页</b></a></li>
    			<li><a href="life.jsp"><b>相册</b></a></li>
    			<li><a href="program.jsp"><b>我的小程序</b></a></li>
    			<li><a href="leaveMessage.html"><b>给我留言</b></a></li>

            <li><a href="blog-list.jsp?classId=24">规划和总结</a></li>
			
            <li><a href="blog-list.jsp?classId=34">艺术与人生</a></li>
			
            <li><a href="blog-list.jsp?classId=36">长期回顾</a></li>
			
            <li><a href="blog-list.jsp?classId=9">*双语</a></li>
			
            <li><a href="blog-list.jsp?classId=25">逍幽文集</a></li>
			
            <li><a href="blog-list.jsp?classId=11">数学</a></li>
			
            <li><a href="blog-list.jsp?classId=12">政治和历史</a></li>
			
            <li><a href="blog-list.jsp?classId=29">四六级翻译</a></li>
			
            <li><a href="blog-list.jsp?classId=30">日常积累</a></li>
			
            <li><a href="blog-list.jsp?classId=31">日常写作</a></li>
			
            <li><a href="blog-list.jsp?classId=32">周常口语稿</a></li>
			
            <li><a href="blog-list.jsp?classId=33">日常听力理解训练</a></li>
			
            <li><a href="blog-list.jsp?classId=37">党务</a></li>
			
            <li><a href="blog-list.jsp?classId=8">*软件工程</a></li>
			
            <li><a href="blog-list.jsp?classId=35">软件设计师备考</a></li>
			
            <li><a href="blog-list.jsp?classId=38">合众实训</a></li>
			
            <li><a href="blog-list.jsp?classId=23">*书画</a></li>
			
            <li><a href="blog-list.jsp?classId=26">学习方法总结</a></li>
			
            <li><a href="blog-list.jsp?classId=27">教学课件</a></li>
			
            <li><a href="blog-list.jsp?classId=28">软件资源百度网盘共享</a></li>
			
            <li><a href="blog-list.jsp?classId=20">实用网站</a></li>
			
            <li><a href="blog-list.jsp?classId=21">其它</a></li>
			
			<li><a href="backmanager/login.jsp" target="_blank"><b>后台登录</b></a></li>
    		</ul>
    	</div> 
    	<h3>本网站仍在完善中，敬请期待...This website is still in the process of improvement. Please look forward to it.</h3>
     </body>
</html>

    	<div id="left">
    		<div>
    		
    		</div>
    		<div id="image">
    		<img src="image/hmj/hmj.jpg" style="width:150px;margin:20px">
    		</div>
    		<div id="myself_introducation">
    		<h4>博客简介</h4><br>
    		博主：逍幽 <br>
    		真名：黄茂俊<br>
    		专业：软件工程<br>
    		学校：江西财经大学<br>
    		座右铭：爱己助人
    		</div>
    		
    		<div id="wechat">
    		<h4>关注“逍幽人生”微信公众号</h4>
    		<img src="image/wechat.jpg" style="width:150px">
    		
    		</div>
    		
    	</div>
    	<div id="main_view">
            
    	</div>
    </div>
    


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'bottom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
    <div id="bottom">
    @2018.07~2020.07 <a href="#top">逍幽</a> all rights reserved 所有版权归逍幽所有
    </div>
  </body>
</html>

  </body>
</html>
