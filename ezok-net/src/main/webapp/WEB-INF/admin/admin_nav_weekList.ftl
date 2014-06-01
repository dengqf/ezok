<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>

</head>

<body>

<div class="container">
<#include "../include/nav_admin.ftl"/>
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-9">
        <#if (vo.list?size>0)>


            <#list vo.list as navInfo>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><a href="${context}/${navInfo.navNo}/info.html">${navInfo.name}</a>
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-2">
                                <a href="${context}/${navInfo.navNo}/info.html">
                                    <img src="http://img.ezok.net${navInfo.iconUrl!""}" alt="头像" width="120"
                                         height="120">
                                </a>
                            </div>
                            <div class="col-lg-8">
                                <div class="row">

                                    <div class="col-lg-6">
                                        <p><img src="${context}/img/wx_icon.png" width="18" height="18"
                                                alt="${navInfo.name}微信公众号导航">&nbsp;微信号:${navInfo.weixinAccount!""} </p>

                                        <p><img src="${context}/img/wx_icon.png" width="18" height="18"
                                                alt="${navInfo.name}微信公众号导航">&nbsp;微信公众号:${navInfo.weixinAccount!""}</p>
                                    </div>
                                    <div class="col-lg-6">
                                        <p><img src="${context}/img/yx_icon.png" width="18" height="18"
                                                alt="${navInfo.name}易信公众号导航"">&nbsp;易信号:${navInfo.yixinAccount!""}</p>

                                        <p><img src="${context}/img/yx_icon.png" width="18" height="18"
                                                alt="${navInfo.name}易信公众号导航"">&nbsp;易信公众号:${navInfo.yixinAccount!""}</p>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>官网地址:<a href="${navInfo.url!"#"}" alt="${navInfo.name}的官网" target="_blank"> ${navInfo.url!""}</a>
                                        </p>

                                        <p>微博地址:<a href="${navInfo.weiboUrl!"#"}"
                                                     alt="${navInfo.name}的微博" target="_blank"> ${navInfo.weiboUrl!""}</a></p>

                                    </div>
                                </div>

                            </div>
                            <div class="col-lg-2">
                                <a href="${context}/${navInfo.navNo}/info.html">
                                    <img src="http://img.ezok.net${navInfo.wxEwmUrl!""}" alt="二维码" width="120"
                                         height="120">
                                </a>
                            </div>
                        </div>
                       </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><a href="${context}/${navInfo.navNo}/info.html">账号介绍</a>
                        </h3>
                    </div>
                    <div class="panel-body">
                       ${navInfo.navDesc}
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">推荐理由 </h3>
                    </div>
                    <div class="panel-body">
                    ${navInfo.topReason}
                    </div>
                </div>
                <div>
                    <span class="btn btn-sm btn-link"><a href="${context}/admin/nav_week_toAdd.html?no=${navInfo.navNo}" >修改推荐理由</a></span>
                </div>
            </#list>
            <#include "../include/page.ftl"/>
        <#else>
            <p>亲，还没有收录您的录入信息? 赶快添加一条吧！</p>
        </#if>
        </div>
        <div class="col-lg-3">
        <#include "../include/ad.ftl"/>
        </div>
    </div>
</div>


<#include "../include/footer.ftl"/>


</body>
</html>
