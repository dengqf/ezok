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
            <table class="table table-bordered table-striped table-hover ">
                <thead>
                <tr>

                    <th>微信号</th>
                    <th>微信公众号</th>
                    <th>BIZ_ID</th>
                    <th>是否收藏</th>
                    <th>URL测试</th>

                </tr>
                </thead>
                <tbody>
                <#list vo.navRelArticleList as article>
                <tr>

                    <td>${article.weixinAccount!"error"}</td>
                    <td>${article.weixinName!"error"}</td>
                    <td>${article.bizId}</td>
                    <td>${article.isGrab}</td>
                    <td><a href="http://mp.weixin.qq.com/mp/appmsg/show?__biz=${article.bizId}&appmsgid=10000005&itemidx=1"></a></td>


                </tr>
                </#list>
                </tbody>
            </table>
        <#include "../include/page.ftl"/>
        </div>



    </div>
<#include "../include/footer.ftl"/>

</div>

</body>
</html>
