$(function(){

    $("#insertTableBtn").click(function(){
        var insertTableRowNum = $("#insertTableRowNum").val();
        var insertTableColNum = $("#insertTableColNum").val();
        if ($.isNumeric(insertTableRowNum) && $.isNumeric(insertTableColNum) && insertTableRowNum>0 && insertTableColNum>0 ){
            var id = drawingPanel.getNextId();
            var insertStr = "<table " + "id='" + id + "'" +  " >";
            for (i=0; i<insertTableRowNum; i++){
                insertStr = insertStr + "<tr>";
                for (j=0; j<insertTableColNum; j++){
                    insertStr = insertStr + "<td>";
                    insertStr = insertStr + "</td>";
                }                            
                insertStr = insertStr + "</tr>";
            }
            insertStr = insertStr + "</table>"; 
            $(insertStr).appendTo(drawingPanel);
            $("#"+id + " td").sortable({
                helper: 'clone',
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel td, #drawingPanel, #drawingPanel div.hbox, #drawingPanel div.vbox"
            });
        } else {
            alert("Invalid value of Rows and Colums");
        }
    });

    $("#vbox").draggable({
        helper: function(){
            var container;
            var vbox;
            container = $("<div style='width:auto;height:auto'></div>");
            vbox = $("<div class='vbox'></div>").sortable({
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel .vbox, #drawingPanel .hbox"
            });
            return container.append(vbox);
        },
        connectToSortable: "#drawingPanel"
    });

    $("#hbox").draggable({
        helper: function(){
            var container;
            var hbox;
            container = $("<div style='width:auto;height:auto'></div>");
            hbox = $("<div class='hbox' ></div>").sortable({
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            }); 
            return container.append(hbox);
        },
        connectToSortable: "#drawingPanel"
    });

    $("#label").draggable({
        helper: function(){
            var label = $("<div id='"+drawingPanel.getNextId()+"' class='control-container control-type-label'><div class='handle'></div><div class='control-content'>label</div></div>") 
            return label;
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