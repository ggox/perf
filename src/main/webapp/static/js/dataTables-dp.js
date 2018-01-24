if (oTable == null) { // 仅第一次检索时初始化Datatable
	oTable = $('#list').DataTable(
			{
				// "sAjaxSource" : "sysRightRole/dataTable", // get地址
				"ajax" : {
					"url" : "sysRightRole/dataTable",
					"type" : "GET",
					"dataSrc" : "list"
				},
				"serverSide" : true, // 服务端处理(此处数据量少，采用客户端处理)
				"processing" : true, // 显示处理过程
				"paging" : true, // 是否分页
				"pagingType" : "full_numbers", // 除首页、上一页、下一页、末页四个按钮还有页数按钮
				"searching" : false, // 是否开始本地搜索
				"stateSave" : false, // 刷新时是否保存状态
				"autoWidth" : true, // 自动计算宽度
				// 配置列要显示的数据
				"columns" : [ {
					"data" : "roleCode",
					"bVisible" : false,
					"title" : "角色代码",
					"class" : "center"
				}, {
					"data" : "roleName",
					"title" : "角色名称",
					"class" : "center"
				}, {
					"data" : "roleDescribe",
					"title" : "角色描述",
					"class" : "center"
				}, {
					"data" : "roleTypeCode",
					"bVisible" : false,
					"title" : "角色类型代码",
					"class" : "center"
				}, {
					"data" : "createDate",
					"title" : "创建时间",
					"class" : "center"
				}, {
					"data" : "createAccount",
					"bVisible" : false,
					"title" : "创建账户",
					"class" : "center"
				}, {
					"data" : "useFlag",
					"title" : "是否可用",
					"class" : "center"
				}, {
					"data" : "displaySn",
					"title" : "显示序号",
					"class" : "center"
				}, {
					"data" : null,
					"title" : "操作",
					"class" : "center"
				} ],
				"columnDefs" : [
						{
							"searchable" : false,
							"orderable" : false,
							"targets" : [ 0. - 1 ]
						},
						{
							"targets" : 8,
							"render" : function(a, b, c, d) {
								var context = {
									func : [
											{
												"name" : "修改",
												"fn" : "edit(\'" + c.roleCode
														+ "\',\'" + c.roleName
														+ "\',\'"
														+ c.roleDescribe
														+ "\',\'"
														+ c.roleTypeCode
														+ "\',\'"
														+ c.createDate
														+ "\',\'"
														+ c.createAccount
														+ "\',\'" + c.useFlag
														+ "\',\'" + c.displaySn
														+ "\')",
												"type" : "primary"
											},
											{
												"name" : "删除",
												"fn" : "del(\'" + c.roleCode
														+ "\')",
												"type" : "danger"
											} ]
								};
								var html = template(context);
								return html;
							}
						} ],
				"language" : {
					"sUrl" : "vendors/datatables.cn/cn.txt"
				}
			});
}