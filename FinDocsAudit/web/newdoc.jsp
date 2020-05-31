<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker-ru.js"></script>
<link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menutabs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
            <title>Добавление документов</title>
    </head>
    <body>
        <div id="content">
            <div id="top">
                <div id="logo">
                    <h1><a href="index.jsp">Документация производственного отдела</a></h1>
                </div>
            </div>
            <ul id="menu"></ul>
            <div class="line"></div>
            <div class="maincontent" id="maincontent-new-doc">
                <h1>
                    Добавление документов<br />
                </h1>
                <h2>
                    На данной странице производится добавление информации о документе.<br /><br />
                    Обязательными к заполнению являются все поля кроме поля "Описание".<br /><br />
                    После заполнения необходимых полей нажмите на кнопку "Сохранить документ",
                    расположенную справа.<br /><br />
                </h2>
            </div>
            <div id="button-group">
                <br /><div id="toalldocs-btn">Все документы</div>
                <br /><div id="upd-btn">Сохранить документ</div>
            </div>
            <div id="document-info">
                <form method="POST" id="upddocument" action="adddocument">
                    <div id="string-group">
                        <div id="label">Входящий номер: </div>
                        <input type="text" id="inputNumber" placeholder="Входящий номер" name="input_number" value="${newDoc.inputNumber}">
                    </div>
                    <div id="string-group">
                        <div id="label">Дата регистрации: </div>
                        <input type="text" id="regDate" placeholder="Дата регистрации" name="reg_date" value="${newDoc.regDate}">
                    </div>
                    <div id="string-group">
                        <div id="label">Наименование документа: </div>
                        <input type="text" id="docName" name="name" placeholder="Наименование документа" value="${newDoc.name}">
                    </div>

                    <div id="string-group">
                        <div id="label">Тип документа: </div>
                        <select name="type">
                            <option value="" disabled selected>Выберите тип документа...</option>
                            <c:forEach var="type" items="${allTypes}">
                                <option value="${type.getId()}">${type.getName()}</option>
                            </c:forEach>
                        </select> 

                    </div>
                    <div id="string-group">
                        <div id="label">Инициатор: </div>
                        <select name="initiator" >
                            <option value="" disabled selected data-default>Выберите инициатора документа...</option>
                            <c:forEach var="initiator" items="${allInitiators}">
                                <option value="${initiator.getId()}">${initiator.getName()}</option>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Статус: </div>
                        <select name="status">
                            <option value="" disabled selected>Выберите статус документа...</option>
                            <c:forEach var="status" items="${allStatuses}">
                                <option value="${status.getId()}">${status.getName()}</option>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Срок выполнения: </div>
                        <input type="text" id="deadline" name="deadline" placeholder="Срок выполнения" value="${newDoc.deadline}">
                    </div>
                    <div id="string-group">
                        <div id="label">Исполнитель: </div>
                        <select name="performer">
                            <option value="" disabled selected>Выберите исполнителя документа...</option>
                            <c:forEach var="performer" items="${allPerformers}">
                                <option value="${performer.getId()}">${performer.getName()}</option>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Описание: </div>
                        <input type="text" id="docDesc" name="desc" placeholder="Описание" value="${newDoc.getDescription()}">
                    </div>
                </form>

                <div id="footer">
                <p>&copy; Copyright 2019. Разработчик &minus; студентка  БГУИР <a href="mailto://admin@gmail.com">Моя почта</a>   Графические объекты &minus; <a href="http://flaticon.com">Flaticon.com</a></p>
            </div>
            </div>

            <script>
                $(function updateDocumentButton() {
                    $("#upd-btn").click(function () {
                        $("#upddocument").submit();
                    });
                });
            </script>
    </body>
</html>