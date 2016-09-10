
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
    // define id sequence for drawPanel
    drawingPanel.idCount = 0;
    drawingPanel.getNextId = function(){
        this.idCount = this.idCount + 1;
        return "drawingPanelItem" + this.idCount;
    };

    drawingPanel.sortable({
		receive: function(event, ui){
			var drag = $(this).find(".control-container-drag");
			drag.css({'width':'70%', 'height':'auto'});
			drag.removeClass("control-container-drag");
		},
        containment: "#drawingPanelContainer",
        handle: ".handle",
        connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
    }).selectable({
        cancel: ".handle",
        selected: function(event, ui){
            controlHelper.updateControl(ui.selected);
        }
    });  
});