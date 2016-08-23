
/**
 * Define drawingPanel object. Make the element inside drawingPanel sortable and selectable
 * 
 * Define Custom Properties 
 * - idCount
 * 
 * Define Custom method
 * - getNextId()
 */

$( function() {
    drawingPanel = $("#drawingPanel");
    
    drawingPanel.idCount = 0;

    drawingPanel.getNextId = function(){
        this.idCount = this.idCount + 1;
        return "drawingPanelItem" + this.idCount;
    };

    drawingPanel.sortable({
		receive: function(event, ui){
			var drag = $(this).find(".control-container-drag");
			drag.css({'height':'auto', 'width':'auto'});
			drag.removeClass("control-container-drag");
		},
        helper: function(event, ui){
            var drag =  $("<div style='background-color: blue; width:10px; height;10px'><div>");
            return drag;
        },
        placeholder: "ui-state-highlight",
		forcePlaceholderSize: true , 
        containment: "#drawingPanelContainer",
        handle: ".handle",
        connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
    }).selectable({
        cancel: ".handle",
        filter: ".select, .control-content",
        selected: function(event, ui){
            var meta = controlHelper.getMeta(ui.selected);
        }
    });  
});