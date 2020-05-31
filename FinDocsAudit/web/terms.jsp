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
            <title>Сроки</title>
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
            <div class="maincontent" id="maincontent-terms">
                <h1>
                    Сроки<br />
                </h1>
                <h2>
                    В данном разделе содержится информация о сроках исполнения документов.<br /><br />
                    В таблице "Документы с превышением контрольного срока" содержится информация 
                    о документах с превышением контрольного срока и имеющих статус "Принят к обработке".<br /><br />
                    В таблице "Документы с истекающим сроком исполнения" содержится информация 
                    о документах, контрольный срок исполнения которых наступает в ближайшие 10 дней.<br /><br />
                    <br /><br />
                </h2>
            </div>

            <div class="alldocs">
                <div id="expired-docs">
                    <h4>Документы с превышением контрольного срока</h4>
                    <table id="table" class="sortable">
                        <thead>
                            <tr>
                                <th>Вх.№</th>
                                <th>Дата регистрации</th>
                                <th>Наименование документа</th>
                                <th>Инициатор</th>
                                <th>Контрольный срок</th>
                                <th>Исполнитель</th>
                                <th>Дней просрочено</th>
                                <th colspan="3"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="doc" items="${expiredDocuments}">
                                <tr id="table-row" data-docId="${doc.id}">
                                    <td>${doc.input_number}</td>
                                    <td>${doc.reg_date}</td>
                                    <td><a id="not-pic" href="editdocument?docid=${doc.id}">${doc.name}</a></td>
                                    <td>${doc.initiatorName}</td>
                                    <td>${doc.deadline}</td>
                                    <td>${doc.performerName}</td>
                                    <td>${doc.expDays}</td>
                                    <td>
                                        <c:if test="${not empty doc.file}">
                                            <a href="download?docid=${doc.id}"><img id="download-btn" src="./images/download-btn-grey.png"></a>
                                        </c:if>
                                    </td>
                                    <td><a href="editdocument?docid=${doc.id}"><img id="edit-btn-grey" src="./images/edit-btn-grey.png"></a></td>
                                    <td><a href="deldocument?docid=${doc.id}"><img id="del-btn-grey" src="./images/del-btn-grey.png"></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div id="not-expired-docs">
                    <h4>Документы с истекающим сроком исполнения (в ближайшие 10 дней)</h4>
                    <table id="table" class="sortable">
                        <thead>
                            <tr>
                                <th>Вх.№</th>
                                <th>Дата регистрации</th>
                                <th>Наименование документа</th>
                                <th>Инициатор</th>
                                <th>Контрольный срок</th>
                                <th>Исполнитель</th>
                                <th>Осталось дней</th>
                                <th colspan="3"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="docc" items="${expiringNextDaysDocuments}">
                                <tr id="table-row" data-docId="${docc.id}">
                                    <td>${docc.input_number}</td>
                                    <td>${docc.reg_date}</td>
                                    <td><a id="not-pic" href="editdocument?docid=${docc.id}">${docc.name}</a></td>
                                    <td>${docc.initiatorName}</td>
                                    <td>${docc.deadline}</td>
                                    <td>${docc.performerName}</td>
                                    <td>${docc.expDays}</td>
                                    <td>
                                        <c:if test="${not empty doc.file}">
                                            <a href="download?docid=${doc.id}"><img id="download-btn" src="./images/download-btn-grey.png"></a>
                                        </c:if>
                                    </td>
                                    <td><a href="editdocument?docid=${docc.id}"><img id="edit-btn-grey" src="./images/edit-btn-grey.png"></a></td>
                                    <td><a href="deldocument?docid=${docc.id}"><img id="del-btn-grey" src="./images/del-btn-grey.png"></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="footer">
                <p>&copy; Copyright 2019. Разработчик &minus; студентка  БГУИР <a href="mailto://admin@gmail.com">Моя почта</a>   Графические объекты &minus; <a href="http://flaticon.com">Flaticon.com</a></p>
            </div>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorttable.js"></script>
    </body>
</html>
