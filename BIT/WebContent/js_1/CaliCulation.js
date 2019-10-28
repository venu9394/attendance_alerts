function add80c() {
	
	     validate2_1();
	   var Field1 	="";
			var Field2 	="";
			var Field3 	="";
			var Field4 	="";
			var Field5 	="";
			var Field6 	="";
			var Field7 	="";
			var Field8 	="";
			var Field9 	="";
			var Field10 ="";
			var Field11 ="";
			var Field12 ="";
			var Field13 ="";
			var Field14 ="";
			var Field15 ="";
			var Field16 ="";
	try{
		
		
		
		Field1 	= document.getElementById("80c_pf_estimate").value ;
		Field2 	= document.getElementById("80c_tution_estimate").value ;
		Field3 	= document.getElementById("FF0005").value ;
		Field4 	= document.getElementById("80c_hl_estimate").value ;
		Field5 	= document.getElementById("80c_nsc_estimate").value ;
		Field6 	= document.getElementById("80c_post_estimate").value ;
		Field7 	= document.getElementById("80c_ul_estimate").value ;
		Field8 	= document.getElementById("80c_eq_estimate").value ;
		Field9 	= document.getElementById("80ccc_licp_estimate").value ;
		Field10 = document.getElementById("80ccd_pscg_estimate").value ;
		Field11 = document.getElementById("80c_sss_estimate").value ;
		Field12 = document.getElementById("80c_fd_estimate").value ;
		Field13 = document.getElementById("80c_mf_estimate").value ;
		Field14 = document.getElementById("80c_bond_estimate").value ;
		Field15 = document.getElementById("80c_others_estimate").value ;
		Field16 = document.getElementById("80C_final").value ;	


		Field1 	= myTrim(Field1 );
		Field2 	= myTrim(Field2 );
		Field3 	= myTrim(Field3 );
		Field4 	= myTrim(Field4 );
		Field5 	= myTrim(Field5 );
		Field6 	= myTrim(Field6 );
		Field7 	= myTrim(Field7 );
		Field8 	= myTrim(Field8 );
		Field9 	= myTrim(Field9 );
		Field10 = myTrim(Field10);
		Field11 = myTrim(Field11);
		Field12 = myTrim(Field12);
		Field13 = myTrim(Field13);
		Field14 = myTrim(Field14);
		Field15 = myTrim(Field15);
		Field16 = myTrim(Field16);
		
	}catch(err)
	{
		alert(err.value);
	}
	try{
	 
	}catch(err){
		
		alert(err.value);
	}
		// Caliculation Part
		document.getElementById("80C_final").value=eval(Field1)+eval(Field2)+eval(Field3)+eval(Field4)+eval(Field5)+eval(Field6)+eval(Field7)+eval(Field8)+eval(Field9)+eval(Field10)+eval(Field11)+eval(Field12)+eval(Field13)+eval(Field14)+eval(Field15);
	
}
function validate2_1(){
		try{
			var ary=['80c_pf_estimate','80c_tution_estimate','80c_hl_estimate','80c_nsc_estimate','80c_post_estimate','80c_ul_estimate','80c_eq_estimate','80ccc_licp_estimate','80ccd_pscg_estimate','80c_sss_estimate','80c_fd_estimate','80c_mf_estimate','80c_bond_estimate','80c_others_estimate'];
			for(var i=0 ; i<ary.length ; i++){
				
				var data=document.getElementById(""+ary[i]+"").value;
				
				  data=myTrim(data);
				if(data.length==0){
					data=0;
					document.getElementById(""+ary[i]+"").value=0;
				}
			
			}
		}catch(err){
			
			alert(err.value+"@Here");
			
		}
		
}
function myTrim(x) {
	    return x.replace(/^\s+|\s+$/gm,'');
	}
