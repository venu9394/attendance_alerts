// document.getElementById("").value='';

// Organization
function selectvalue(val){
	//alert("a::");
	var a=0;
	document.getElementById("donation_estimate").value=0;
	if(val.value!="Select Organization"){
		
	
	 a = val.value.split("~")[0];
	  document.getElementById("selectvalue_1s").value=a;
	  if(eval(a)==501){
		  document.getElementById("selectvalue_1").innerHTML="<font size='1px' color='red'>50% considered subject to 10% of adjusted gross total Income</font>";
	  }else if(eval(a)==101){
		  document.getElementById("selectvalue_1").innerHTML="<font size='1px' color='red'>100% considered subject to 10% of adjusted gross total Income</font>";
	  }else {
		  document.getElementById("selectvalue_1").innerHTML="<font size='1px' color='red'> "+a+"% considered &nbsp;&nbsp;</font>";
	  }
	
	
	
	document.getElementById("donation_estimate").readOnly=false;
	document.getElementById("donation_estimate").focus();
	}
	else{
		document.getElementById("selectvalue_1s").value=0;
		document.getElementById("selectvalue_1").innerHTML='';
		document.getElementById("donation_estimate").value=0;
		document.getElementById("donation_estimate").readOnly=true;
		//document.getElementById("donation_estimate").readonly=true;
	}
}


//House rent Validation

function housing(val){
	//alert(val);
							document.getElementById("address").value='';
							document.getElementById("pancard").value='';
							document.getElementById("rent_amount").value='';
							document.getElementById("bankname").value='';
							document.getElementById("loanamount").value='';
							document.getElementById("datepicker").value='';
							document.getElementById("principal_amount").value='';
							document.getElementById("interest").value='';
							document.getElementById("propertyincome").value='';
							document.getElementById("renttype").value=val.value;
	if(val.value=="rent"){
		document.getElementById("house1").style.display='';
		document.getElementById("house2").style.display='none';
		document.getElementById("house3").style.display='none';
	}else if(val.value=="ownhouse"){
		document.getElementById("house1").style.display='none';
		document.getElementById("house2").style.display='';
		document.getElementById("house3").style.display='';
		
	}else if(val.value=="ownhousewithproperty"){
		document.getElementById("house1").style.display='';
		document.getElementById("house2").style.display='';
		document.getElementById("house3").style.display='';
	}else{
		document.getElementById("renttype").value='rent';
	}
	
}

// Education loanamount validation
function eduloan(val) {

		//alert(val);

		
		if(val.value=="1"){
		document.getElementById("child_table").style.display='';	
		document.getElementById("one_child").style.display='';
		document.getElementById("two_child").style.display='none';
		
	}else if(val.value=="2"){
	
		document.getElementById("child_table").style.display='';
		document.getElementById("one_child").style.display='';
		document.getElementById("two_child").style.display='';
		
	
	}else{
		document.getElementById("one_child").style.display='none';
		document.getElementById("two_child").style.display='none';
		document.getElementById("child_table").style.display='none';
	}

			document.getElementById("child1").value='';
			document.getElementById("child1_studying").value='';
			document.getElementById("child1_school_college").value='';
			document.getElementById("child2").value='';
			document.getElementById("child2_studying").value='';
			document.getElementById("child2_school_college").value='';
			
			
			
			
}



//LTA validation
function  lta_drop(val){
		//alert(val);
		document.getElementById("lta_estimate").value='';
		if(val.value=="no"){
			document.getElementById("lta_table").style.display='';
			document.getElementById("tr_1").style.display='';
			document.getElementById("tr_2").style.display='';
			document.getElementById("lta_estimate").readOnly=false;
			document.getElementById("lta_estimate").focus();
			
		}else if(val.value=="yes") {
			document.getElementById("lta_table").style.display='none';
			document.getElementById("lta_estimate").value=0;
			document.getElementById("lta_estimate").readOnly=true;
		}else{
			document.getElementById("lta_table").style.display='none';
			document.getElementById("lta_estimate").readOnly=true;
			
		}
		document.getElementById("lta_estimate").value='';
		document.getElementById("lta_actual").value='';
		document.getElementById("datepicker1").value='';
		document.getElementById("datepicker2").value='';
		document.getElementById("place1").value='';
		document.getElementById("place2").value='';
		document.getElementById("employee_lta").value='';
		document.getElementById("lta_estimate_1").value='';
		document.getElementById("lta_actual_1").value='';
		document.getElementById("datepicker3").value='';
		document.getElementById("datepicker4").value='';
		document.getElementById("place1_2").value='';
		document.getElementById("place2_2").value='';
		document.getElementById("employee_lta_2").value='';
		document.getElementById("lta_estimate_2").value='';
		document.getElementById("lta_actual_2").value='';
		
			
}

 function ltacalculate(){


var lta1=document.getElementById("lta_estimated_amount_1").value;
var lta2=document.getElementById("lta_estimated_amount_2").value;


if (eval(lta2)==null){
lta2=0;
}
if(eval(lta1)==null){
lta1=0;

}

var k=eval(lta1)+eval(lta2);
document.getElementById("lta_estimate").value=k;

}

