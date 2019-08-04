<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<dandelion:bundle includes="topjavaDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="users.title"/></h3>

            <c:set var="ajaxUrl" value="ajax/admin/users/"/>
            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add User</a>

                <datatables:table id="datatable" url="${ajaxUrl}" row="user" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="Name" sortInitDirection="asc" property="name"/>
                    <datatables:column title="Email" property="email" renderFunction="renderEmail"/>
                    <datatables:column title="Roles" property="roles"/>
                    <datatables:column title="Active" filterable="false" property="enabled"
                                       renderFunction="renderCheckbox"/>
                    <datatables:column title="Registered" filterable="false" property="registered"
                                       renderFunction="renderDate"/>
                    <datatables:column sortable="false" renderFunction="renderUpdateBtn"/>
                    <datatables:column sortable="false" renderFunction="renderDeleteBtn"/>

                    <datatables:callback type="init" function="makeEditable"/>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>
