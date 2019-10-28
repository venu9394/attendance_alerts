$( "#datepicker" ).datepicker({
			//inline: true
			changeMonth: true,
			changeYear: true,
			dateFormat: 'dd-mm-yy',
			//minDate: '0'
		});
		$( "#datepicker1" ).datepicker({
			//inline: true
			changeMonth: true,
			changeYear: true,
			dateFormat: 'dd-mm-yy',
			minDate: '0'
		});
		$( "#datepicker2" ).datepicker({
			//inline: true
			changeMonth: true,
			changeYear: true,
			dateFormat: 'dd-mm-yy',
			minDate: '0'
		});
		$( "#datepicker3" ).datepicker({
			//inline: true
			changeMonth: true,
			changeYear: true,
			dateFormat: 'dd-mm-yy',
			minDate: '0'
		});
		$( "#datepicker4" ).datepicker({
			//inline: true
			changeMonth: true,
			changeYear: true,
			dateFormat: 'dd-mm-yy',
			minDate: '0'
		});

		//Hover states on the static widgets
		$( "#dialog-link, #icons li" ).hover(
			function() {
				$( this ).addClass( "ui-state-hover" );
			},
			function() {
				$( this ).removeClass( "ui-state-hover" );
			}
		);