// Section 80D 80D(2B),80DD,80DDB,80E,80EE,80GG,80U,80CCG,80TTA Validation


function section80D() {
	
	document.getElementById("FF0010").value='';
	document.getElementById("FF0011").value='';
	document.getElementById("FF0012").value='';
	document.getElementById("FF0013").value='';
	document.getElementById("FF0014").value='';
	document.getElementById("FF0015").value='';
	document.getElementById("80d_medical_estimate").value='';
	document.getElementById("80d_medical_actual").value='';
	document.getElementById("80DD").value='';
	document.getElementById("80DD_1").value='';
	document.getElementById("80dd_handicapped_estimate").value='';
	document.getElementById("80dd_handicapped_actual").value='';
	document.getElementById("80DDB").value='';
	document.getElementById("80DDB_1").value='';
	document.getElementById("80ddb_treatment_estimate").value='';
	document.getElementById("80ddb_treatment_actual").value='';
	document.getElementById("80U").value='';
	document.getElementById("80U_1").value='';
	document.getElementById("80u_disability_estimate").value='';
	document.getElementById("80u_disability_actual").value='';
	document.getElementById("80e_eduloan_estimate").value='';
	document.getElementById("80e_eduloan_actual").value='';
	document.getElementById("80cgg_rgsavings_estimate").value='';
	document.getElementById("80cgg_rgsavings_actual").value='';
	document.getElementById("org").value='';
	document.getElementById("selectvalue_1").value='';
	document.getElementById("donation_estimate").value='';
	document.getElementById("donation_actual").value='';
}	

	
// Section 80

function  section80() {




	document.getElementById("80c_pf_estimate").value='';
	document.getElementById("80c_pf_actual").value='';
	document.getElementById("80c_tution_estimate").value='';
	document.getElementById("80c_tution_actual").value='';
	document.getElementById("FF0005").value='';
	document.getElementById("80c_lic_actual").value='';
	document.getElementById("FF0001").value='';
	document.getElementById("FF0002").value='';
	document.getElementById("FF0003").value='';
	document.getElementById("FF0004").value='';
	document.getElementById("80c_hl_estimate").value='';
	document.getElementById("80c_hl_actual").value='';
	document.getElementById("80c_nsc_estimate").value='';
	document.getElementById("80c_nsc_actual").value='';
	document.getElementById("80c_post_estimate").value='';
	document.getElementById("80c_post_actual").value='';
	document.getElementById("80c_ul_estimate").value='';
	document.getElementById("80c_ul_actual").value='';
	document.getElementById("80c_eq_estimate").value='';
	document.getElementById("80c_eq_actual").value='';
	document.getElementById("80ccc_licp_estimate").value='';
	document.getElementById("80ccc_licp_actual").value='';
	document.getElementById("80ccd_pscg_estimate").value='';
	document.getElementById("80ccd_pscg_actual").value='';
	document.getElementById("80c_sss_estimate").value='';
	document.getElementById("80c_sss_actual").value='';
	document.getElementById("80c_others").value='';
	document.getElementById("80c_others_estimate").value='';
	document.getElementById("80c_others_actual").value='';
	
	
	
	
}
//Employee details

function employee()  {
	
	
	document.getElementById("emp_id").value='';
	document.getElementById("emp_fullname").value='';
	document.getElementById("emp_designation").value='';
	document.getElementById("emp_department").value='';
	document.getElementById("emp_address").value='';
	document.getElementById("emp_contact").value='';
	document.getElementById("emp_region").value='';
	document.getElementById("emp_age").value='';
	
	
	
	
	
}
// Other Income
function otherincome(){
	
	
	document.getElementById("other_income_estimate").value='';
	document.getElementById("other_income_actual").value='';
}

//80DD Severity
function section80DD(val) {
	
	document.getElementById("80dd_handicapped_estimate").value=0;
	if(val.value=="80DD_limit1"){
		 document.getElementById("80DD_1").innerHTML = "<font size='1px' color='red'>Max Limit is Rs.75,000</font>";
		 document.getElementById("80dd_handicapped_estimate").readOnly=false;
		 document.getElementById("80dd_handicapped_estimate").focus();
	}else if(val.value=="80DD_limit2"){
		 document.getElementById("80DD_1").innerHTML = "<font size='1px' color='red'>Max Limit is Rs.1,25,000</font>";
		 document.getElementById("80dd_handicapped_estimate").readOnly=false;
		 document.getElementById("80dd_handicapped_estimate").focus();
	}else{
		document.getElementById("80DD_1").innerHTML='';
		document.getElementById("80dd_handicapped_estimate").value=0;
		document.getElementById("80dd_handicapped_estimate").readOnly=true;
		
	}
    

}	

