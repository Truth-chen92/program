//首页导航栏下拉框
for (let i = 0; i < 6; i++) {
    $(".dropdown-toggle" + i + ",.dropdown-menu" + i).hover(function () {
        $(".dropdown-menu" + i).stop().slideDown(300);
    }, function () {
        $(".dropdown-menu" + i).stop().slideUp(300);
    });
}