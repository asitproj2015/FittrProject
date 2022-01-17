function validate(frm){
		//empty the document validation error messages
		
		document.getElementById("passworderror").innerHTML="";
		
		//read from data
		let password=frm.psw.value;
		let conform=frm.pswrepeat.value;
		
		//clint side from validations
		let flag=true;
		if (password !=conform) {
			document.getElementById("passworderror").innerHTML="Password Not Match";
			frm.pswrepeat.focus();
			flag= false;
		}
		console.log(flag);
		return flag;
		
	}