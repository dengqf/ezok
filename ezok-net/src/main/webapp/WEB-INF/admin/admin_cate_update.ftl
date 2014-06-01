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
            <div class="well">
                <form action="${context}/admin/admin_cate_updateSubmit.html" id="form" class="form-horizontal">
                    <fieldset>
                        <legend>修改分类信息</legend>
                    <@m.inputText "名称" "" "name" cate.name "2 - 15 个字符，支持中英文、数字"/>

                        <div class="form-group">
                            <label for="priority" class="col-lg-2 control-label">选择优先级</label>

                            <div class="col-lg-10">
                                <select class="form-control" id="priority" name="priority">

                                    <option value="">--请选择--</option>
                                    <option value="1">默认</option>
                                    <option value="2">优先</option>
                                    <option value="3">推荐</option>
                                    <option value="4">广告</option>
                                    <option value="0">其他</option>

                                </select>
                                <span class="help-block">优先级会影响分类显示顺序</span>

                            </div>
                        </div>

                    <#if cate.parentNo!="0000">
                        <div class="form-group " id="cateParent">
                            <label for="parentNo" class="col-lg-2 control-label">选择父分类</label>

                            <div class="col-lg-10">
                                <select class="form-control" id="parentNo" name="parentNo">
                                    <option value="">--选择父分类--</option>
                                    <#list list as parent>
                                        <option value="${parent.no}">${parent.name}</option>
                                    </#list>
                                </select>
                            </div>

                        </div>
                        <span class="help-block">目前所属分类:${cate.structName}</span>
                    </#if>


                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <span class="btn btn-default"
                                      onclick="javascript:history.go(-1);">取消</span>
                                <button type="submit" class="btn btn-primary">提交</button>
                                <input type="hidden" name="no" value="${cate.no}"/>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>




<#include "../include/footer.ftl"/>
</div>
<#include "../include/seo.ftl"/>

<script>
    function selectLevel() {
        var p = document.getElementById("level");
        var idx = p.options[p.selectedIndex].value;
        if (idx == 2) {
            document.getElementById('cateParent').style.display = "";
        } else {
            document.getElementById('cateParent').style.display = "none";
        }

    }
</script>
</body>
</html>
