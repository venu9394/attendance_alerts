function SingleTabSave(el){

	alert(el.id+"::bhanu");
	
	var singlesaveid=el.id;
	
	if(singlesaveid=='save1'){
		
		$.ajax({
			  type: "post",
			  url: "Tdscal",
			  data: {Type:"Section80C_Details",emp_id:$('#emp_id').val(),
				  $80c_pf_estimate:$('#80c_pf_estimate').val(),
				  $80c_tution_estimate:$('#80c_tution_estimate').val(),
				  $FF0005:$('#FF0005').val(),
				  $80c_hl_estimate:$('#80c_hl_estimate').val(),
				  $80c_nsc_estimate:$('#80c_nsc_estimate').val(),
				  $80c_post_estimate:$('#80c_post_estimate').val(),
				  $80c_ul_estimate:$('#80c_ul_estimate').val(),
				  $80c_eq_estimate:$('#80c_eq_estimate').val(),
				  $80ccc_licp_estimate:$('#80ccc_licp_estimate').val(),
				  $80ccd_pscg_estimate:$('#80ccd_pscg_estimate').val(),
				  $80c_sss_estimate:$('#80c_sss_estimate').val(),
				  $80c_fd_estimate:$('#80c_fd_estimate').val(),
				  $80c_mf_estimate:$('#80c_mf_estimate').val(),
				  $80c_bond_estimate:$('#80c_bond_estimate').val(),
				  $80c_others_estimate:$('#80c_others_estimate').val(),
				  $80C_final:$('#80C_final').val(),
				  },
			  success: function(responseData, textStatus, jqXHR) {
				  alert(responseData);
				  
				  
				  
			  },
			  error: function(jqXHR, textStatus, errorThrown) {
				  console.log(errorThrown);
				  alert("Error;;;;");
			  }
		  });		
	}
	
	
	
}