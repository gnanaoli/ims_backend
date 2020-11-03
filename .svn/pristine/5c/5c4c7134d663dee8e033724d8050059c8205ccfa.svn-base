$(document).ready(function() {
    $('#example').DataTable({
        fixedHeader: true
    });
    $(".aside_icon_cut").hide();
    if($('.aside_full ul.menu_list li ul.sub_menu li').children('a').hasClass('sub_menu_active')){
        alert();
    //    $('.sub_menu_active').parents('ul.sub_menu').show(); IMPORTANT
    }
});
$('.aside_full .menu_list > li > a').click(function() {
    // if($(this).closest("li").children("ul").length) {
    //     var clsname = $(this).closest("li").children("ul").attr('class');
    //     alert(clsname);
    //     $("."+clsname)
    // }
    var clktag = $(this).closest("li").children("ul");
    if($(this).closest("li").children("ul").hasClass('sub_menu')){
        $(this).closest("li").children("ul").slideToggle("slow");
        if ($(this).closest("li").children("ul").height() < 20){
            $(this).closest("li").find('.drop_icon').addClass('drop_icon_rotate');
        }
        else{
            $(this).closest("li").find('.drop_icon').removeClass('drop_icon_rotate');
        }
    }
 });

//  ASIDE COLLAPSE IN DESKTOP\]
$(".aside_icon_full").on('click',function(){
    $(this).hide();
    $(".aside_icon_cut").show();
    $('body').addClass('sidebar_collpase');
    $('ul.sub_menu').addClass('sub_menu_hover');
    $(".sidebar_collpase .aside ul li span:nth-of-type(2)").hide();
    $('.sidebar_collpase li ul.sub_menu_hover').hide();
    $('.sidebar_collpase .aside ul li').hover(function(){
       $(this).children('ul.sub_menu_hover').show();
       
       $(this).children('ul.sub_menu_hover').find('span').show();
    },function(){
        $(this).children('ul.sub_menu_hover').hide(); 
    });
});

$(".aside_icon_cut").on('click',function(){
    $(this).hide();
    $(".aside_icon_full").show();
    $('body').removeClass('sidebar_collpase');
    $('ul.sub_menu').removeClass('sub_menu_hover');
    $(".aside_full .aside ul li span:nth-of-type(2)").show('5000');
    
});