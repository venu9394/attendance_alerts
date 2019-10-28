function add80d() {	


         // alert("sdfsf");
  validate2_2();
  
  //alert("sdfsf ---334");
			var Field17 ="";
			var Field18	="";
			var Field19	="";
			var Field20	="";
			var Field21	="";
			var Field22	="";
			var Field23	="";
			var Field24	="";
			var Field25	="";
			var Field26 ="";
			
	try{
		
		
		
		Field17	= document.getElementById("FF0015").value ;
		Field18	= document.getElementById("80d_medical_estimate").value ;
		Field19	= document.getElementById("80dd_handicapped_estimate").value ;
		Field20	= document.getElementById("80ddb_treatment_estimate").value ;
		Field21	= document.getElementById("80u_disability_estimate").value ;
		Field22	= document.getElementById("80e_eduloan_estimate").value ;
		Field23	= document.getElementById("80cgg_rgsavings_estimate").value ;
		Field24	= document.getElementById("80tta_deposit_estimate").value ;
		Field25	= document.getElementById("donation_estimate").value ;
		Field26 = document.getElementById("80d_final").value ;	




		Field17	= myTrim(Field17);
		Field18	= myTrim(Field18);
		Field19 = myTrim(Field19);
		Field20	= myTrim(Field20);
		Field21	= myTrim(Field21);
		Field22	= myTrim(Field22);
		Field23	= myTrim(Field23);
		Field24	= myTrim(Field24);
		Field25	= myTrim(Field25);
		Field26 = myTrim(Field26);
		
		
	}catch(err)
	{
		alert("Error At First::"+err.value);
	}
	try{
	 document.getElementById("80d_final").value=eval(Field17)+eval(Field18)+eval(Field19)+eval(Field20)+eval(Field21)+eval(Field22)+eval(Field23)+eval(Field24)+eval(Field25);

	}catch(err){
		
		alert("Error at Second::"+err.value);
	}
		// Caliculation Part
		


}
function validate2_2(){
		
		try{
			var ary=['80d_medical_estimate','80dd_handicapped_estimate','80ddb_treatment_estimate','80u_disability_estimate','80e_eduloan_estimate','80cgg_rgsavings_estimate','80tta_deposit_estimate','donation_estimate','FF0015'];
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


