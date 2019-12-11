<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script>
	$(function()
	{
		
		/* // 找用户选择的级别 customer(值栈)
		alert("<s:property value="cust_level.dict_id"/>");
		// 找用户选择的来源 customer(值栈)
		alert("<s:property value="cust_source.dict_id"/>");
		// 找用户选择的行业 cuatomer(值栈)
		alert("<s:property value="cust_industry.dict_id"/>"); */

		$("#level option[value='<s:property value="cust_level.dict_id"/>']").prop("selected",true);
		$("#source option[value='<s:property value="cust_source.dict_id"/>']").prop("selected",true);
		$("#industry option[value='<s:property value="cust_industry.dict_id"/>']").prop("selected",true);

	})
	function del(id) {
		if (confirm("确定删除此用户")) {
			location.href="${pageContext.request.contextPath}/customer_delete.action?cust_id="+id;
		}
	}

</script>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:debug></s:debug>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customer_conditionFind.action"
		method=post>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														value="<s:property value="cust_name"/>"
														style="WIDTH: 80px" maxLength=50 name="cust_name"></TD>
													
													<TD>客户级别：</TD>
													<TD>
														<select id="level" name="cust_level.dict_id" style="WIDTH: 180px">
																<option value="-1">---请选择---</option>
															<s:iterator value="levelList" var="basedict">
																<option value="<s:property value="#basedict.dict_id"/>">
																	<s:property value="#basedict.dict_item_name"/>
																</option>
															</s:iterator>
														</select>
													</TD>
													
													<TD>客户来源：</TD>
													<TD>
														<select id="source" name="cust_source.dict_id" style="WIDTH: 180px">
																<option value="-1">---请选择---</option>
															<s:iterator value="sourceList" var="basedict">
																<option value="<s:property value="#basedict.dict_id"/>">
																	<s:property value="#basedict.dict_item_name"/>
																</option>
															</s:iterator>
														</select>
													</TD>
													
													<TD>客户所属行业：</TD>
													<TD>
														<select id="industry" name="cust_industry.dict_id" style="WIDTH: 180px">
																<option value="-1">---请选择---</option>
															<s:iterator value="industryList" var="basedict">
																<option value="<s:property value="#basedict.dict_id"/>">
																	<s:property value="#basedict.dict_item_name"/>
																</option>
															</s:iterator>
														</select>
													</TD>
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>客户行业</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
											<s:iterator value="customerList" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#customer.cust_name"/></TD>
													<TD><s:property value="#customer.cust_level.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_source.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_industry.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_phone"/></TD>
													<TD><s:property value="#customer.cust_mobile"/></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customer_editUI.action?cust_id=<s:property value="#customer.cust_id"/>">修改</a>
													&nbsp;&nbsp;
													<a href="#" onclick="del('<s:property value="#customer.cust_id"/>')">删除</a>
													</TD>
												</TR>
											</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>10</B>]条记录,[<B>1</B>]页
												
												[<A href="#">前一页</A>]
												<B>1</B>
												[<A href="#">后一页</A>] 
												
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
