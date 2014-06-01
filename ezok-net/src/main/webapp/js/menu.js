$(function(){
    //下拉一级菜单
    $('.dropdown').bind('mouseenter',function(e){
        e.stopPropagation();
        $(this).addClass('hover');
    });
    $('.dropdown').bind('mouseleave',function(e){
        e.stopPropagation();
        $(this).removeClass('hover');
    });
    //下拉二级菜单
    $('.dropdown .lis_con .lis').bind('mouseenter',function(e){
        e.stopPropagation();
        $(this).addClass('click');
    });
    $('.dropdown .lis_con .lis').bind('mouseleave',function(e){
        //e.stopPropagation();
        $(this).removeClass('click');
        //$('.dropdown').mouseleave();
    });
});