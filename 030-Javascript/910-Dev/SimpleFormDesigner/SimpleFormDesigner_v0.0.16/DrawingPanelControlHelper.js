/**
 * Provide Control for dragging into drawing Panel
 * - vbox
 * - hbox
 * - label
 * - input
 * - table
 * 
 * Dependencies
 * - DrawingPanel.js
 */

$(function(){

    containerHelper = {};
    containerHelper.getContainer = function(type){
		// The width of container is just for display when dragging.
        var containerHtml = "<div style='width: 100px'></div>";
        var container = $(containerHtml);
        container.addClass(ContainerConstant.CONTAINER);
		container.addClass(ContainerConstant.DRAG);
        container.attr("id", drawingPanel.getNextId());
        if (type == 'label'){
            container.addClass(ContainerConstant.LABEL);
        }
        if (type == 'input'){
            container.addClass(ContainerConstant.INPUT);
        }
        if (type == 'table'){
            container.addClass(ContainerConstant.TABLE);
            var select = $("<div>table</div>");
            select.addClass(ContainerConstant.SELECT);
            container.append(select);
        }
        if (type == 'vbox'){
            container.addClass(ContainerConstant.VBOX);
            var select = $("<div>vbox</div>");
            select.addClass(ContainerConstant.SELECT);
            container.append(select);
        }
        if (type == 'hbox'){
            container.addClass(ContainerConstant.HBOX);
            var select = $("<div>hbox</div>");
            select.addClass(ContainerConstant.SELECT);
            container.append(select);
        }
        var handle = $("<div></div>");
        handle.addClass(ContainerConstant.HANDLE);
        container.append(handle);
        return container;
    };
    containerHelper.getControl = function(type, control){
        var container = this.getContainer(type);
        var content = $("<div></div>");
        if (type == "table" || type == "vbox" || type == "hbox"){
            content.addClass(ContainerConstant.LAYOUT);
        }else{
            content.addClass(ContainerConstant.CONTENT);
        }
        
        content.append(control);
        container.append(content);
        return container;
    }

    // Table
    $("#insertTableBtn").click(function(){
        var insertTableRowNum = $("#insertTableRowNum").val();
        var insertTableColNum = $("#insertTableColNum").val();
        if ($.isNumeric(insertTableRowNum) && $.isNumeric(insertTableColNum) && insertTableRowNum>0 && insertTableColNum>0 ){
			var table = $("<table></table>");
            for (i=0; i<insertTableRowNum; i++){
				var row = $("<tr></tr");
				table.append(row);
                for (j=0; j<insertTableColNum; j++){
					var col= $("<td></td>");
					col.sortable({
						helper: function(event, ui){
							var drag =  $("<div style='background-color: blue; width:10px; height;10px'><div>");
							return drag;
						},
						placeholder: "ui-state-highlight",
						forcePlaceholderSize: true ,
                        handle: ".handle",
						containment: "#drawingPanelContainer",
						connectWith: "#drawingPanel td, #drawingPanel, #drawingPanel div.hbox, #drawingPanel div.vbox"
					}).selectable({
                        cancel: ".handle",
                        filter: ".select, .control-content",
                        selected: function(event, ui){
                            var meta = controlHelper.getMeta(ui.selected);
                        }
                    });  
					row.append(col);
                }                            
            }
            var control = containerHelper.getControl('table',table);
            control.appendTo(drawingPanel);
        } else {
            alert("Invalid value of Rows and Colums");
        }
    });

    // VBox
    $("#vbox").draggable({
        helper: function(){
            var vbox;
            vbox = $("<div class='vbox'></div>").sortable({
				helper: function(event, ui){
					var drag =  $("<div style='background-color: blue; width:10px; height;10px'><div>");
					return drag;
				},
				placeholder: "ui-state-highlight",
				forcePlaceholderSize: true ,
                handle: ".handle",
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel .vbox, #drawingPanel .hbox"
            }).selectable({
                cancel: ".handle",
                filter: ".select, .control-content",
                selected: function(event, ui){
                    var meta = controlHelper.getMeta(ui.selected);
                }
            });  
            var control = containerHelper.getControl('vbox', vbox);
            return control;
        },
        connectToSortable: "#drawingPanel"
    });

    // HBox
    $("#hbox").draggable({
        helper: function(){
            var hbox;
            hbox = $("<div class='hbox'></div>").sortable({
				helper: function(event, ui){
					var drag =  $("<div style='background-color: blue; width:10px; height;10px'><div>");
					return drag;
				},
				placeholder: "ui-state-highlight",
				forcePlaceholderSize: true ,
                handle: ".handle",
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            }).selectable({
                cancel: ".handle",
                filter: ".select, .control-content",
                selected: function(event, ui){
                    var meta = controlHelper.getMeta(ui.selected);
                }
            }); 
            var control = containerHelper.getControl('hbox', hbox);
            return control;
        },
        connectToSortable: "#drawingPanel"
    });

	// Label
    $("#label").draggable({
        helper: function(){
            var label = $("<div>label</div>")
            var control = containerHelper.getControl('label', label); 
            return control;
        },
        connectToSortable: "#drawingPanel"
    });
	
	// Input
    $("#input").draggable({
        helper: function(){
            var input = $("<input style='width:100px, height: 20px'/>");
			var control = containerHelper.getControl('input', input); 
            return control;
        },
        connectToSortable: "#drawingPanel"
    });
});