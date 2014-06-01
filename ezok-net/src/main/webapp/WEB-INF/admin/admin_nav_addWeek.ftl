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
        <div class="col-lg-12">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><a href="${context}/${navInfo.no}/info.html">${navInfo.name}</a>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href="${context}/${navInfo.no}/info.html">
                                <img src="http://img.ezok.net${navInfo.iconUrl!""}" alt="头像" width="120"
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
                                           href="${context}/${navInfo.no}/info.html">详情预览</a>
                                        <a class="btn btn-sm btn-primary"   href="${context}/admin/admin_nav_info.html?no=${navInfo.no}"
                                                target="_blank">资料修改</a>

                                    </div>
                                </div>
                            </div>
                        <#--<div class="row">-->

                        <#--</div>-->
                        </div>

                    </div>
                </div>

            </div>

            <form action="${context}/admin/nav_week_add.html">
                <div class="form-group">
                    <label class="control-label" for="reason">推荐原因</label>
                    <textarea class="form-control" rows="2" id="reason"
                              name="reason"><#if navWeek??>${navWeek.topReason!""}</#if></textarea>
                    <input type="hidden" name="no" value="${navInfo.no}">
                </div>
                <div class="form-group">
                    <span class="btn btn-default"
                          onclick="javascript:history.go(-1);">取消</span>
                <#if navWeek??>
                    <button type="submit" class="btn btn-primary">修改</button>
                <#else>
                    <button type="submit" class="btn btn-primary">新增</button>
                </#if>

                </div>
            </form>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>
</body>
</html>
