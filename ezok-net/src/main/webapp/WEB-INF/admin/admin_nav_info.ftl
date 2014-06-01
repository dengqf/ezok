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
            <div class="row">
                <div class="col-lg-12">
                <#if error??>
                    <div class="alert alert-dismissable alert-warning">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>${error}</strong>
                    </div>
                </#if>
                    <div class="well">
                    <#--action="${context}/admin/admin_nav_update.html"-->
                        <@m.navInfoForm context+"/admin/admin_nav_update.html" />

                    </div>
                </div>
            </div>

        </div>

    </div>


<#include "../include/footer.ftl"/>
</div>
<#include "../include/cateSelect.ftl"/>
<script src="${context}/js/city.js"></script>
<script type="text/javascript">

    init();
    initCate();
</script>
</body>
</html>
