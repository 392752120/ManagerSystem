	$(function(){
		$("#tt").datagrid({
			title:"用户信息",
			width:400,
			height:"auto",
	        url:"http://localhost:8080/Test01/user/datagrid", 
	        idField:"fldId",
	        rownumbers:true,
	        pagination:true,
	        columns:[[     
	            {field:"name",title:"Name",width:100},     
	            {field:"age",title:"Age",width:100},     
	            {field:"sex",title:"Sex",width:100,align:"right"}     
	        ]]     
		}); 
		
		var p = $("#tt").datagrid("getPager");
		$(p).pagination({
			pageSize:10,
			pageList:[5,10,15],
			beforePageText:"第",
			afterPageText:"页           ",
			displayMsg:"当前显示{from} - {to} 条记录     ",
			
		});
	});	