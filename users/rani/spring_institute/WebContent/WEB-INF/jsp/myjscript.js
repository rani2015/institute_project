function goBack() {
	window.history.back();
}
function validate(val) {
	if (val.value == "") {
		alert("Please Enter Value in " + val.name);
	}
}
function phonecheck(pNo, evt) {

	var charCode = evt.keyCode;
	var val = pNo.value;
	if (isNaN(pNo)) {
		if (charCode == 8 || charCode == 46) {

			if (val.length == 4) {
				pNo.value = val.substring(0, 3);
			} else if (val.length == 8) {
				pNo.value = val.substring(0, 7);
			}

		} else {

			if (val.length == 3) {
				pNo.value = val + '-';
			} else if (val.length == 7) {
				pNo.value = val + '-';
			}
		}
	}
}

function isNumberKey(evt) {

	var charCode = (evt.which) ? evt.which : evt.keyCode;

	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}
