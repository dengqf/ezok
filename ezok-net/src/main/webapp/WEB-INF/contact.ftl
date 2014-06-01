<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>
    <div style="padding-bottom:6px">
       <span>当前位置: <a href="${context}/index.html" title="微信公共号平台导航">首页&nbsp;</a>&gt;&nbsp;联系我们
        </span>
        <hr style=" padding:1px; margin:6px;">
    </div>
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group">
                <a href="${context}/about.html" class="list-group-item">
                    关于我们
                </a>
                <a href="${context}/contact.html" class="list-group-item  active">
                    联系我们
                </a>
                <a href="${context}/copyright.html" class="list-group-item ">
                    版权声明
                </a>
            </div>
        </div>
        <div class="col-lg-9">
            <p><strong>客服QQ:</strong></p>
            <p><a id="thehref" href="tencent://message/?uin=2956932892&Site=fromalideyun&Menu=yes" title="${siteName}-微信公众号导航客服QQ">2956932892</a>&nbsp;|
                <a id="thehref1" href="tencent://message/?uin=2110047673&Site=fromalideyun&Menu=yes" title="${siteName}-微信公众号导航客服QQ">2110047673</a></p>
            <p><strong>客服邮箱:</strong></p>
            <p><a href="mailto:ezok@ezok.net" title="${siteName}-微信公众号导航客服邮箱">ezok@ezok.net</a></p>

        </div>
    </div>


<#include "include/footer.ftl"/>
</div>
<#include "include/seo.ftl"/>
</body>
</html>
