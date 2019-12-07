// 注销操作
$("#logout").click(function () {
    sessionStorage.clear();
    window.location.href = 'index.html';
})
$(function () {
    var username = sessionStorage.getItem("username");
    var user = sessionStorage.getItem("user");
    var menu = sessionStorage.getItem("array");
    var arr = eval(menu);

    var title = new Array();
    var link = new Array();
    // 如果用户退出或者是刚进入页面
    if (username == null) {

        $("#header .header-main").html("山东省济南市行政审批服务大厅");
        strs = "</ul>\n" +
            "    </div>\n" +
            "</div>"
        s1 = "<div class='nav-section'><div class='nav-title active'>政务服务</div>" +
            "<div class=\"nav-list\">" +
            "<ul>" + " <li class=\"\"><a href='egovIndex.html'><span>首页</span></a></li>\n" + strs;
        s2 = "<div class='nav-section'><div class='nav-title active'>共享交换</div>" +
            "<div class=\"nav-list\">" +
            "<ul>" + " <li class=\"\"><a href='shareIndex.html'><span>首页</span></a></li>\n" + strs;
        s3 = "<div class='nav-section'><div class='nav-title active'>大数据</div>" +
            "<div class=\"nav-list\">" +
            "<ul>" + " <li class=\"\"><a href='libIndex.html'><span>首页</span></a></li>\n" + strs;
        s4 = "<div class='nav-section'><div class='nav-title active'>实验室</div>" +
            "<div class=\"nav-list\">" +
            "<ul>" + " <li class=\"\"><a href='#'><span>实验室</span></a></li>\n" + strs;
        $(".nav-main #daohang").html(s1 + s2 + s3 + s4);
    }
    var currUrl = window.location.href;
    var ss;

    function getQueryString(name) {
        // console.log(name)
        var s1 = name.split('http://localhost:8081/ythzs/')[1];
        // console.log("s1=====" + s1)
        return s1;
    }

    // 获取浏览器的id
    var id = getQueryString(currUrl);
    // console.log("id====="+id)
    var str = "";
    // 当登录的账号是行政审批局的账号
    if (user == "6B4047653EDC45F38314CF0BE744D85D") {
        $("#name").html(username);
        $("#header .header-main").html("山东省济南市行政审批服务大厅");
        var strLists = '';
        var strs = '';
        var s1 = '';
        var s2 = '';
        var s3 = '';
        var s4 = '';
        var strgxjh = '';
        var strdsj = '';
        var strsys = '';
        for (var i = 0; i < arr.length; i++) {
            // console.log(arr[i].IS_LEAF);
            if (arr[i].IS_LEAF == 0) {
                title.push({
                    name: arr[i].NAME,
                    code: arr[i].ID
                })

            } else {
                link.push({
                    "url": arr[i].PATH,
                    "name": arr[i].NAME,
                    "code": arr[i].PARENT_CODE,
                })
            }
        }

        for (var j = 0; j < link.length; j++) {
            if (id == link[j].url){
                str = "active"
            }else{
                str = ""
            }
            if (link[j].code == 'E9A125AC86624A6A995DBC045146D1BA') {
                strLists += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'B9320CFFC2984A6680834818BDD89168') {
                strgxjh += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'AE4F3E1FE2DD40B19F06C70B3EBAABE1') {
                strdsj += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'F29EFF862A81499FB5D458787BABBA15') {
                strsys += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
        }
        for (var i = 0; i < title.length; i++) {
            strs = "</ul>\n" +
                "    </div>\n" +
                "</div>"
            s1 = "<div class='nav-section'><div class='nav-title active'>政务服务</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strLists + strs;
            s2 = "<div class='nav-section'><div class='nav-title active'>共享交换</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strgxjh + strs;
            s3 = "<div class='nav-section'><div class='nav-title active'>大数据</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strdsj + strs;
            s4 = "<div class='nav-section'><div class='nav-title active'>实验室</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strsys + strs;
        }
        $(".nav-main #daohang").html(s1 + s2 + s3 + s4);
    }

    // 当登录的账号是大数据局的账号
    if (user == "DBC5E826E0D44F23AE52EC1DF7D19543") {
        $("#name").html(username);
        $("#header .header-main").html("山东省济南市大数据统计分析监控预测平台");
        var strLists = '';
        var strs = '';
        var s1 = '';
        var s2 = '';
        var s3 = '';
        var s4 = '';
        var strgxjh = '';
        var strdsj = '';
        var strsys = '';
        for (var i = 0; i < arr.length; i++) {
            // console.log(arr[i].IS_LEAF);
            if (arr[i].IS_LEAF == 0) {
                title.push({
                    name: arr[i].NAME,
                    code: arr[i].ID
                })

            } else {
                link.push({
                    "url": arr[i].PATH,
                    "name": arr[i].NAME,
                    "code": arr[i].PARENT_CODE,
                })
            }
        }
        for (var j = 0; j < link.length; j++) {
            if (id == link[j].url){
                str = "active"
            }else{
                str = ""
            }
            if (link[j].code == 'E9A125AC86624A6A995DBC045146D1BA') {
                strLists += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'B9320CFFC2984A6680834818BDD89168') {
                strgxjh += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'AE4F3E1FE2DD40B19F06C70B3EBAABE1') {
                strdsj += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
            if (link[j].code == 'F29EFF862A81499FB5D458787BABBA15') {
                strsys += " <li class='" + str + "'><a href='" + link[j].url + "'><span>" + link[j].name + "</span></a></li>\n"
            }
        }
        for (var i = 0; i < title.length; i++) {
            strs = "</ul>\n" +
                "    </div>\n" +
                "</div>"
            s1 = "<div class='nav-section'><div class='nav-title active'>政务服务</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strLists + strs;
            s2 = "<div class='nav-section'><div class='nav-title active'>共享交换</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strgxjh + strs;
            s3 = "<div class='nav-section'><div class='nav-title active'>大数据</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strdsj + strs;
            s4 = "<div class='nav-section'><div class='nav-title active'>实验室</div>" +
                "<div class=\"nav-list\">" +
                "<ul>" + strsys + strs;
        }
        $(".nav-main #daohang").html(s1 + s2 + s3 + s4);
    }

})