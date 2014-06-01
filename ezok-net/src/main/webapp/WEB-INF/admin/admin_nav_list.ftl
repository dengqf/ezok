<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>

</head>

<body>

<div class="container">
<#include "../include/nav_admin.ftl"/>
    <!-- Example row of columns -->
    <form action="${context}/admin/admin_nav_audit.html" id="navForm" method="post">
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-bordered table-striped table-hover ">
                    <caption>
                    <#--<span class="pull-right">共 ${pageUtil.count} 条 | 每页显示 ${pageUtil.pageSize}</span>-->
                    <#--<br>-->
                    <#--<br>-->
                    </caption>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>名称</th>
                        <th>微信号</th>
                        <th>微信名称</th>
                        <#--<th>易信号</th>-->
                        <#--<th>易信名称</th>-->
                        <th>权重</th>
                        <th>点击量</th>
                        <th>收录人</th>
                        <th>分类</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list vo.navInfoList as nav>
                    <tr>
                        <td><input value="${nav.no}" type="checkbox" name="no" class="text-center"></td>
                        <td>${nav.name!"error"}</td>
                        <td>${nav.weixinAccount!"error"}</td>
                        <td>${nav.weixinName!"error"}</td>
                        <#--<td>${nav.yixinAccount!""}</td>-->
                        <#--<td>${nav.yixinName!""}</td>-->
                        <td>${nav.priority}</td>
                        <td>${nav.clickSum}</td>
                        <td>${nav.username!"admin"}</td>
                        <td>${nav.categoryName}</td>
                        <td>
                            <@m.statusLabel nav.status/>
                        </td>
                        <td>
                            <span class="btn btn-sm btn-link"><a
                                    href="${context}/admin/admin_nav_info.html?no=${nav.no}"
                                    target="_blank">修改</a></span>
                            <span class="btn btn-sm btn-link"><a href="${context}/${nav.no}/info.html"
                                                                 target="_blank">预览</a></span>
                             <span class="btn btn-sm btn-link"><a href="${context}/admin/nav_week_toAdd.html?no=${nav.no}" >每周推荐</a></span>
                             <span class="btn btn-sm btn-link"><a href="${context}/admin/admin_nav_article.html?no=${nav.no}" >文章更新</a></span>
                        </td>

                    </tr>
                    </#list>
                    </tbody>
                </table>
            <#include "../include/page.ftl"/>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label for="parentCate" class="col-lg-2 control-label">修改分类</label>

                        <div class="col-lg-4">
                            <select id="parentCate" name="parentNo" onchange="selectCate()"
                                    class="form-control"></select>

                        </div>
                        <div class="col-lg-4">
                            <select id="childCate" name="categoryNo" class="form-control"></select>
                        </div>
                    </div>

                </div>
            </div>
            <br>

            <div class="row">
                <div class="col-lg-12">
                    <label for="priority" class="col-lg-2 control-label">选择优先级</label>

                    <div class="col-lg-4">
                        <select class="form-control" id="priority" name="priority">

                            <option value="">-选择-</option>
                            <option value="-1">初始化</option>
                            <option value="1000">优先</option>
                            <option value="9999">推荐</option>
                        </select>
                        <span class="help-block">优先级会影响分类显示顺序</span>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <input value="" type="checkbox" id="checkAll"> 全选
                    <button class="btn btn-sm btn-success" value="1" name="status">
                        批量通过
                    </button>
                    <button class="btn btn-sm btn-danger" value="-1" name="status">
                        批量禁止
                    </button>

                    <button class="btn btn-sm btn-danger" value="9" name="status">
                        批量导数
                    </button>
                </div>
            </div>


        </div>
</div>

</form>
<#include "../include/footer.ftl"/>
<#include "../include/cateSelect.ftl"/>
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

    initCate();

</script>

</body>
</html>
