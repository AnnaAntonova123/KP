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
            <title>Редактирование документов</title>
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
            <div class="maincontent" id="maincontent-edit-doc">
                <h1>
                    Редактирование документов<br />
                </h1>
                <h2>
                    На данной странице производится редактирование информации о документе.<br /><br />
                    Все поля кроме полей "Файл" и "Описание" должны быть заполнены.<br /><br />
                    По окончанию редактирования необходимых полей нажмите на кнопку "Обновить документ",
                    расположенную справа.<br /><br />
                    Для добавления электронной версии документа, нажмите кнопку "Добавить" в поле "Файл",
                    затем выберите соответстввующий файл и нажмите на появившеюся кнопку "Загрузить файл".<br /><br />
                </h2>
            </div>
            <div id="button-group">
                <br /><div id="toalldocs-btn">Все документы</div>
                <br /><div id="add-btn">Новый документ</div>
                <br /><div id="del-btn">Удалить документ</div>
                <br /><div id="upd-btn">Обновить документ</div>
                <br /><div id="upload-btn">Загрузить файл</div>
            </div>
            <div id="document-info">
                <form method="get" id="upddocument" enctype="multipart/form-data" action="upddocument">
                    <div id="string-group">
                        <div id="label">Входящий номер: </div>
                        <input type="text" id="inputNumber" placeholder="Входящий номер" name="input_number" value="${currentDoc.inputNumber}">
                        <input type="hidden" id="docid" name="docid" value="${currentDoc.id}">
                        <input type="hidden" name="file" value="${currentDoc.file}">
                    </div>
                    <div id="string-group">
                        <div id="label">Дата регистрации: </div>
                        <input type="text" id="regDate" placeholder="Дата регистрации" name="reg_date" value="${currentDoc.regDate}">
                    </div>
                    <div id="string-group">
                        <div id="label">Наименование документа: </div>
                        <input type="text" id="docName" name="name" placeholder="Наименование документа" value="${currentDoc.name}">
                    </div>
                    <div id="string-group">
                        <div id="label">Тип документа: </div>
                        <select name="type">
                            <c:forEach var="type" items="${allTypes}">
                                <c:choose>
                                    <c:when test="${(type.getName()) == (currentDoc.getType().getName())}">
                                        <option selected value="${type.getId()}">${type.getName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${type.getId()}">${type.getName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select> 

                    </div>
                    <div id="string-group">
                        <div id="label">Инициатор: </div>
                        <select name="initiator" >
                            <c:forEach var="initiator" items="${allInitiators}">
                                <c:choose>
                                    <c:when test="${(initiator.getName()) == (currentDoc.getInitiator().getName())}">
                                        <option selected value="${initiator.getId()}">${initiator.getName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${initiator.getId()}">${initiator.getName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Статус: </div>
                        <select name="status">
                            <c:forEach var="status" items="${allStatuses}">
                                <c:choose>
                                    <c:when test="${(status.getName()) == (currentDoc.getStatus().getName())}">
                                        <option selected value="${status.getId()}">${status.getName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${status.getId()}">${status.getName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Срок выполнения: </div>
                        <input type="text" id="deadline" name="deadline" placeholder="Срок выполнения" value="${currentDoc.deadline}">
                    </div>
                    <div id="string-group">
                        <div id="label">Исполнитель: </div>
                        <select name="performer">
                            <c:forEach var="performer" items="${allPerformers}">
                                <c:choose>
                                    <c:when test="${(performer.getName()) == (currentDoc.getPerformer().getName())}">
                                        <option selected value="${performer.getId()}">${performer.getName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${performer.getId()}">${performer.getName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select> 
                    </div>
                    <div id="string-group">
                        <div id="label">Описание: </div>
                        <input type="text" id="docDesc" name="description" placeholder="Описание" value="${currentDoc.description}">
                    </div>
                    <div id="string-group">
                        <div id="label-1">Файл: </div>
                        <div id="docFile">${currentDoc.getFile()} </div>
                        <div id="label-2"></div>
                    </div>
                    <div id="string-group">

                    </div>
                </form>
                <div id="uploadForm">
                    <form method="POST" id="fileForUpload-form" action="upload?docid=${currentDoc.id}"
                          enctype="multipart/form-data">
                        <input type="file" name="file" id="fileForUpload" size="40" /><br />
                        <br /> <input type="submit"  value="Upload" />
                    </form>   
                </div>
                <div id="footer">
                <p>&copy; Copyright 2019. Разработчик &minus; студентка БГУИР <a href="mailto://admin@gmail.com">Моя почта</a>   Графические объекты &minus; <a href="http://flaticon.com">Flaticon.com</a></p>
            </div>
            </div>

            <script>
                $(function showDocFileLabel2() {
                    if ($("#docFile").text() !== " ") {
                        $("#label-2").append("<a href=\"download?docid=${currentDoc.id}\"> Скачать </a>");
                    } else {
                        $("#label-2").append("<a> Добавить </a>");
                    }
                });

                $(document).ready(function () {
                    if ($("#label-2 a").text() !== " Скачать ") {
                        $("#string-group #docFile").text("Файл документа отсутствует... ").css("color", "#b5b5b5");
                        $("#label-2").click(function () {
                            $("#fileForUpload").click();
                        });
                    }
                });
                
                           
                $("#fileForUpload").on('change', function (event, files, label) {
                    var file_name = this.value.replace(/\\/g, '/').replace(/.*\//, '');
                    if (file_name.length > 40) {
                        file_name = file_name.substring(0, 40) + '...';
                    }
                    $("#docFile").text(file_name);
                    if($("#docFile").text() !== 'Файл документа отсутствует... ' ) {
                        $("#upload-btn").show();
                    }
                    if($("#docFile").text().length === 0 ) {
                        $("#upload-btn").hide();
                        $("#string-group #docFile").text("Файл документа отсутствует... ").css("color", "#b5b5b5");
                    }            
                    
                });
                
                $(function uploadDocumentButton() {
                    $("#upload-btn").click(function () {
                        $("#fileForUpload-form").submit();
                    });
                });
                

                $(function updateDocumentButton() {
                    $("#upd-btn").click(function () {
                        $("#upddocument").submit();
                    });
                });
                
                $(function addDocumentButton() {
                     $("#add-btn").click(function () {
                        $.get( "adddocument");
                    });
                });
                
                $(function deleteDocumentButton() {
                    $("#del-btn").click(function () {
                        window.location = "/web/deldocument?docid=${currentDoc.id}";
                    });
                });
            </script>
    </body>
</html>