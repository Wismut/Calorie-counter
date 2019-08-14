<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
            <h3><fmt:message key="meals.title"/></h3>
            <c:set var="ajaxUrl" value="ajax/profile/meals/"/>
            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add Meal</a>
                <datatables:table id="datatable" data="${userMeals}" row="user" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">
                    <datatables:column title="Description" sortInitDirection="asc" property="description"/>
                    <datatables:column title="Datetime" property="dateTime"/>
                    <datatables:column title="Calories" property="calories"/>
                    <datatables:callback type="init" function="mealActionsHandler"/>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">User meal details:</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="item_id" name="id">

                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Description</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description"
                                   placeholder="description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="calories" class="control-label col-xs-3">Calories</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="calories" name="calories"
                                   placeholder="calories">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dateTime" class="control-label col-xs-3">DateTime</label>

                        <div class="col-xs-9">
                            <input type="datetime-local" class="form-control" id="dateTime" name="dateTime"
                                   placeholder="dateTime">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var ajaxUrl = 'ajax/profile/meals';
    $(function () {
        mealActionsHandler();
    });
</script>
</html>