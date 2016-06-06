$(function(){
	$('#dg').datagrid({
		width:400,
		height:200,
		title:'用户列表',
		url:'testjson.json',
		columns:[[
		   {
			   field:'code',
			   title:'账号',
		   },
		   {
			   field:'name',
			   title:'邮箱',
		   },
		   {
			   field:'price',
			   title:'注册日期',
		   }
		]],
	});
	

});