$(function addDocumentButton() {
    $("#add-btn").click(function () {
        window.location = "/web/adddocument";
    });
});

$(function deleteDocumentButton() {
    $("#del-btn").click(function () {
        window.location = "/web/deldocument";
    });
});

$(function toAllDocsButton() {
    $("#toalldocs-btn").click(function () {
        window.location = "/web/showAllDocs";
    });
});

$("document").ready(function () {
    $("a #edit-btn-grey").mouseenter(function () {
        $(this).attr('src', './images/edit-btn.png');
        $(this).parents("tr").css("color", "#b00a0a");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#b00a0a");
    });

    $("a #edit-btn-grey").mouseleave(function () {
        $(this).attr('src', './images/edit-btn-grey.png');
        $(this).parents("tr").css("color", "#333333");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#333333");
        
    });

    $("a #del-btn-grey").mouseenter(function () {
        $(this).attr('src', './images/del-btn.png');
        $(this).parents("tr").css("color", "#b00a0a");
        $(this).parents("tr").css("text-decoration", "line-through");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#b00a0a");
    });

    $("a #del-btn-grey").mouseleave(function () {
        $(this).attr('src', './images/del-btn-grey.png');
        $(this).parents("tr").css("color", "#333333");
        $(this).parents("tr").css("text-decoration", "inherit");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#333333");
    });
    
    
    $("a #usr-btn-grey").mouseenter(function () {
        $(this).attr('src', './images/usr-btn-green.png');
        $(this).parents("#table-row").css("color", "#38A843");
        $(this).parents("#table-row").css("font-weight", "bold");
        $(this).closest("tr").find("#not-pic").css("color", "#38A843");
    }); 

    $("a #usr-btn-grey").mouseleave(function () {
        $(this).attr('src', './images/usr-btn-grey.png');
        $(this).parents("#table-row").css("color", "#333333");
        $(this).parents("#table-row").css("font-weight", "normal");
        $(this).closest("tr").find("#not-pic").css("color", "#333333");
    });
    
    $("a #download-btn").mouseenter(function () {
        $(this).attr('src', './images/download-btn-green.png');
        $(this).parents("tr").css("color", "#138C00");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#138C00");
        $(this).closest("tr").find("#not-pic").css("color", "#138C00");
    });

    $("a #download-btn").mouseleave(function () {
        $(this).attr('src', './images/download-btn-grey.png');
        $(this).parents("tr").css("color", "#333333");
        $(this).parents("tr").children("td").children("a#not-pic").css("color", "#333333");
        $(this).closest("tr").find("#not-pic").css("color", "#333333");
    });
    
    $("#performers-table table td #not-pic").mouseenter(function () {
        $(this).closest("#table-row").find("a #usr-btn-grey").attr('src', './images/usr-btn-green.png');
        $(this).css("font-weight", "bold");
        $(this).css("color", "#38A843");
    });
    
    $("#performers-table table td #not-pic").mouseleave(function () {
        $(this).closest("#table-row").find("a #usr-btn-grey").attr('src', './images/usr-btn-grey.png');
        $(this).css("color", "#333333");
        $(this).css("font-weight", "normal");
    });
});

$(function addButtonHref() {
    $("#add-btn-alldocs-page").mouseenter(function () {
        $(this).children("a").css("color", "#b00a0a");
    });
    $("#add-btn-alldocs-page").mouseleave(function () {
        $(this).children("a").css("color", "#807e7e");
    });
    $("#add-btn-alldocs-page").click(function () {
        window.location = "/web/adddocument";
    });

});

$(function showAlldButtonHref() {
    $("#showall-btn-alldocs-page").mouseenter(function () {
        $(this).children("a").css("color", "#b00a0a");
    });
    $("#showall-btn-alldocs-page").mouseleave(function () {
        $(this).children("a").css("color", "#807e7e");
    });
    $("#showall-btn-alldocs-page").click(function () {
        window.location = "/web/showAllDocs";
    });

});
