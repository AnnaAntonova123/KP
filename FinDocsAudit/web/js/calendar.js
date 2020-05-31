$(function showRegDateCalendar() {
    $("#regDate").datepicker({
        dateFormat: "yy-mm-dd",
        firstDay: 1
    });
});

$(function showDeadlineCalendar() {
    $("#deadline").datepicker({
        dateFormat: "yy-mm-dd",
        firstDay: 1
    });
});