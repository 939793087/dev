$(function () {
		pageInit();
    });
function findBtn(){
	$('#editbyID').removeAttr('disabled','');
	pageInit();
}

var serviceData;
function pageInit(){
	var url = window.encodeURI('http://192.168.0.132:8082/cmsshop/listCMSShop?'+
    	    'company='+$('#company').val()+'&shopid='+$('#shopid').val()+'&createdate='+$('#createdate').val()+
    	    '&shopname='+$('#shopname').val()+'&shoptype='+$('#shoptype').val()+'&parentshopid='+$('#parentshopid').val()+
    	    '&topshopid='+$('#topshopid').val()+'&mobile='+$('#mobile').val());
//	jsondata={"company":$('#company').val(),
//			"shopid":$('#shopid').val(),
//			"createdate":$('#createdate').val(),
//			"shopname":$('#shopname').val(),
//			"shoptype":$('#shoptype').val(),
//			"parentshopid":$('#parentshopid').val(),
//			"topshopid":$('#topshopid').val(),
//			"mobile":$('#mobile').val()};
	$.ajax({
		type:'get',
		async:false,
		url:url,
//		data:JSON.stringify(jsondata),
		dataType:"jsonp",  //数据格式设置为jsonp
        jsonp:"callback",  //Jquery生成验证参数的名称
		contentType:"application/json;charset=utf-8",
		success : function(data){
			serviceData = data;
			finsishData();
		},
		error : function(data){
			serviceData = data;
		}
	});
	
	//创建jqGrid组件
//	setTimeout(function(){
//		$("#list2").jqGrid('clearGridData');  //清空表格
//		$("#list2").jqGrid('setGridParam',{  // 重新加载数据
//		      datatype:'local',
//		      data : serviceData,   //  newdata 是符合格式要求的需要重新加载的数据 
//		      page:1
//		}).trigger("reloadGrid");	
//		jQuery("#list2").jqGrid(
//				{
//					datatype:"local",
//					data:serviceData,
//					colNames : [ '公司', '店铺ID', '用户名', '创建时间', '店铺名称','店铺类型', '店铺父级ID', '店铺顶级ID', '联系电话'],//jqGrid的列显示名字
//					colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
//					             {name : 'company',index : 'company',width : 55}, 
//					             {name : 'shopid',index : 'shopid',width : 90}, 
//					             {name : 'userName',index : 'userName',width : 100}, 
//					             {name : 'createdate',index : 'createdate',width : 80,align : "right"}, 
//					             {name : 'shopname',index : 'shopname',width : 80,align : "right"}, 
//					             {name : 'shoptype',index : 'shoptype',width : 80,align : "right"}, 
//					             {name : 'parentshopid',index : 'parentshopid',width : 150,sortable : false},
//					             {name : 'topshopid',index : 'topshopid',width : 150,sortable : false},
//					             {name : 'mobile',index : 'mobile',width : 150,sortable : false}
//					           ],
//					
//					caption : "cms_shop表数据"//表格的标题名字
//				});
//	},100);
	
}


function finsishData(){
	$("#list2").jqGrid('clearGridData');  //清空表格
	$("#list2").jqGrid('setGridParam',{  // 重新加载数据
	      datatype:'local',
	      data : serviceData,   //  newdata 是符合格式要求的需要重新加载的数据 
	      page:1
	}).trigger("reloadGrid");	
	jQuery("#list2").jqGrid(
			{
				datatype:"local",
				data:serviceData,
				colNames : [ '公司', '店铺ID', '用户名', '创建时间', '店铺名称','店铺类型', '店铺父级ID', '店铺顶级ID', '联系电话'],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'company',index : 'company',width : 55}, 
				             {name : 'shopid',index : 'shopid',width : 90}, 
				             {name : 'userName',index : 'userName',width : 100}, 
				             {name : 'createdate',index : 'createdate',width : 80,align : "right"}, 
				             {name : 'shopname',index : 'shopname',width : 80,align : "right"}, 
				             {name : 'shoptype',index : 'shoptype',width : 80,align : "right"}, 
				             {name : 'parentshopid',index : 'parentshopid',width : 150,sortable : false},
				             {name : 'topshopid',index : 'topshopid',width : 150,sortable : false},
				             {name : 'mobile',index : 'mobile',width : 150,sortable : false}
				           ],
				
				caption : "cms_shop表数据"//表格的标题名字
			});
}


var shopid;
var id;
var shopidList;
var pitchOn = false;
function editBtn(){
	debugger;
	for(id=0;id<20;id++){
		if($('#'+id).hasClass('ui-state-highlight')){
			$("#list2").setColProp("parentshopid",{editable:true});
			$("#list2").editRow(id,true);
			shopidList=$('#'+id).find('td').eq(1).text()+":"+id;
			$('#editbyID').attr('disabled','true');
			pitchOn = true;
		}
	}
	if(false == pitchOn){
		alert('请选中一行数据修改!');
	}
}

function saveBtn(num){
	if(undefined == shopidList && 2!=num){
		alert('没有修改的数据，无需保存!');
		return;
	}
	if(2 == num){
		var parentshopid = $('#parentShopid').val();
		var shopid = $('#shpid').val();
	}else{
		arrays = shopidList.split(':')[1];
		shopid = shopidList.split(':')[0];
		var parentshopid = $('#'+arrays).find('td').find('input')[0].value;
	}
	$.ajax({
		type:'get',
		async:false,
		dataType:"jsonp",  //数据格式设置为jsonp
        jsonp:"callback",  //Jquery生成验证参数的名称
		url:'http://192.168.0.132:8082/cmsshop/updatebyID?'+'shopid='+shopid+'&parentshopid='+parentshopid+'&num='+num,
		success : function(data){
			alert('你修改了'+data+'条数据,shopid为'+shopid);
			location=location;
		},
		error : function(data){
			location=location;
		}
	});
}

/**
 * 修改下级
 */
var alertContent = '<div class="protocol">'+
						'<p>父级ID<input id="parentShopid" value="" type="text" /></p>' +
						'<p>门店ID<input id="shpid" value="" type="text" /></p><br/>'+
						'<p><input id="updateshopID" onclick="saveBtn(2)" value="修改" type="button" class="conterbtnStyle"/></p>'+
					'</div>';
function editButtomBtn(){
	var M={};
	M.dialog = jqueryAlert({
		'style'   : 'pc',
		'title'   : '修改下级',
		'content' :  alertContent,
		'modal'   : true,
		'contentTextAlign' : 'left',
		'width'   : '400',
		'height'  : '300',
		'animateType' : 'linear',
		'buttons' :{
			'关闭' : function(){
				M.dialog.close();
			},
		}
	})

	
}

//function mOver(obj){
//	$('#'+obj.id).attr('style','background-color:#ffffff;color:#85b5d9');
//}
//
//function mOut(obj){
//	$('#'+obj.id).attr('style','background-color:#85b5d9;color:#ffffff');
//}























