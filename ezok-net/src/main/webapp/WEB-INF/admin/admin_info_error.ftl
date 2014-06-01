<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "../include/nav.ftl"/>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">错误信息</h3>
                </div>
                <div class="panel-body">
                    <p>${error}</p>
                    <span class="btn btn-warning pull-right"
                          onclick="javascript:history.go(-1);">返回</span>
                </div>
            </div>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>
<#include "../include/seo.ftl"/>
</body>
</html>
