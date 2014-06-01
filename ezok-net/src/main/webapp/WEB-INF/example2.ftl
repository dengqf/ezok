<!DOCTYPE html>
<html lang="en">
<head>
<#include "include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "include/nav.ftl"/>


    <div class="row">
        <div class="col-lg-9">
            <div class="panel-body well">
                <div class="row">
                    <div class="col-lg-12">
                        <legend>南方周刊</legend>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <img src="http://v.newhua.com/images/03.jpg" alt="1">
                    </div>

                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-lg-6">
                                <p>微信原始账号:南方周刊</p>

                                <p>易信原始账号:JEFFER</p>
                            <#--<p>官方网站地址:http://www.sina.com.cn</p>-->

                            </div>
                            <div class="col-lg-6">
                                <p>微信公共账号:南方周刊</p>

                                <p>易信公共账号:JEFFER</p>
                            <#--<p>官方微博地址:http://www.weibo.com</p>-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <p>官方网站地址:http://www.sina.com.cn</p>

                                <p>官方微博地址:http://www.weibo.com</p>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <p>账号所属分类:南方周刊</p>


                            </div>
                            <div class="col-lg-6">
                                <p>账号收录时间:2014-21-12</p>

                            </div>
                        </div>
                    </div>

                </div>
                <br>
                <br>

                <div class="row">
                    <div class="col-lg-12">
                        <legend>账号二维码</legend>
                    </div>

                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <ul>
                            <li class="col-lg-12">
                                <img src="http://v.newhua.com/images/03_i.jpg" alt="1">

                                <div class="caption">
                                    <h4>
                                        用微信扫一扫添加关注
                                    </h4>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="col-lg-6">
                        <ul>
                            <li class="col-lg-12">
                                <img src="http://v.newhua.com/images/03_i.jpg" alt="1">

                                <div class="caption">
                                    <h4>
                                        用微易扫一扫添加关注
                                    </h4>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <br>
                <br>

                <div class="row">
                    <div class="col-lg-12">
                        <legend>账号介绍</legend>
                    </div>

                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            易观智库商业信息服务平台，
                            是一款反映中国新媒体经济（互联网、移动互联网、广电网、物联网等）发展的信息产品。易观智库已成为国内外政府、企业、投资机构以及专业人士了解市场、提升创新力和决策力的首选信息工具。
                        </p>
                    </div>
                </div>
            </div>
            <a id="a2" class="btn btn-lg btn-danger" data-placement="right" data-html="<img src=''>"
               data-content="即对拥有矮、胖、穷、丑是通常又不肯承认，个人一般自称为自由职业者。" title="" href="#" data-original-title="屌丝本义">
                Please Click to toggle popover
            </a>
        </div>
        <div class="col-lg-3">


            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                Launch demo modal222
            </button>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                            One fine body&hellip;
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                Launch demo modal 111
            </button>

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
