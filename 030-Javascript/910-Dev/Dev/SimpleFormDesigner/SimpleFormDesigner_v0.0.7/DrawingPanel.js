$( function() {
    drawingPanel = $("#drawingPanel");
    // define id sequence for drawPanel
    drawingPanel.idCount = 0;
    drawingPanel.getNextId = function(){
        this.idCount = this.idCount + 1;
        return "drawingPanelItem" + this.idCount;
    };

    $("#drawingPanel").sortable({
        containment: "#drawingPanelContainer",
        handle: ".handle",
        connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
    }).selectable({
        cancel: ".handle",
        selected: function(event, ui){
            var meta = controlHelper.getMeta(ui.selected);
            if (meta){
                $("#controlId").val(meta.id);
                $("#controlType").val(meta.type);
                $("#controlValue").val(meta.value)
            }
        }
    });  
});