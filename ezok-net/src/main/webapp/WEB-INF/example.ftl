<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>


    <div class="row">
        <div class="col-lg-12">
            <div class="panel-body well">
                <p>-----------开始-----------</p>
            ${html}

                <p>-----------结束-----------</p>
            </div>

        </div>

    </div>


<#include "include/footer.ftl"/>
</div>
<#include "include/seo.ftl"/>
<script>
    //    $('#myModal').modal(options);
    $("#a2").popover();

</script>
</body>
</html>
