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

    ContainterConstant = {
        CONTAINER: "control-container",
        CONTENT: "control-content",
        HANDLE: "handle",
        LABEL: "control-type-label",
        INPUT: "control-type-input",
        TABLE: "control-type-table",
        VBOX: "control-type-vbox",
        HBOX: "control-type-hbox"
    };

    containerHelper = {};
    containerHelper.getContainer = function(type){
        var containerHtml = "<div style='width:50%; height:auto'></div>";
        var container = $(containerHtml);
        container.addClass(ContainterConstant.CONTAINER);
        container.attr("id", drawingPanel.getNextId());
        if (type == 'label'){
            container.addClass(ContainterConstant.LABEL);
        }
        if (type == 'input'){
            container.addClass(ContainterConstant.INPUT);
        }
        if (type == 'table'){
            container.addClass(ContainterConstant.TABLE);
        }
        if (type == 'vbox'){
            container.addClass(ContainterConstant.VBOX);
        }
        if (type == 'hbox'){
            container.addClass(ContainterConstant.HBOX);
        }
        return container;
    };
    containerHelper.getControl = function(type, control){
        var container = this.getContainer(type);
        var handle = $("<div></div>");
        handle.addClass(ContainterConstant.HANDLE);
        var content = $("<div style='width:80%'></div>");
        content.addClass(ContainterConstant.CONTENT);
        content.append(control);
        container.append(handle);
        container.append(content);
        return container;
    }

    // Table
    $("#insertTableBtn").click(function(){
        var insertTableRowNum = $("#insertTableRowNum").val();
        var insertTableColNum = $("#insertTableColNum").val();
        if ($.isNumeric(insertTableRowNum) && $.isNumeric(insertTableColNum) && insertTableRowNum>0 && insertTableColNum>0 ){
            var insertStr = "<table>";
            for (i=0; i<insertTableRowNum; i++){
                insertStr = insertStr + "<tr>";
                for (j=0; j<insertTableColNum; j++){
                    insertStr = insertStr + "<td>";
                    insertStr = insertStr + "</td>";
                }                            
                insertStr = insertStr + "</tr>";
            }
            insertStr = insertStr + "</table>";
            var table = $(insertStr);
            table.sortable({
                helper: 'clone',
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel td, #drawingPanel, #drawingPanel div.hbox, #drawingPanel div.vbox"
            });
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
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel .vbox, #drawingPanel .hbox"
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
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            }); ;
            var control = containerHelper.getControl('hbox', hbox);
            return control;
        },
        connectToSortable: "#drawingPanel"
    });

    $("#label").draggable({
        helper: function(){
            var label = $("<div>label</div>")
            var control = containerHelper.getControl('label', label); 
            return control;
        },
        connectToSortable: "#drawingPanel"
    });

    $("#input").draggable({
        helper: function(){
            var input = $("<div class='input'><input/></div>");
            return input;
        },
        connectToSortable: "#drawingPanel"
    });
});