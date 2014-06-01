<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "../include/nav_admin.ftl"/>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">信息提示:</h3>


                </div>
                <div class="panel-body">

                    <p>${success!""}</p>

                    <p class="pull-right">
                        <button class="btn  btn-success"
                                onclick="window.location=('${context}/admin/admin_index.html')">
                            返回首页
                        </button>
                    </p>
                </div>

            </div>

        </div>

    </div>


<#include "../include/footer.ftl"/>
</div>
<#include "../include/seo.ftl"/>
</body>
</html>
