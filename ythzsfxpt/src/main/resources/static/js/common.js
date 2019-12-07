$(function () {
  $('body')
  // 侧边栏收起时，点击侧边栏展开
  .on('click', '#nav:not(.active)', function () {
    $('#nav').addClass('active');
  })
  // 侧边栏展开时，点击收起按钮收起
  .on('click','#nav.active .nav-toggle', function () {
    $('#nav').removeClass('active');
  });

  $('.nav-main').niceScroll({
    cursorcolor:"#00d8ff",
    cursorwidth:"2px",
    background: "transparent",
    cursorborder:"none",
    cursorborderradius:0,
    autohidemode: "leave"
  });
});

// 弹出登录框
$("body").on("click", "#header .login-box span", function () {
    $("#login").fadeIn()
});
// 关闭登录框
$("body").on("click", "#login .login-cont .login-close", function () {
    $("#login").fadeOut()
})


/*时间转换		author zxp*/
function formatDate(data) {
    //判断数据是否为空
    if(data == null || data == ""){
        return "";
    }
    var time = new Date(data);
    var y = time.getFullYear();//年
    var m = time.getMonth() + 1;//月
    if(m >= 0 && m <= 9){
        m = "0" + m;
    }
    var d = time.getDate();//日
    if (d >= 0 && d <= 9){
        d = "0" + d;
    }
    var h = time.getHours();//时
    if (h >= 0 && h <= 9){
        h = "0" + h;
    }
    var mm = time.getMinutes();//分
    if (mm >= 0 && mm <= 9){
        mm = "0" + mm;
    }

    return (y + "-" + m + "-" + d + " " + h + ":" + mm);

}

/*时间转换		author zxp*/
function formatDateAll(data) {
    //判断数据是否为空
    if(data == null || data == ""){
        return "";
    }
    var time = new Date(data);
    var y = time.getFullYear();//年
    var m = time.getMonth() + 1;//月
    if(m >= 0 && m <= 9){
        m = "0" + m;
    }
    var d = time.getDate();//日
    if (d >= 0 && d <= 9){
        d = "0" + d;
    }
    var h = time.getHours();//时
    if (h >= 0 && h <= 9){
        h = "0" + h;
    }
    var mm = time.getMinutes();//分
    if (mm >= 0 && mm <= 9){
        mm = "0" + mm;
    }

    var ss = time.getSeconds();//秒
    if(ss >= 0 && ss <= 9){
        ss = "0" + ss;
    }

    return (y + "-" + m + "-" + d + " " + h + ":" + mm + ":" + ss);
}


