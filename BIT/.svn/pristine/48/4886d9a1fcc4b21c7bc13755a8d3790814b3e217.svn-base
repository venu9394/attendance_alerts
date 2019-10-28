function addRow(tableID) {

	     
        var Field1 = document.getElementById("FF0001").value;
		var Field2 = document.getElementById("FF0002").value;
		var Field3 = document.getElementById("FF0003").value;
		var Field4 = document.getElementById("FF0004").value;
	    
        var Field5 = document.getElementById("FF0005").value;		
		 
		  // alert("Field5" +Field5);
		// document.getElementById("FF0005").value=eval(Field5)+eval(Field4);
		 
      /*  if(isNaN(Field5) && trim(Field5).length<=0){
        	Field5=0;
        	document.getElementById("FF0005").value=0;
 		 }*/
        
       /*  if(Field1==""){
        	alert("Please Fill Policy Number..")
        	document.getElementById("FF0001").focus();
 		 } 
        
        
        if(trim(Field2)=="Select"){
        	alert("Please Select Policy Holder Relation..");
        	document.getElementById("FF0002").focus();
 		 }*/
        
        
        
		/*if(isNaN(Field3)){
		   alert("Please Enter Numbers Only");
		   document.getElementById("FF0003").focus();
		   document.getElementById("FF0003").value='';
		   return false;
		 }
		 
 		 var alrt=isNaN(Field4);
 		    alert("alrt::"+alrt);
 		 
		if(alrt==true || alrt=="true"){
		   alert("Please Enter Numbers Only");
		   document.getElementById("FF0004").focus();
		   document.getElementById("FF0004").value='';
		   return false;
		 }else{
		   document.getElementById("FF0005").value=eval(Field5)+eval(Field4);
		 }*/
		 
	  if(Field1.length > 0 &&  Field2!="Select" && Field3.length > 0 && Field4.length > 0 ){
	
	     document.getElementById("FF0005").value=eval(Field5)+eval(Field4);
	   
	    
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
		    //alert(rowCount);
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        //element1.type = "checkbox";
        //element1.name="chkbox";
		//element1.value=rowCount;
		//element1.checked=true;
		//element1.setAttribute("checked", true);
		
		//element1.setAttribute("checked");
		
		cell1.innerHTML="<input type='checkbox' name='chkbox' value="+rowCount+"  onClick=deleteRow('dataTable')  checked >" ;
		
		
		//checkbox.setAttribute("checked", "checked");
		
		//element1.setAttribute("Onclick","deleteRow(tableID)");
       // cell1.appendChild(element1);

          var cell2 = row.insertCell(1);
       // cell2.innerHTML = rowCount + 1;
	   
	    //cell2.innerHTML = rowCount ;

        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "Amt_policy_"+rowCount+"";
		element2.value = Field1;
		
		element2.setAttribute("readOnly","true"); 
		
			element2.setAttribute("class","form-control");
			
        cell3.appendChild(element2);
        
		//cell3.innerHTML = Field1;
		
		var cell4 = row.insertCell(3);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.id = "Amt_0_"+rowCount+"";
        element3.name = "Amt_0_"+rowCount+"";
		element3.value = Field2;
		element3.setAttribute("readOnly","true");
		element3.setAttribute("class","form-control");
		
        cell4.appendChild(element3);
		
		//cell4.innerHTML = Field2;
		
		var cell5 = row.insertCell(4);
        var element5 = document.createElement("input");
        element5.type = "text";
        element5.id = "Amt_1_"+rowCount+"";
        element5.name = "Amt_1_"+rowCount+"";
		element5.value = Field3;
		element5.setAttribute("readOnly","true");
		element5.setAttribute("class","form-control");
        cell5.appendChild(element5);
		
		//cell5.innerHTML = Field3;
		
		var cell6 = row.insertCell(5);
        var element6 = document.createElement("input");
        element6.type = "text";
        element6.id = "Amt_2_"+rowCount+"";
        element6.name = "Amt_2_"+rowCount+"";
		element6.value = Field4;
		element6.setAttribute("readOnly","true");
		element6.setAttribute("class","form-control");
        cell6.appendChild(element6);
		
	
		//cell6.innerHTML = Field4;
		
		//v1.setAttribute("readOnly","true");
        document.getElementById("FF0005").value=eval(Field5)+eval(Field4);
		}else{
		  alert("Please Fill The All Columns..")
		}
	 
            document.getElementById("FF0001").value="";
			document.getElementById("FF0002").value="Select";
			document.getElementById("FF0003").value="";
			document.getElementById("FF0004").value="";
    }

    function deleteRow(tableID){
        try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

		 // alert(rowCount);
        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
			   //alert(chkbox.name);
			   //alert(chkbox.value);
			/* try{
			
			 }catch(err){
			   alert(err.value);
			 }*/   
			 // if(null != chkbox && true == chkbox.checked) {
            if(null != chkbox && false == chkbox.checked) {
			 var  id="Amt_2_"+chkbox.value+"";
			 var net=document.getElementById(""+id+"").value;
			var netOld=document.getElementById("FF0005").value;
			document.getElementById("FF0005").value=eval(netOld)-eval(net);
                table.deleteRow(i);
                rowCount--;
                i--;
            }
			
        }
        }catch(e) {
            alert(e);
        }
    }
