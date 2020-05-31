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
            <title>Все документы</title>
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
            <div class="maincontent" id="maincontent-alldocs">
                <h1>
                    Документы<br />
                </h1>
                <h2>
                    В данном разделе содержится информация о всех документах, которые поступают в структурный отдел организации.<br /><br />
                    Для поиска необходимого Вам документа необходимо воспользоваться поисковой строкой, которая расположена слева над
                    таблицей. При помощи данной поисковой строки можно найти практически любую информацию о документе, т.к.
                    поиск осущетслвяется по всем полям таблицы.<br /><br />
                    Для сортировки столбцов таблицы нажмите на соответствующий заголовок столбца.<br /><br />
                    Для скачивания электронной версии документа, а также его редактирования или удаления из базы данных
                    воспользуйтесь соответствующими пиктограммами, расположенными в конце каждой из строк таблицы<br /><br />
                    Для выборки документов по определенному свойству или с целью перехода на страницу конкретного исполнителя
                    нажмите на соответствующую ячейку таблицы.<br /><br />
                </h2>
            </div>

            <div class="alldocs">
                <div id="add-btn-alldocs-page"><a href="adddocument">Добавить документ</a></div>
                <div id="showall-btn-alldocs-page" style="margin-right: 20px;"><a href="showAllDocs">Все документы</a></div>
                <table id="table" class="sortable search-table">
                    <thead>
                        <tr>
                            <th>Вх.№</th>
                            <th>Дата регистрации</th>
                            <th>Наименование документа</th>
                            <th>Тип документа</th>
                            <th>Инициатор</th>
                            <th>Статус</th>
                            <th>Контрольный срок</th>
                            <th>Исполнитель</th>
                            <th colspan="3"></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="doc" items="${allDocuments}">
                            <tr id="table-row" data-docId="${doc.id}">
                                <td>${doc.inputNumber}</td>
                                <td>${doc.regDate}</td>
                                <td><a id="not-pic" href="editdocument?docid=${doc.id}">${doc.name}</a></td>
                                <td><a id="not-pic" href="showdocsbytype?typeid=${doc.getType().getId()}">${doc.getType().getName()}</a></td>
                                <td><a id="not-pic" href="showdocsbyinitiator?initiatorid=${doc.getInitiator().getId()}">${doc.getInitiator().getName()}</a></td>
                                <td><a id="not-pic" href="showdocsbystatus?statusid=${doc.getStatus().getId()}">${doc.getStatus().getName()}</td>
                                <td>${doc.deadline}</td>
                                <td><a id="not-pic" href="performers?performerid=${doc.getPerformer().getId()}">${doc.getPerformer().getName()}</a></td>
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
            <div id="footer">
                <p>&copy; Copyright 2019. Разработчик &minus; студентка  БГУИР <a href="mailto://admin@gmail.com">Моя почта</a>   Графические объекты &minus; <a href="http://flaticon.com">Flaticon.com</a></p>
            </div>
        </div>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorttable.js"></script>
    </body>
</html>
