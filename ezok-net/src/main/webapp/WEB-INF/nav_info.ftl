<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>
    <div style="padding-bottom:6px">
       <span>当前位置: <a  itemprop="url" href="${context}/index.html" title=" ${siteName}-微信公共号导航网站">首页&nbsp;</a>&gt;
           <a  itemprop="url" href="${context}/${parentCate.no!""}/list.html" title=" ${parentCate.name!""}分类的微信公众号导航列表">
       ${parentCate.name!""}&nbsp;</a>&gt; <a  itemprop="url" href="${context}/${cateInfo.no}/list.html"
                                              title="${cateInfo.name!""}分类的微信公众号导航列表">${cateInfo.name}
           &nbsp;</a>&gt;&nbsp;${navInfo.name}
        </span>
        <hr style=" padding:1px; margin:6px;">
    </div>
    <div class="row">
        <div class="col-lg-9">
        <#--<div class="panel panel-default">-->
        <#--<div class="panel-heading">-->
        <#--<h3 class="panel-title"></h3>-->
        <#--</div>-->
            <div class="panel-body well">
                <span itemscope itemtype="http://schema.org/Article" itemref="_articleBody3">
                    <h1 id="_name7" itemprop="name" class="text-center"
                        style="font-size: 30px">${navInfo.name}</h1></span>
                <hr style=" padding:1px; margin:6px;">
            <#--<p class="lead text-center">${navInfo.name}</p>-->
            <#--<hr style=" padding:1px; margin:6px;">-->
                <div class="row">
                    <div class="col-lg-3">
                        <img itemprop="image" src="http://img.ezok.net${navInfo.iconUrl}" alt="${navInfo.name}微信公众号" width="150"
                             height="150">
                    </div>

                    <div class="col-lg-9">
                        <div class="row">
                            <div class="col-lg-6">
                            <#--<p>微信原始账号:${navInfo.weixinAccount!""}</p>-->
                                <p><img itemprop="image" src="${context}/img/wx_icon.jpg" width="18"
                                        height="18"
                                        alt="${navInfo.name}微信号">&nbsp;微信号:<em>${navInfo.weixinAccount!""}</em>
                                </p>

                                <p><img itemprop="image" src="${context}/img/wx_icon.jpg" width="18"
                                        height="18"
                                        alt="${navInfo.name}微信公众号">&nbsp;微信公众号:<em>${navInfo.weixinName!""}</em>
                                </p>

                            </div>
                            <div class="col-lg-6">

                                <p><img itemprop="image" src="${context}/img/yx_icon.jpg" width="18"
                                        height="18"
                                        alt="${navInfo.name}易信号"">&nbsp;易信号:<em>${navInfo.yixinAccount!""}</em>
                                </p>

                                <p><img itemprop="image" src="${context}/img/yx_icon.jpg" width="18"
                                        height="18"
                                        alt="${navInfo.name}易信公众号">&nbsp;易信公众号:<em>${navInfo.yixinName!""}</em>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <p>官网地址:<#if navInfo.url??><a  itemprop="url" href="${navInfo.url!"#"}" alt="${navInfo.name}的官网"
                                                               target="_blank"> ${navInfo.url!""}</a></#if>
                                </p>

                                <p>微博地址:<#if navInfo.weiboUrl??><a  itemprop="url" href="${navInfo.weiboUrl!"#"}"
                                                                    alt="${navInfo.name}的微博" target="_blank"> ${navInfo.weiboUrl!""}</a></#if></p>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <p>账号所属分类:${cateInfo.name!"其他"}</p>
                            </div>
                            <div class="col-lg-6">
                                <p>账号收录时间:<span itemprop="datePublished" content="${(navInfo.createDate!'')?string('yyyy-MM-dd')}">${(navInfo.createDate!'')?string('yyyy-MM-dd')}</span></p>
                            </div>
                        </div>
                    <#include "include/share.ftl"/>

                    </div>
                </div>
                <br>
                <h4>二维码</h4>
                <hr style=" padding:1px; margin:6px;">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="list-inline">
                            <li class="col-lg-6">

                                <img itemprop="image" src="http://img.ezok.net${navInfo.wxEwmUrl}" width="150" height="150"
                                     alt="${navInfo.name}微信公众号二维码">

                                <div class="caption">
                                    <h6>
                                        <img itemprop="image" src="${context}/img/wx_icon.jpg" width="18" height="18"
                                             alt="${navInfo.name}微信公众号二维码">&nbsp;微信扫一扫添加关注
                                    </h6>
                                </div>
                            </li>

                        <#if navInfo.yxEwmUrl??>

                            <li class="col-lg-6">
                                <img itemprop="image" src="http://img.ezok.net${navInfo.yxEwmUrl}" alt="${navInfo.name}易信公众号二维码"
                                     width="150"
                                     height="150">

                                <div class="caption">
                                    <h6>
                                        <img itemprop="image" src="${context}/img/yx_icon.jpg" width="18" height="18"
                                             alt="${navInfo.name}易信公众号二维码">&nbsp;易信扫一扫添加关注
                                    </h6>
                                </div>
                            </li>

                        </#if>
                        </ul>
                    </div>
                </div>

                <h4>账号介绍</h4>
                <hr style=" padding:1px; margin:6px;">
                <div class="row">
                    <div class="col-lg-12">
                        <p  id="_articleBody3" itemprop="articleBody">
                        ${navInfo.navDesc}
                        </p>
                        <br>

                        <p class="pull-right">
                            <span id="_author7" itemprop="author" itemscope itemtype="http://schema.org/Person"><small><em title="${siteName}-微信公共号导航" itemprop="name">--以上内容均来自互联网，如有问题，请与${siteName}客服联系</em></span></small>
                        </p>
                    </div>
                </div>

            </div>
        <#--</div>-->
        <#if likeList??>
            <div class="panel panel-default">
                <div class="panel-heading">猜你喜欢</div>
                <div class="panel-body">
                    <div class="row">
                    <#--首页推荐-->
                        <div class="col-lg-12">
                            <ul class="list-inline">
                                <#list likeList as obj>
                                    <li class="col-lg-2">
                                        <a  itemprop="url" href="${context}/${obj.no}/info.html" target="_blank"
                                           title="${obj.name}微信公众号">
                                            <img  itemprop="image" src="http://img.ezok.net${obj.iconUrl}" class="headImg"
                                                 alt="${obj.name}微信公众号">
                                        </a>

                                        <div class="caption">
                                            <p>${obj.name}</p>
                                        </div>

                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </#if>

        <#include "include/baidu_ad_02.ftl"/>

        </div>
        <div class="col-lg-3">
        <#include "include/ad.ftl"/>
        <#include "include/merchant.ftl"/>

        </div>
        <INPUT TYPE="HIDDEN" NAME="NAME" VALUE="${navInfo.name!"微信"}的微信公众号">
    </div>


<#include "include/footer.ftl"/>
</div>
<#include "include/seo.ftl"/>
<script>window._bd_share_config = {"common": {"bdSnsKey": {}, "bdText": "\"${navInfo.weixinName}\"的微信公众号,由${siteName}(www.ezok.net)为大家分享.", "bdMini": "2", "bdMiniList": false, "bdPic": "", "bdStyle": "0", "bdSize": "16"}, "share": {}, "image": {"viewList": ["weixin", "tsina", "tqq", "renren", "qzone"], "viewText": "分享到:", "viewSize": "16"}, "selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["weixin", "tsina", "tqq", "renren", "qzone"]}};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
</body>
</html>
