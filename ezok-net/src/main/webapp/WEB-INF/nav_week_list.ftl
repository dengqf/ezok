<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>
    <div style="padding-bottom:6px">
       <span>当前位置: <a href="${context}/index.html" title="微信公共号平台导航">首页&nbsp;</a>&gt;<a
               href="${context}/1/nav_week_list.html" title=" 微信公众号每周推荐">&nbsp;每周推荐</a>
       <#if navInfo??>&nbsp;&gt;${navInfo.name}</#if>
        </span>
        <hr style=" padding:1px; margin:6px;">
    </div>
    <!-- 微信导航列表 -->
    <div class="row">
        <div class="col-lg-9">
        <#list vo.list as navInfo>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href="${context}/${navInfo.navNo}/info.html" title="${navInfo.name}的微信公众号">
                                <img src="http://img.ezok.net${navInfo.iconUrl!""}" alt="${navInfo.name}微信公众号头像" width="120"
                                     height="120">
                            </a>
                        </div>
                        <div class="col-lg-6">
                            <div class="row">

                                <div class="col-lg-12">
                                    <p><img src="${context}/img/wx_icon.png" width="18" height="18"
                                            alt="${navInfo.name}微信公众号导航">&nbsp;微信号:${navInfo.weixinAccount!""} </p>

                                    <p><img src="${context}/img/wx_icon.png" width="18" height="18"
                                            alt="${navInfo.name}微信公众号导航">&nbsp;公众号:${navInfo.weixinName!""}</p>

                                    <p>官网地址:<a href="${navInfo.url!"#"}" alt="${navInfo.name}的官网"
                                               target="_blank"> ${navInfo.url!""}</a>
                                    </p>

                                    <p>微博地址:<a href="${navInfo.weiboUrl!"#"}"
                                               alt="${navInfo.name}的微博" target="_blank"> ${navInfo.weiboUrl!""}</a>
                                    </p>
                                </div>


                            </div>

                           </div>
                        <div class="col-lg-2">
                            <a href="${context}/${navInfo.navNo}/info.html" title="${navInfo.name}的微信公众号二维码">
                                <img src="http://img.ezok.net${navInfo.wxEwmUrl!""}" alt="${navInfo.name}的微信公众号二维码" width="120"
                                     height="120">
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <hr>
                            <h4>推荐理由：</h4>

                            <p>${navInfo.topReason}</p>
                            <div class="pull-right">
                                <a class="btn btn-sm btn-primary"
                                   href="${context}/${navInfo.navNo}/info.html"
                                   title="${navInfo.name}的微信公众号信息">浏览详情</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </#list>
        <#if pageUtil??>
            <ul class="pagination">
                <#if pageUtil.pageNo==1>
                    <li class="prev disabled"><a href="#" title="${siteName}每周推荐上一页">上一页</a></li>
                <#else >
                    <li>
                        <a href="${context}/${pageUtil.pageNo-1}/nav_week_list.html" title="${siteName}每周推荐上一页">上一页</a>
                    </li>
                </#if>
                <#list pageUtil.viewMinNo..pageUtil.viewMaxNo as t>
                    <#if t==pageUtil.pageNo>
                        <li class="disabled"><a href="#" title="${siteName}每周推荐第${t}页"> ${t}</a></li>
                    <#else>
                        <li><a href="${context}/${t}/nav_week_list.html" title="${siteName}每周推荐第${t}页"> ${t}</a></li>
                    </#if>


                </#list>
                <#if pageUtil.pageNo==pageUtil.pageCount>
                    <li class="next disabled"><a href="#" title="${siteName}每周推荐下一页" >下一页</a></li>
                <#else >
                    <li class="next"><a
                            href="${context}/${pageUtil.pageNo+1}/nav_week_list.html" title="${siteName}每周推荐下一页">下一页</a>
                    </li>
                </#if>

                <li><a href="#" title="${siteName}每周推荐分页信息">共 ${pageUtil.count} 条 每页显示 ${pageUtil.pageSize}</a></li>
            </ul>
        </#if>

        </div>
        <div class="col-lg-3">
        <#include "include/ad.ftl"/>
              <#include "include/merchant.ftl"/>
        </div>
    </div>



<#include "include/footer.ftl"/>
</div>
<script>
    <#if no??>
    document.getElementById("cate_${no}").className = "active";
    </#if>
</script>
<#include "include/seo.ftl"/>
</body>
</html>
