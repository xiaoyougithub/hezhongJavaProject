var userName;
		var password;
		
		function toRegister(){
			window.location="register.html";
		}
		
		function login(){
			userName=document.getElementById("userName").value;
			password=document.getElementById("password").value;
			if(userName==""){
				alert("用户名不为空");
			}else if(password==""){
				alert("密码不为空");
			}else{
				var xhr=new XMLHttpRequest();
				var url="http://192.168.1.106:8080/DQQ/login.jsp";
				xhr.open("POST",url,true);
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset-UTF-8");
				xhr.onreadystatechange=function(){
					if(xhr.status==200&&xhr.readyState==4){
						if(xhr.responseText.length>=20){
							alert("登录失败，注意账号和密码是否输入错误");
						}else{
							alert(userName+"登录成功");
							document.cookie="userName="+escape(userName);
							window.location="dqq.html";
						}
					}
				}
				xhr.send("userName="+userName+"&password="+password);	
			
			}
		}