//80DDB severity
function section80DDB(val) {
	
	document.getElementById("80ddb_treatment_estimate").value=0;
	if(val.value=="80DDB_limit1"){
		 document.getElementById("80DDB_1").innerHTML = "<font size='1px' color='red'>Lower of Rs.40,000 or the amount actually paid</font>";
		 document.getElementById("80ddb_treatment_estimate").readOnly=false;
		 document.getElementById("80ddb_treatment_estimate").focus();
	}else if(val.value=="80DDB_limit2"){
		 document.getElementById("80DDB_1").innerHTML = "<font size='1px' color='red'>Lower of Rs.60,000 or the amount actually paid</font>";
		  document.getElementById("80ddb_treatment_estimate").readOnly=false;
		 document.getElementById("80ddb_treatment_estimate").focus();
	}else if(val.value=="80DDB_limit3"){
		 document.getElementById("80DDB_1").innerHTML = "<font size='1px' color='red'>Lower of Rs.80,000 or the amount actually paid</font>";
		  document.getElementById("80ddb_treatment_estimate").readOnly=false;
		 document.getElementById("80ddb_treatment_estimate").focus();
	}else{
		document.getElementById("80DDB_1").innerHTML='';
		document.getElementById("80ddb_treatment_estimate").value=0;
		document.getElementById("80ddb_treatment_estimate").readOnly=true;
		
	}
    

}	

//80U severity
function section80U(val) {
	
	document.getElementById("80u_disability_estimate").value=0;
	if(val.value=="80U_limit1"){
		 document.getElementById("80U_1").innerHTML = "<font size='1px' color='red'>Max Limit is Rs.75,000</font>";
		 document.getElementById("80u_disability_estimate").readOnly=false;
		 document.getElementById("80u_disability_estimate").focus();
	}else if(val.value=="80U_limit2"){
		 document.getElementById("80U_1").innerHTML = "<font size='1px' color='red'>Max Limit is Rs.1,25,000</font>";
		 document.getElementById("80u_disability_estimate").readOnly=false;
		 document.getElementById("80u_disability_estimate").focus();
	}else{
		document.getElementById("80U_1").innerHTML='';
		document.getElementById("80u_disability_estimate").value=0;
		document.getElementById("80u_disaability_estimate").readOnly=true;
		
	}
    

	
}
/* Null value equal to zero*/
function myTrim(x) {
	    return x.replace(/^\s+|\s+$/gm,'');
	}

/*Section 80C*/
/* Id values 
'80c_pf_estimate' , '80c_tution_estimate' , 'FF0005' , 'FF0001' , 'FF0002' , 'FF0003' , 'FF0004' , '80c_hl_estimate' , '80c_nsc_estimate' , '80c_post_estimate' , '80c_ul_estimate' , '80c_eq_estimate' , '80ccc_licp_estimate' , '80ccd_pscg_estimate' , '80c_sss_estimate' , '80c_fd_estimate' , '80c_mf_estimate' , '80c_bond_estimate' , '80c_others_estimate'
*/
function validate1(){
		
		     alert("56565");
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
/* Section 80D 80D(2B),80DD,80DDB,80E,80EE,80GG,80U,80CCG,80TTA */
/* ID values
'FF0015','FF0010','FF0011','FF0012','FF0013','FF0014','80d_medical_estimate','80dd_handicapped_estimate','80ddb_treatment_estimate','80u_disability_estimate','80e_eduloan_estimate','80cgg_rgequity_estimate','80tta_deposit_estimate','donation_estimate'

*/
function validate2(){
		
		try{
			var ary=['80d_medical_estimate','80dd_handicapped_estimate','80ddb_treatment_estimate','80u_disability_estimate','80e_eduloan_estimate','80cgg_rgequity_estimate','80tta_deposit_estimate','donation_estimate'];
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
/* House Exemption */	
/* ID Values
'renttype','rentonly','address','pancard','rent_amount','bankname','loanamount','datepicker','principal_amount','interest','propertyincome','80ee_interestedu_estimate'
*/
function validate3(){
		
		try{
			var ary=['rent_amount','principal_amount','interest','propertyincome','80ee_interestedu_estimate'];
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
/* Other Income */
/* ID Values
'other_income_estimate'
*/
function validate4(){
		
		try{
			var ary=['other_income_estimate'];
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
/*Section 10*/
/* ID Values
'lta_estimated_amount_1','lta_estimated_amount_2'
*/
function validate5(){
		
		try{
			var ary=['lta_estimated_amount_1','lta_estimated_amount_2'];
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
/*Addition*/
/* Section 80c*/
	
