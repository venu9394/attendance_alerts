function addRow_1(tableID) {

	    var Field1 = document.getElementById("FF0006").value;
		var Field2 = document.getElementById("FF0007").value;
		var Field3 = document.getElementById("FF0008").value;
		var Field4 = document.getElementById("FF0009").value;
	    var Field5 = document.getElementById("FF0010").value;	
		var Field6 = document.getElementById("FF0011").value;			
		 
		 
	  if(Field1.length > 0 &&  Field2!="Select" && Field3!="Select" && Field4.length > 0 && Field5.length > 0 ){
	
	     document.getElementById("FF0011").value=eval(Field5)+eval(Field6);
	   
	    
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
		    //alert(rowCount);
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
		element1.type = "text";
        element1.name = "80D_0_"+rowCount+"";
		element1.value = Field1;
		element1.setAttribute("readOnly","true"); 
		element1.setAttribute("class","form-control");
		cell2.appendChild(element1);
		
		var cell2 = row.insertCell(1);
        var element2 = document.createElement("input");
		element2.type = "text";
        element2.name = "80D_policy_"+rowCount+"";
		element2.value = Field2;
		element2.setAttribute("readOnly","true"); 
		element2.setAttribute("class","form-control");
		cell3.appendChild(element2);
		
		
		var cell3 = row.insertCell(2);
        var element3 = document.createElement("input");
		element3.type = "text";
        element3.name = "80D_0_"+rowCount+"";
		element3.value = Field3;
		element3.setAttribute("readOnly","true"); 
		element3.setAttribute("class","form-control");
		cell3.appendChild(element3);
		
		
		var cell4 = row.insertCell(3);
        var element4 = document.createElement("input");
		element4.type = "text";
        element4.name = "80D_1_"+rowCount+"";
		element4.value = Field4;
		element4.setAttribute("readOnly","true"); 
		element4.setAttribute("class","form-control");
		cell4.appendChild(element4);
		
		var cell5 = row.insertCell(4);
        var element5 = document.createElement("input");
		element5.type = "text";
        element5.name = "80D_2_"+rowCount+"";
		element5.value = Field3;
		element5.setAttribute("readOnly","true"); 
		element5.setAttribute("class","form-control");
		cell5.appendChild(element5);
		
		var cell8 = row.insertCell(5);
        var element6 = document.createElement("input");
        //element1.type = "checkbox";
        //element1.name="chkbox";
		//element1.value=rowCount;
		//element1.checked=true;
		//element1.setAttribute("checked", true);
		//element1.setAttribute("checked");
		//cell7.innerHTML="<input type='checkbox' name='chkbox' value="+rowCount+"  onClick=deleteRow('dataTable')  checked >" ;
		 //<input type='checkbox' name='thing' value='valuable' id="thing"/><label for="thing"></label> 
		cell8.innerHTML="<input type='checkbox' name='chkbox_80D' id='chkbox_80D_"+rowCount+"' value="+rowCount+"  onClick=deleteRow('dataTable1')  checked style='display:none;'> " ;
		//  &nbsp; <input  type='button' class='form-control' value='DELETE'  valign='top' onClick=deleteRowss("+rowCount+") > 
		
		
		var cell7 = row.insertCell(6);
        var element7 = document.createElement("input");
        element7.type = "button";
		//element7.id = "button"+rowCount+"";
	    element7.id="LICBUT_80D";
		element7.name = "button"+rowCount+"";
		element7.value = "Delete";
		element7.setAttribute("onClick","deleteRowss_80D("+rowCount+")");
	    element7.setAttribute("class","form-control");
        cell7.appendChild(element7);
		
		
		
		document.getElementById("FF0011").value=eval(Field5)+eval(Field6);
		}else{
		  alert("Please Fill The All Columns..")
		}
	 
            document.getElementById("FF0006").value="";
			document.getElementById("FF0007").value="Select";
			document.getElementById("FF0008").value="Select";
			document.getElementById("FF0009").value="";
			document.getElementById("FF0010").value="";
		
	}	
function deleteRowss_80D(val){
	
	 //alert(val);
	 var id="chkbox_80D_"+val ;
	 
	 // alert(id);
	  try{
    document.getElementById(""+id+"").checked=false;	
	  }catch(err){
		  alert(err.value);
	  }
	   deleteRow_1('dataTable1');
	   
   }
    function deleteRow_1(tableID){
		   // alert("tableID::"+tableID);
        try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

		 // alert(rowCount);
        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[6].childNodes[0];
			   //alert(chkbox.name);
			   //alert(chkbox.value);
			/* try{
			
			 }catch(err){
			   alert(err.value);
			 }*/   
			 // if(null != chkbox && true == chkbox.checked) {
            if(null != chkbox && false == chkbox.checked) {
			 var  id="80D_2_"+chkbox.value+"";
			 var net=document.getElementById(""+id+"").value;
			var netOld=document.getElementById("FF0011").value;
			document.getElementById("FF0011").value=eval(netOld)-eval(net);
                table.deleteRow(i);
                rowCount--;
                i--;
            }
			
        }
        }catch(e) {
            alert(e);
        }
    }	