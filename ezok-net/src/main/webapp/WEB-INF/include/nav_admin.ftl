<div class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><strong>管理平台</strong></a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li><a href="${context}/admin/admin_index.html"><strong>首页</strong></a></li>
            <li><a href="${context}/admin/admin_nav_auditList.html"><strong>申请信息审核</strong></a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    分类管理 <b class="caret"></b></a>
                <ul class="dropdown-menu">

                    <li>
                        <a href="${context}/admin/admin_cate_toAdd.html">添加分类</a>
                    </li>
                    <li>
                        <a href="${context}/admin/admin_cate_list.html"> 分类列表</a>
                    </li>

                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    导航信息管理 <b class="caret"></b></a>
                <ul class="dropdown-menu">

                    <li><a href="${context}/admin/admin_nav_search.html">导航信息搜索</a></li>
                    <li><a href="${context}/admin/admin_nav_articleList.html">导航文章ID列表</a></li>
                    <li><a href="${context}/admin/admin_nav_auditList.html">申请信息审核</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    网站管理 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${context}/admin/admin_nav_weekList.html">每周推荐管理</a></li>

                    <li><a href="${context}/admin/sitemap.html">SITEMAP管理</a></li>
                    <li><a href="${context}/admin/renewCate.html">刷新分类</a></li>

                </ul>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="${context}/admin/admin_out.html"> 退出</a></li>


        </ul>
    </div>
    <!-- /.nav-collapse -->
</div>
<!-- /.navbar -->