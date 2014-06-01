<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>
<#--面包屑导航-->
    <div style="padding-bottom:6px">
       <span>当前位置: <a href="${context}/index.html" title="${siteName}-微信公共号导航网站">首页&nbsp;</a>&gt;
       <#if parent??>
           <a href="${context}/${parent.no!""}/list.html" title=" ${parent.name!""}分类的微信公众号导航列表">${parent.name!""}
               &nbsp;</a>&gt;
       </#if>
       <#if cate??>
           <a href="${context}/${cate.no!""}/list.html" title=" ${cate.name!""}分类的微信公众号导航列表">${cate.name!""}&nbsp;</a>
       </#if>
       </span>
        <hr style=" padding:1px; margin:6px;">
    </div>
<#--面包屑导航-->
    <!-- 微信导航列表 -->
    <div class="row">
        <div class="col-lg-9">
        <#list vo.navInfoList as navInfo>
            <div itemscope itemtype="http://schema.org/Article" class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><a href="${context}/${navInfo.no}/info.html"
                                               title="${navInfo.name}微信公众号"><span itemprop="name">${navInfo.name}</span></a>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-2">
                            <a itemprop="url" href="${context}/${navInfo.no}/info.html" title="${navInfo.name}微信公众号">
                                <img itemprop="image" src="http://img.ezok.net${navInfo.iconUrl!""}"
                                     alt="${navInfo.name!""}微信公众号"
                                     width="80" height="80">
                            </a>
                        </div>
                        <div class="col-lg-10">
                            <p itemprop="articleBody">
                            ${navInfo.summary!""}
                            </p>

                            <div>

                                <a itemprop="url" class="btn btn-sm btn-primary"
                                   href="${context}/${navInfo.no}/info.html"
                                   title="${navInfo.name}微信公众号详情">浏览详情</a>
                                <a itemprop="url" href="${context}/${navInfo.no}/info.html"
                                   title="${navInfo.name}微信公众号二维码"
                                   class="btn btn-sm btn-primary">微信二维码</a>
                            <#--<a href="${navInfo.weiboUrl!""}" class="btn btn-sm btn-success" target="_blank">官方微博</a>-->

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </#list>

        <#if pageUtil??>
            <ul class="pagination">
                <#if pageUtil.pageNo==1>
                    <li class="prev disabled"><a href="#" title="${siteName}微信公众号列表上一页">上一页</a></li>
                <#else >
                    <li>
                        <a href="${context}/${no}/${pageUtil.pageNo-1}/list.html"
                           title="${siteName}微信公众号列表上一页">上一页</a>
                    </li>
                </#if>
                <#list pageUtil.viewMinNo..pageUtil.viewMaxNo as t>
                    <#if t==pageUtil.pageNo>
                        <li class="disabled"><a href="#" title="${siteName}微信公众号列表第${t}页"> ${t}</a></li>
                    <#else>
                        <li><a href="${context}/${no}/${t}/list.html"
                               title="${siteName}微信公众号列表第${t}页"> ${t}</a></li>
                    </#if>


                </#list>
                <#if pageUtil.pageNo==pageUtil.pageCount>
                    <li class="next disabled"><a href="#" title="${siteName}微信公众号列表下一页">下一页</a></li>
                <#else >
                    <li class="next"><a
                            href="${context}/${no}/${pageUtil.pageNo+1}/list.html"
                            title="${siteName}微信公众号列表下一页">下一页</a>
                    </li>
                </#if>

                <li><a href="#" title="${siteName}微信公众号列表信息">共 ${pageUtil.count} 条 每页显示 ${pageUtil.pageSize}</a></li>
            </ul>
        </#if>

        </div>
        <div class="col-lg-3">
        <#include "include/ad.ftl"/>
        <#include "include/baidu_ad_01.ftl"/>
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
