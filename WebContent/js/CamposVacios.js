function loginValidate() {
	if (document.formLogin.empleado.value == "") {
		alert("Por favor ingresa un número de empleado");
		document.formLogin.empleado.select();
		return false;
	}
	if (document.formLogin.contrasenia.value == "") {
		alert("Por favor ingresa una contraseña");
		document.formLogin.contrasenia.select();
		return false;
	}
}
function cambioValidate() {
	if (document.cambio.new_contra.value == "") {
		alert("Por favor ingresa un número de empleado");
		document.cambio.new_contra.select();
		return false;
	}
	if (document.cambio.new_contra1.value == "") {
		alert("Por favor ingresa una contraseña");
		document.cambio.new_contra1.select();
		return false;
	}
}
function UsuarioValidate() {
	if (document.FormRegistro.contrsenia.value == "") {
		smoke.alert("El campo es obligatorio");
		document.FormRegistro.nombre.select();
		return false;
	}
	if (document.FormRegistro.nombre.value.length > 50) {
		smoke
				.alert("El campo no puede exceder los 50 caracteres, por favor valide");
		document.FormRegistro.nombre.select();
		return false;
	}
	if (document.FormRegistro.paterno.value == "") {
		smoke.alert("El campo es obligatorio");
		document.FormRegistro.paterno.select();
		return false;
	}
	if (document.FormRegistro.paterno.value.length > 50) {
		smoke
				.alert("El campo no puede exceder los 50 caracteres, por favor valide");
		document.FormRegistro.paterno.select();
		return false;
	}
	if (document.FormRegistro.materno.value == "") {
		smoke.alert("El campo es obligatorio");
		document.FormRegistro.materno.select();
		return false;
	}
	if (document.FormRegistro.materno.value.length > 50) {
		smoke
				.alert("El campo no puede exceder los 50 caracteres, por favor valide");
		document.FormRegistro.materno.select();
		return false;
	}
	if (document.FormRegistro.login.value == "") {
		smoke.alert("El campo es obligatorio");
		document.FormRegistro.login.select();
		return false;
	}
	if (document.FormRegistro.login.value.length > 15) {
		smoke
				.alert("El campo no puede exceder los 15 caracteres, por favor valide");
		document.FormRegistro.login.select();
		return false;
	}
	if (document.FormRegistro.password.value == "") {
		smoke.alert("El campo es obligatorio");
		document.FormRegistro.password.select();
		return false;
	}
	if (document.FormRegistro.password.value.length > 15) {
		smoke
				.alert("El campo no puede exceder los 15 caracteres, por favor valide");
		document.FormRegistro.password.select();
		return false;
	}
}
	
	function TemaValidate(){
		if (document.formTema.descripcion.value == "") {
			smoke.alert("El campo es Descripci&oacuten es obligatorio");
			document.formTema.descripcion.select();
			return false;
		}
		if (document.formTema.descripcion.value.length > 100) {
			smoke
					.alert("El campo Descripci&oacuten no puede exceder los 100 caracteres, por favor valide");
			document.formTema.descripcion.select();
			return false;
		}
}
	function CambioContraValidate(){
		if (document.FormPass.contra_anterior.value == "") {
			smoke.alert("Falt&oacute introducir la contrase&ntildea anterior");
			document.FormPass.contra_anterior.select();
			return false;
		}
		if (document.FormPass.new_contra.value=="") {
			smoke
					.alert("Falt&oacute introducir la nueva contrase&ntildea");
			document.FormPass.new_contra.select();
			return false;
		}
		if (document.FormPass.new_contra1.value=="") {
			smoke
					.alert("Falt&oacute repetir la nueva contrase&ntildea");
			document.FormPass.new_contra1.select();
			return false;
		}
	}
	
	
	function AportacionValidate() {
		if (document.formAportacion.opinion.value == "") {
			smoke.alert("El campo es obligatorio");
			document.formAportacion.opinion.select();
			return false;
		}
		if (document.formAportacion.opinion.value.length > 500) {
			smoke
					.alert("El campo no puede exceder los 500 caracteres, por favor valide");
			document.formAportacion.opinion.select();
			return false;
		}
	}