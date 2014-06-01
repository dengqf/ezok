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
            <form action="${context}/admin/admin_cate_audit.html" id="navForm">
                <table class="table table-bordered  table-hover ">
                    <caption>
                    <#--<span class="pull-right">共 ${pageUtil.count} 条 | 每页显示 ${pageUtil.pageSize}</span>-->
                    <#--<br>-->
                    <#--<br>-->
                    </caption>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>分类编号</th>
                        <th>分类名称</th>
                        <th>分类结构</th>
                        <th>分类结构名称</th>
                        <th>点击量</th>
                        <th>状态</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <#list list as vo>
                    <tr>
                        <td><input value="${vo.categoryInfo.no}" type="checkbox" name="no" class="text-center"></td>
                        <td>${vo.categoryInfo.no}</td>
                        <td>${vo.categoryInfo.name}</td>
                        <td>${vo.categoryInfo.struct}</td>
                        <td>${vo.categoryInfo.structName}</td>
                        <td>${vo.categoryInfo.clickSum}</td>
                        <td>
                            <@m.statusLabel vo.categoryInfo.status/>
                        </td>
                        <td>
                            <span class="btn btn-sm btn-link"><a
                                    href="${context}/admin/admin_cate_del.html?no=${vo.categoryInfo.no}">删除分类</a></span>
                            <span class="btn btn-sm btn-link"><a
                                    href="${context}/admin/admin_cate_update.html?no=${vo.categoryInfo.no}">修改分类</a></span>

                        </td>
                    </tr>
                        <#list vo.childList as child>
                        <tr class="danger">
                            <td><input value="${child.no}" type="checkbox" name="no" class="text-center"></td>
                            <td>${child.no}</td>
                            <td>${child.name}</td>
                            <td>${child.struct}</td>
                            <td>${child.structName}</td>
                            <td>${child.clickSum}</td>
                            <td>
                                <@m.statusLabel child.status/>
                            </td>
                            <td>
                                <span class="btn btn-sm btn-link"><a
                                        href="${context}/admin/admin_cate_del.html?no=${child.no}">删除分类</a></span>
                                <span class="btn btn-sm btn-link"><a
                                        href="${context}/admin/admin_cate_update.html?no=${child.no}">修改分类</a></span>

                            </td>
                        </tr>
                        </#list>
                    </#list>
                    </tbody>
                </table>
            <#--<div>-->
            <#--<label class="checkbox">-->
            <#--<input value="" type="checkbox" id="checkAll"> 全选-->
            <#--</label>-->
            <#--<button class="btn btn-sm btn-success" value="1" name="status">-->
            <#--批量通过-->
            <#--</button>-->
            <#--<button class="btn btn-sm btn-danger" value="-1" name="status">-->
            <#--批量禁止-->
            <#--</button>-->
            <#--</div>-->

            </form>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>
<script>
    $("#delCommodity").click(
            function () {
                alert($("#commodityForm").action);
            }
    );

    $("#checkAll").click(function () {

        $('input[type=checkbox]').prop('checked', $(this).prop('checked'));
    });

</script>
</body>
</html>
