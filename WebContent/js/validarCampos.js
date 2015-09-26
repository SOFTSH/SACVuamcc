        function soloLetras(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /[A-Za-zñÑ\s]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        function especiales(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /[.q@$_-\w]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        function numYletras(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /[nÑ\s|\w]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        function soloNumeros(e){
        	var key = window.Event ? e.which : e.keyCode
        	return (key >= 48 && key <= 57)
        }
