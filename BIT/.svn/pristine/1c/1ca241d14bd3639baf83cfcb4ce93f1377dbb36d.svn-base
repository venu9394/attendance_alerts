function addRow_1(tableID) {

	     
        var Field1 = document.getElementById("FF0010").value;
		var Field2 = document.getElementById("FF0011").value;
		var Field3 = document.getElementById("FF0012").value;
		var Field4 = document.getElementById("FF0013").value;
        var Field5 = document.getElementById("FF0014").value;	
         
          var Field6 = document.getElementById("FF0015").value;		 
		 
	  if(Field1.length > 0 &&  Field2!="Select" && Field3!="Select" && Field4.length > 0 && Field5.length > 0 ){
	
	     document.getElementById("FF0015").value=eval(Field5)+eval(Field6);
	   
	    
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
		    //alert(rowCount);
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        
          var cell2 = row.insertCell(1);
       
        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "80D_policy_"+rowCount+"";
		element2.value = Field1;
		
		element2.setAttribute("readOnly","true"); 
		
			element2.setAttribute("class","form-control");
			
        cell3.appendChild(element2);
       
		var cell4 = row.insertCell(3);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.id = "80D_0_"+rowCount+"";
        element3.name = "80D_0_"+rowCount+"";
		element3.value = Field2;
		element3.setAttribute("readOnly","true");
		element3.setAttribute("class","form-control");
		
        cell4.appendChild(element3);
		
		var cell5 = row.insertCell(4);
        var element5 = document.createElement("input");
        element5.type = "text";
        element5.id = "80D_1_"+rowCount+"";
        element5.name = "80D_1_"+rowCount+"";
		element5.value = Field3;
		element5.setAttribute("readOnly","true");
		element5.setAttribute("class","form-control");
        cell5.appendChild(element5);
		
		var cell6 = row.insertCell(5);
        var element6 = document.createElement("input");
        element6.type = "text";
        element6.id = "80D_2_"+rowCount+"";
        element6.name = "80D_2_"+rowCount+"";
		element6.value = Field4;
		element6.setAttribute("readOnly","true");
		element6.setAttribute("class","form-control");
        cell6.appendChild(element6);
		
		
		var cell6 = row.insertCell(6);
        var element6 = document.createElement("input");
        element6.type = "text";
        element6.id = "80D_3_"+rowCount+"";
        element6.name = "80D_3_"+rowCount+"";
		element6.value = Field5;
		element6.setAttribute("readOnly","true");
		element6.setAttribute("class","form-control");
        cell6.appendChild(element6);
		
		
	   var cell7 = row.insertCell(7);
        var element6 = document.createElement("input");
      cell7.innerHTML="<input type='checkbox' name='80D_chkbox' id='80D_chkbox_"+rowCount+"' value="+rowCount+"  onClick=deleteRow_1('dataTable1')  checked style='display:none;'> " ;
	  
		var cell8 = row.insertCell(8);
        var element8 = document.createElement("input");
        element8.type = "button";
		
	      element8.id="80DLICBUT";
		
        element8.name = "button"+rowCount+"";
		element8.value = "Delete";
		element8.setAttribute("onClick","deleteRowss_1("+rowCount+")");
	    element8.setAttribute("class","form-control");
        cell8.appendChild(element8);
		
		
		
		  document.getElementById("FF0015").value=eval(Field5)+eval(Field6);
			try{
				add80d();
			}catch(err){
				
			}
		}else{
		  alert("Please Fill The All Columns..")
		}
	 
            document.getElementById("FF0010").value="";
			document.getElementById("FF0011").value="Select";
			document.getElementById("FF0012").value="no";
			document.getElementById("FF0013").value="";
			document.getElementById("FF0014").value="";
    }
   function deleteRowss_1(val){
	   
	 var id="80D_chkbox_"+val ;
	  try{
    document.getElementById(""+id+"").checked=false;	
	  }catch(err){
		  alert(err.value);
	  }
	   deleteRow_1('dataTable1');
	   
   }
    function deleteRow_1(tableID){
		    //alert("tableID::"+tableID);
		  
        try {
	
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
          /* if(eval(rowCount)==1){
			   document.getElementById("FF0015").value=0;
		   }*/
        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[7].childNodes[0];
			   if(null != chkbox && false == chkbox.checked) {
			 var  id="80D_3_"+chkbox.value+"";
			 var net=document.getElementById(""+id+"").value;
			var netOld=document.getElementById("FF0015").value;
			document.getElementById("FF0015").value=eval(netOld)-eval(net);
                table.deleteRow(i);
                rowCount--;
                i--;
            }
			try{
				add80d();
			}catch(err){
				
			}
        }
        }catch(e) {
            alert(e);
        }
    }
