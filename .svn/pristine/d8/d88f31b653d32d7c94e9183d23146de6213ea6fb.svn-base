var tooltipApplication = function ($) {
    var elmentSelector = ".hasTooltip",
        elementDataSelector = "tooltip-selector",
        tooltipDirection = "right",
        tooltipAnimation = "fadeIn",
        tooltipClass = "tooltip",
        tooltipSpacing = 5,
        tooltipElement = "<div>";
    var buildTooltips = function () {
        var $elements = $(elmentSelector),
            tooltipInteger = 1;
        $elements.each(function () {
            var $ele = $(this),
                $tooltip = $(tooltipElement, {
                    id: "tooltip-" + tooltipInteger,
                    "class": tooltipClass
                }),
                eleOffset = $ele.offset(),
                eleTop = eleOffset.top,
                eleLeft = eleOffset.left,
                eleWidth = $ele.outerWidth(),
                eleHeight = $ele.outerHeight(),
                direction = "",
                animation = "",
                spacing = "",
                topPosition = "auto",
                bottomPosition = "auto",
                leftPosition = "auto",
                rightPosition = "auto",
                animateDirection = "";
            if ($ele.attr("data-tooltip-direction")) {
                direction = $ele.data("tooltip-direction")
            } else {
                direction = tooltipDirection
            }
            if ($ele.attr("data-tooltip-animation")) {
                animation = $ele.data("tooltip-animation")
            } else {
                animation = tooltipAnimation
            }
            if ($ele.attr("data-tooltip-spacing")) {
                spacing = $ele.data("tooltip-spacing")
            } else {
                spacing = tooltipSpacing
            }
            $ele.attr("data-" + elementDataSelector, "tooltip-" + tooltipInteger);
            $tooltip.text($ele.attr("title"));
            $tooltip.appendTo("body");
            var tooltipHeight = $tooltip.outerHeight(),
                tooltipWidth = $tooltip.outerWidth();
            if (direction === "left") {
                leftPosition = eleLeft + eleWidth + spacing + "px";
                topPosition = eleTop + eleHeight / 2 - tooltipHeight / 2 + "px";
                animateDirection = "Left"
            } else if (direction === "bottom") {
                leftPosition = eleLeft + eleWidth / 2 - tooltipWidth / 2 + "px";
                topPosition = eleTop + eleHeight + spacing + "px";
                animateDirection = "Down"
            } else if (direction === "right") {
                leftPosition = eleLeft - tooltipWidth - spacing + "px";
                topPosition = eleTop + eleHeight / 2 - tooltipHeight / 2 + "px";
                animateDirection = "Right"
            } else if (direction === "top") {
                leftPosition = eleLeft + eleWidth / 2 - tooltipWidth / 2 + "px";
                topPosition = eleTop - tooltipHeight - spacing + "px";
                animateDirection = "Up"
            }
            $tooltip.addClass(animation + animateDirection);
            $tooltip.addClass("arrow-" + direction);
            $tooltip.css({
                left: leftPosition,
                top: topPosition
            });
            tooltipInteger = tooltipInteger + 1
        })
    };
    var showTooltip = function () {
        var $ele = $(this),
            tooltipID = $ele.data(elementDataSelector);
        $("#" + tooltipID).show()
    };
    var hideTooltip = function () {
        var $ele = $(this),
            tooltipID = $ele.data(elementDataSelector);
        $("#" + tooltipID).hide()
    };
    var ignition = function () {
        var $document = $(document);
        buildTooltips();
        $document.on("mouseover", elmentSelector, showTooltip);
        $document.on("mouseout", elmentSelector, hideTooltip)
    };
    return {
        createTooltips: ignition
    }
}(jQuery);