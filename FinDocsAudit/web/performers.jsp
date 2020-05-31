<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menutabs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/html-table-search.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('table.search-table').tableSearch({
        });
    });
</script>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Исполнители</title>
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
            <div class="maincontent" id="maincontent-performers">
                <h1>
                    Исполнители<br />
                </h1>
                <h2>
                    В данном разделе содержится информация о конкретном исполнителе документа.<br /><br />
                    С целью выбора исполнителя воспользуйтесь соответствующей областью навигации,
                    расположенной справа на странице. С целью быстрого поиска конкретного исполнителя
                    данная область содержит поисковую строку.<br /><br />
                    Слева на странице расположена информация об исполнителе и документах, находящихся
                    у него на исполнении (имеющих статус "Принят к обработке").
                    Документы, имеющие иной статус, в данной таблице не отображаются.<br /><br />
                    В области страницы, расположенной ниже, отображена статистике по исполнителям,
                    отображающая информацию о количестве документов, находящихся на исполнении у кажого из работников,
                    а также количестве документов, у которых превышен контрольный срок.<br /><br />
                    <br /><br />
                </h2>
            </div>

            <div id="performers-form" class="left">
                <div id="performer-photo">
                    <img src="./images/performers/${currentPerformer.id}.jpg" onerror="this.onerror=null;this.src='./images/performers/default.png'">
                </div>
                <div id="performer-name">
                    <h3>${currentPerformer.name}</h3>
                </div>
                <div id="performer-post">
                    <h4>${currentPerformer.post}</h4>
                </div>
                <div id="performer-phone">
                    <h5>Тел: ${currentPerformer.phoneOut} / вн. ${currentPerformer.phoneIn}</h5>
                </div>
            </div>

            <div id="performers-table" class="right">
                <table id="table" class="sortable search-table ">
                    <thead>
                        <th colspan="2">Исполнители</th>
                    </thead>
                    <tbody>
                        <c:forEach var="performer" items="${allPerformers}">
                            <tr id="table-row" data-docId="${performer.id}">
                                <td><a id="not-pic" href="performers?performerid=${performer.id}">${performer.name}</a></td>
                                <td><a href="performers?performerid=${performer.id}"><img id="usr-btn-grey" src="./images/usr-btn-grey.png"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div id="performers-docs-table">
                <h3>Документы на исполнении</h3>
                <table id="table" class="sortable">
                    <thead>
                        <tr>
                            <th>Вх.№</th>
                            <th>Дата регистрации</th>
                            <th>Наименование документа</th>
                            <th>Контрольный срок</th>
                            <th colspan="3"></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="performerDoc" items="${performerDocs}">
                            <tr id="table-row" data-performerDocId="${performerDoc.id}">
                                <td>${performerDoc.input_number}</td>
                                <td>${performerDoc.reg_date}</td>
                                <td>${performerDoc.name}</td>
                                <td>${performerDoc.deadline}</td>
                                <td>
                                    <c:if test="${not empty performerDoc.file}">
                                        <a href="download?docid=${performerDoc.id}"><img id="download-btn" src="./images/download-btn-grey.png"></a>
                                    </c:if>
                                </td>
                                <td><a href="editdocument?docid=${performerDoc.id}"><img id="edit-btn-grey" src="./images/edit-btn-grey.png"></a></td>
                                <td><a href="deldocument?docid=${performerDoc.id}"><img id="del-btn-grey" src="./images/del-btn-grey.png"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div id="performers-stat-table">
                <h3>Статистика по исполнителям</h3>
                <table id="table" class="sortable">
                    <thead>
                        <tr>
                            <th>Исполнитель</th>
                            <th>Документов в обработке:</th>
                            <th>C нарушением сроков:</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="performerStat" items="${performersStat}">
                            <c:choose>
                                <c:when test="${performerStat.exp > 0}">
                                    <tr id="table-row" data-performerDocId="${performerStat.performer_id}" style="color: #B00A0A; font-weight: bold">
                                    <td><a href="performers?performerid=${performerStat.performer_id}" style="color: #B00A0A; font-weight: bold">${performerStat.performer}</a></td>
                                    <td>${performerStat.documents}</td>
                                    <td>${performerStat.exp}</td>
                                </c:when>    
                                <c:otherwise>
                                    <tr id="table-row" data-performerDocId="${performerStat.performer_id}">
                                    <td><a href="performers?performerid=${performerStat.performer_id}">${performerStat.performer}</a></td>
                                    <td>${performerStat.documents}</td>
                                    <td>${performerStat.exp}</td>
                                </c:otherwise>
                            </c:choose>
                                    
                                </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2019. Разработчик &minus; студентка  БГУИР <a href="mailto://admin@gmail.com">Моя почта</a>   Графические объекты &minus; <a href="http://flaticon.com">Flaticon.com</a></p>
            </div>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorttable.js"></script>
    </body>
</html>
