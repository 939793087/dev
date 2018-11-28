(function($){
	validLogin = function(){
		var user=$('#userID').val(),
			password = $('#pwdID').val(),
			url = 'http://localhost:8082/user/islogin?user='+user+'&password='+password;
		if('' == user || '' == password){
			alert('请不要输入空的账号或者密码');
		}else{
			$.ajax({
				type:'get',
				async:false,
				url:url,
				success : function(data){
					debugger;
					alert('恭喜,登录成功');
				}
			});
		}
	}
})(jQuery);

//$(function(){
//	alert(2);
//});
//$(document).ready(function(){
//	alert(3);
//});