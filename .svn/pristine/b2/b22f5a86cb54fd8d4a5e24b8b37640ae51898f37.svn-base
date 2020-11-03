$(function() {
    "use strict";
    $(function() {
        $(".preloader").fadeOut();
    }), jQuery(document).on("click", ".mega-dropdown", function(e) {
        e.stopPropagation();
    });
    var set = function() {
        (window.innerWidth > 0 ? window.innerWidth : this.screen.width) < 1170 ? ($("body").addClass("mini-sidebar"), 
        $(".navbar-brand span").hide(), $(".sidebartoggler i").addClass("ti-menu")) : ($("body").removeClass("mini-sidebar"), 
        $(".navbar-brand span").show());
        var height = (window.innerHeight > 0 ? window.innerHeight : this.screen.height) - 1;
        (height -= 0) < 1 && (height = 1), height > 0 && $(".page-wrapper").css("min-height", height + "px");
    };
    $(window).ready(set), $(window).on("resize", set), $(".sidebartoggler").on("click", function() {
        $("body").hasClass("mini-sidebar") ? ($("body").trigger("resize"), $("body").removeClass("mini-sidebar"), 
        $(".navbar-brand span").show()) : ($("body").trigger("resize"), $("body").addClass("mini-sidebar"), 
        $(".navbar-brand span").hide());
    }), $(".nav-toggler").click(function() {
        $("body").toggleClass("show-sidebar"), $(".nav-toggler i").toggleClass("ti-menu"), 
        $(".nav-toggler i").addClass("ti-close");
    }), $(".search-box a, .search-box .app-search .srh-btn").on("click", function() {
        $(".app-search").toggle(200);
    }), $(".right-side-toggle").click(function() {
        $(".right-sidebar").slideDown(50), $(".right-sidebar").toggleClass("shw-rside");
    }), $(".floating-labels .form-control").on("focus blur", function(e) {
        $(this).parents(".form-group").toggleClass("focused", "focus" === e.type || this.value.length > 0);
    }).trigger("blur"), $(function() {
        for (var url = window.location, element = $("ul#sidebarnav a").filter(function() {
            return this.href == url;
        }).addClass("active").parent().addClass("active"); ;) {
            if (!element.is("li")) break;
            element = element.parent().addClass("in").parent().addClass("active");
        }
    }), $(function() {
        $('[data-toggle="tooltip"]').tooltip();
    }), $(function() {
        $('[data-toggle="popover"]').popover();
    }), $(function() {
        $("#sidebarnav").AdminMenu();
    }),/*, $(".scroll-sidebar, .right-side-panel, .message-center, .right-sidebar").perfectScrollbar(), */
    $("body").trigger("resize"), $(".list-task li label").click(function() {
        $(this).toggleClass("task-done");
    }), $('a[data-action="collapse"]').on("click", function(e) {
        e.preventDefault(), $(this).closest(".card").find('[data-action="collapse"] i').toggleClass("ti-minus ti-plus"), 
        $(this).closest(".card").children(".card-body").collapse("toggle");
    }), $('a[data-action="expand"]').on("click", function(e) {
        e.preventDefault(), $(this).closest(".card").find('[data-action="expand"] i').toggleClass("mdi-arrow-expand mdi-arrow-compress"), 
        $(this).closest(".card").toggleClass("card-fullscreen");
    }), $('a[data-action="close"]').on("click", function() {
        $(this).closest(".card").removeClass().slideUp("fast");
    });


    $(function() {
        $('.selectpicker').selectpicker();
      });

    //select options start 
      
       // Switchery
       var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
       $('.js-switch').each(function() {
           new Switchery($(this)[0], $(this).data());
       });
       // For select 2
       $(".select2").select2();
       $('.selectpicker').selectpicker();
       //Bootstrap-TouchSpin
      /*  $(".vertical-spin").TouchSpin({
           verticalbuttons: true,
           verticalupclass: 'ti-plus',
           verticaldownclass: 'ti-minus'
       });
       var vspinTrue = $(".vertical-spin").TouchSpin({
           verticalbuttons: true
       });
       if (vspinTrue) {
           $('.vertical-spin').prev('.bootstrap-touchspin-prefix').remove();
       }
       $("input[name='tch1']").TouchSpin({
           min: 0,
           max: 100,
           step: 0.1,
           decimals: 2,
           boostat: 5,
           maxboostedstep: 10,
           postfix: '%'
       });
       $("input[name='tch2']").TouchSpin({
           min: -1000000000,
           max: 1000000000,
           stepinterval: 50,
           maxboostedstep: 10000000,
           prefix: '$'
       });
       $("input[name='tch3']").TouchSpin();
       $("input[name='tch3_22']").TouchSpin({
           initval: 40
       });
       $("input[name='tch5']").TouchSpin({
           prefix: "pre",
           postfix: "post"
       });
       // For multiselect
       $('#pre-selected-options').multiSelect();
       $('#optgroup').multiSelect({
           selectableOptgroup: true
       });
       $('#public-methods').multiSelect();
       $('#select-all').click(function() {
           $('#public-methods').multiSelect('select_all');
           return false;
       });
       $('#deselect-all').click(function() {
           $('#public-methods').multiSelect('deselect_all');
           return false;
       });
       $('#refresh').on('click', function() {
           $('#public-methods').multiSelect('refresh');
           return false;
       });
       $('#add-option').on('click', function() {
           $('#public-methods').multiSelect('addOption', {
               value: 42,
               text: 'test 42',
               index: 0
           });
           return false;
       }); */
       $(".ajax").select2({
           ajax: {
               url: "https://api.github.com/search/repositories",
               dataType: 'json',
               delay: 250,
               data: function(params) {
                   return {
                       q: params.term, // search term
                       page: params.page
                   };
               },
               processResults: function(data, params) {
                   // parse the results into the format expected by Select2
                   // since we are using custom formatting functions we do not need to
                   // alter the remote JSON data, except to indicate that infinite
                   // scrolling can be used
                   params.page = params.page || 1;
                   return {
                       results: data.items,
                       pagination: {
                           more: (params.page * 30) < data.total_count
                       }
                   };
               },
               cache: true
           },
           escapeMarkup: function(markup) {
               return markup;
           }, // let our custom formatter work
           minimumInputLength: 1,
           templateResult: formatRepo, // omitted for brevity, see the source of this page
           templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
       });

//select end







});