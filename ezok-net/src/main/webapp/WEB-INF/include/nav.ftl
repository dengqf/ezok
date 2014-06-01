<div class="row">
    <div class="col-lg-12">
        <a href="${context}/index.html" title="${siteName}-微信公众号导航网站">
            <img src="${context}/img/logo_01.png" width="200" height="50" alt="${siteName}-微信公众号导航LOGO">
        </a>

        <div class="pull-right" style="padding-top: 15px;padding-left: 100px">

            <a href="${context}/user/nav_to_add.html" class="btn btn-danger btn-sm" title="微信公众号导航收录">申请收录</a>
            <a href="#" class="btn btn-success btn-sm" title="${siteName}-微信公众号导航"
               onclick="window.external.addFavorite(this.href,this.title);return false;"
               rel="sidebar">加入收藏夹</a>
        </div>

    </div>
</div>
<div class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><strong></strong></a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">


        <ul class="nav navbar-nav">
            <li class="dropdown">
            <#include "./allCate.ftl"/>
            </li>
            <li><a href="${context}/index.html">首页</a></li>
            <li id="cate_1034"><a href="${context}/1034/list.html" title="明星分类的微信公众号导航列表">明星</a></li>
            <li id="cate_1030"><a href="${context}/1030/list.html" title="笑话分类的微信公众号导航列表">笑话</a></li>
            <li id="cate_1005"><a href="${context}/1005/list.html" title="旅游分类的微信公众号导航列表">旅游</a></li>
            <li id="cate_1004"><a href="${context}/1004/list.html" title="时尚分类的微信公众号导航列表">购物</a></li>
            <li id="cate_1027"><a href="${context}/1027/list.html" title="户外分类的微信公众号导航列表">新闻</a></li>
            <li id="cate_1017"><a href="${context}/1017/list.html" title="养生分类的微信公众号导航列表">财经</a></li>
            <li id="cate_1067"><a href="${context}/1067/list.html" title="英语分类的微信公众号导航列表">体育</a></li>

            <li id="cate_1006"><a href="${context}/1006/list.html" title="美食分类的微信公众号导航列表">美食</a></li>
            <li id="cate_1098"><a href="${context}/1098/list.html" title="摄影分类的微信公众号导航列表">美图</a></li>

            <li id="cate_1031"><a href="${context}/1031/list.html" title="音乐分类的微信公众号导航列表">音乐</a></li>
            <li id="cate_1058"><a href="${context}/1058/list.html" title="读书分类的微信公众号导航列表">读书</a></li>
            <li id="cate_9999"><a href="${context}/1/nav_week_list.html" title="每周推荐">每周推荐</a></li>

        </ul>
    <#--<form class="navbar-form navbar-left">-->
    <#--<input class="form-control col-lg-8" placeholder="搜索" type="text">-->
    <#--</form>-->
        <ul class="nav navbar-nav navbar-right">
        <#if user??>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户中心<b class="caret"></b></a>
                <ul class="dropdown-menu">
                <#--<li><a href="${context}/user/user_index.html">用户首页</a></li>-->
                    <li><a href="${context}/user/user_nav_List.html" title="微信公众号导航收录">收录列表</a></li>
                    <li><a href="${context}/user/user_password.html">密码修改</a></li>

                    <li class="divider"></li>
                    <li><a href="${context}/user_logOut.html">退出</a></li>
                </ul>
            </li>
        <#else>
            <li id="nav_login"><a href="${context}/user/user_login.html">登录</a></li>
        </#if>
        </ul>

    </div>
    <!-- /.nav-collapse -->
</div>
<!-- /.navbar -->
