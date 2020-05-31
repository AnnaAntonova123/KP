$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "data/menutabs.xml",
        dataType: "xml",
        success: function (xml) {
            $(xml).find('tab').each(function () {
                if ((window.location.pathname) === $(this).find('link').text()) {
                    $("#menu").append(
                        '<li class="current" style="display: inline;"><a' + ' href="' + $(this).find('link').text() + '">'
                        + $(this).find('name').text() + "</a></li>");
                } else {
                    $("#menu").append(
                        '<li style="display: inline;"><a' + ' href="' + $(this).find('link').text() + '">'
                        + $(this).find('name').text() + "</a></li>");
                }
            });
        }
    });
});

/**/