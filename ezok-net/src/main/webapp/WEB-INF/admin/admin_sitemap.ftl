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
            <div>
                <form class="form-inline" action="${context}/admin/createSitemap.html">
                    <select class="input-small span2" name="searchDateType">
                        <option value="start">起始时间</option>
                        <option value="end">终止时间</option>

                    </select>

                    <label>开始时间：</label>
                    <input id="d1" type="text" name="start" value="${startDate!"2014-01-01"}"
                           onClick="WdatePicker()" class="span2 uneditable-input"/>
                    <label>结束时间：</label>
                    <input id="d2" type="text" name="end" value="${endDate!"2014-12-01"}"
                           onClick="WdatePicker()" class="span2 uneditable-input"/>

                    <button type="submit" class="btn btn-default btn-sm">生成</button>

                    <br>
                    <br>
                </form>
            </div>

        </div>

    </div>


<#include "../include/footer.ftl"/>
</div>

<script language="javascript" type="text/javascript" src="${context}/js/My97DatePicker/WdatePicker.js"></script>
</body>
</html>
