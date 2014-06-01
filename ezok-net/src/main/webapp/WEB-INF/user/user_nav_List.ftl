<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>

</head>

<body>

<div class="container">
<#include "../include/nav.ftl"/>
    <!-- Example row of columns -->

    <div class="row">
        <div class="col-lg-12">
            <legend> 收录信息列表</legend>

        <#if (vo.navInfoList?size>0)>


            <#list vo.navInfoList as navInfo>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><a href="${context}/${navInfo.no}/info.html">${navInfo.name}</a>
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-2">
                                <a href="${context}/${navInfo.no}/info.html">
                                    <img src="http://img.ezok.net${navInfo.iconUrl!""}" alt="${navInfo.name}微信公众号头像" width="120"
                                         height="120">
                                </a>
                            </div>
                            <div class="col-lg-10">
                                <div class="row">
                                    <div class="col-lg-4">

                                        <p>名称:${navInfo.name!""}</p>

                                        <p>状态:<@m.statusLabel navInfo.status/> </p>
                                    </div>
                                    <div class="col-lg-4">
                                        <p>微信号:${navInfo.weixinAccount!""} </p>

                                        <p>微信公众号:${navInfo.weixinAccount!""}</p>
                                    </div>
                                    <div class="col-lg-4">
                                        <p>易信号:${navInfo.yixinAccount!""}</p>

                                        <p>易信公众号:${navInfo.yixinAccount!""}</p>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>账号简介:</p>

                                        <p>${navInfo.summary!""}</p>

                                        <div>
                                            <a class="btn btn-sm btn-primary"
                                               href="${context}/${navInfo.no}/info.html"  title="${navInfo.name}微信公众号预览">详情预览</a>
                                            <a class="btn btn-sm btn-primary"
                                               href="${context}/user/user_nav_info.html?no=${navInfo.no}"  title="${navInfo.name}微信公众号资料修改">资料修改</a>

                                        </div>
                                    </div>
                                </div>
                            <#--<div class="row">-->

                            <#--</div>-->
                            </div>

                        </div>
                    </div>
                </div>
            </#list>
            <#include "../include/page.ftl"/>
        <#else>
            <p>亲，还没有收录您的录入信息? 赶快添加一条吧！<a href="${context}/user/nav_to_add.html"> 申请收录 </a></p>
        </#if>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>

</body>
</html>
