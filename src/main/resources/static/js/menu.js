$(function () {
	//表格分页
    $('#menuList').DataTable({
    	"scrollX"	  : true,
  		'paging'      : true,
  	    'lengthChange': true,
  	    'searching'   : true,
  	    'ordering'    : true,
  	    'info'        : true,
  	    'autoWidth'   : false,
  	  	"pagingType"  : "full_numbers",
  	  	"pageLength"  : 10
    });
    //提示框
    $("[data-toggle='tooltip']").tooltip();
    
    //添加一级菜单
    $("#addFirstMenu").click(function(){
    	reloadMenuModel("添加菜单","",0,"","","2","","");
    	reloadActionBtn(_ctx+"/menu/add","添加");
	  	$("#menuModal").modal("show");
    });
    
    //展开菜单
    $(".spreadSubm").click(function(){
    	var parentId = $(this).attr("data-id");
    	var text = $(this).find("font").text();
    	var el = $(this).parent().parent();
    	if("展开" == text){
    		$(this).find("font").text("折叠");
    		$.ajax({
				type:"POST",
		        url:_ctx+"/menu/getSubMenu",
		        data:{parent_id:parentId,time:new Date().getTime()},
		        dataType:"json",
		        cache:false,
		        success: function(data){
		       	 if("success" == data.status){
					showSubMeunList(data.data,el,parentId)
		       	 }else{
					alert(data.msg);
		       	 }
		        }
			})
    	}else{
    		$(this).find("font").text("展开");
    		$(".submenu"+parentId).remove();
    	}
    });
    
    $("#submitBtn").click(function(){
    	var menuId = $("input[name='menu_id']").val();
    	var actionUrl = $("input[name='actionurl']").val();
    	var parentId = $("input[name='parent_id']").val();
    	var menuName = $("input[name='menu_name']").val();
    	var menuUrl = $("input[name='menu_url']").val();
    	var menuType = $("[name='menu_type']").val();
    	var menuIcon = $("input[name='menu_icon']").val();
    	var menuOrder = $("input[name='menu_order']").val();
    	$.ajax({
    		type:"POST",
    		url:actionUrl,
    		data:{menu_id:menuId,parent_id:parentId,menu_name:menuName,menu_url:menuUrl,menu_type:menuType,menu_icon:menuIcon,sort_num:menuOrder},
    		dataType:"json",
    		cache:false,
    		success:function(data){
    			if(data.status == 'success'){
    				$("#menuModal").modal("hide");
    				//刷新
    				window.location.href=window.location.href;
    			}else{
    				alert(data.msg);
    			}
    		}
    	});
    	
    });
  })
  
  //添加子菜单
  function addMenu(parentId){
	  reloadMenuModel("添加菜单","",parentId,"","","2","","");
	  reloadActionBtn(_ctx+"/menu/add","添加");
	  $("#menuModal").modal("show");
  }
  
  //删除菜单
  function delMenu(menuId){
	  if(confirm("你确定要删除此菜单吗？")){
		  $.ajax({
			  type:"GET",		  
			  url:_ctx+"/menu/del/"+menuId,
			  data:{time:new Date()},
			  dataType:"json",
			  cache:false,
			  success:function(data){
				  if(data.status == "success"){
						window.location.href=window.location.href;
				  }else{
					  alert(data.msg);
				  }
			  }
		  });
	  }
  }
  //编辑菜单
  function editMenu(menuId){
	  $.ajax({
		  type:"GET",		  
		  url:_ctx+"/menu/query/"+menuId,
		  data:{time:new Date()},
		  dataType:"json",
		  cache:false,
		  success:function(data){
			  if(data.status == "success"){
				  var obj = data.data;
				  reloadMenuModel("编辑菜单",obj.menu_id,obj.parent_id,obj.menu_name,obj.menu_url,obj.menu_type,obj.menu_icon,obj.sort_num);
				  reloadActionBtn(_ctx+"/menu/edit","更新");
				  $("#menuModal").modal("show");
			  }else{
				  alert(data.msg);
			  }
		  }
	  });
  }
  
  /*
  	添加二级菜单
  */
  function showSubMeunList(data,el,parentId){
	  var subStr="";
	  for(var i=0;i<data.length;i++){
		  var submenu = data[i];
		  var menuType = "业务";
		  if(submenu.menu_TYPE == 1){
			  menuType = "系统"
		  }
		  var subm = "<tr class='submenu"+parentId+"'>"
			+"<td align='right'><i class='fa fa-angle-double-right'></i></td>"
			+"<td>"+submenu.menu_NAME+"</td>"
			+"<td>"+submenu.menu_URL+"</td>"
			+"<td>"+menuType+"</td>"
			+"<td>#</td>"
			+"<td>"+submenu.menu_ORDER+"</td>"
			+"<td><span class='btn btn-xs btn-info' onclick='editMenu("+submenu.menu_ID+")'><i class='fa fa-edit'></i> 修改</span> <span class='btn btn-xs btn-danger' onclick='delMenu("+submenu.menu_ID+")'><i class='fa fa-trash-o'></i> 删除</span></td>"
			+"</tr>"
		  subStr += subm;
	  }
	  el.after(subStr);
  }
  
  //加载模态框的内容
  function reloadMenuModel(title,menu_id,parent_id,menu_name,menu_url,menu_type,menu_icon,sort_num){
	$("#menuModal #menumodelHead").text(title);
	$("#menuModal input[name='menu_id']").val(menu_id);
	$("#menuModal input[name='parent_id']").val(parent_id);
  	$("#menuModal input[name='menu_name']").val(menu_name);
  	$("#menuModal input[name='menu_url']").val(menu_url);
  	$("#menuModal [name='menu_type']").val(menu_type);
  	$("#menuModal input[name='menu_icon']").val(menu_icon);
  	$("#menuModal input[name='menu_order']").val(sort_num);
  }
  function reloadActionBtn(actionUrl,btnText){
	  $("#menuModal input[name='actionurl']").val(actionUrl);
	  $("#submitBtn").text(btnText);
  }