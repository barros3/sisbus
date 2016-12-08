<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<script>
	$("#timeEscala").setMask("29:59:59").keypress(function() {
		var currentMask = $(this).data('mask').mask;
		var newMask = $(this).val().match(/^2.*/) ? "23:59:59" : "29:59:59";
		if (newMask != currentMask) {
			$(this).setMask(newMask);
		}
	});
	
	function validarHoraExtra(){
		if(document.getElementById("horaExtra").checked === true){
			document.getElementById("limiteHoraExtra").disabled === true;
		}else{
			document.getElementById("limiteHoraExtra").disabled === false;
		}
	}
</script>




<div class="row" style="margin-top: -20px">
    <div class="col s12 m12 l8">
        <div class="card grey lighten-5">
            <div class="card-content ">
                <span class="card-title">Cadastro de Escala</span>
                <div class="align-rows form-usual">
                <div class="title-divisor">
                   <!--  <h6>Dados para o registro</h6> -->
                </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="codigoVeiculo">Código do Veículo<span style="color: red;">*</span></label>
							<form:input path='codigoVeiculo' type='text' class="form-control" placeholder="Ex: 123wEr3" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 20 caracteres"/>
							<form:errors path='codigoVeiculo' cssStyle="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="itinerario">Itinerário<span style="color: red;">*</span></label>
							<form:input path='itinerario' type='text' class="form-control" placeholder="Ex: 123wEr3" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 20 caracteres"/>
							<form:errors path='itinerario' cssStyle="color: red;"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s12">
							<label for="horaEntrada">Hora da entrada</label>
							<form:input path='horaEntrada' id="horaEntrada" type="time" class="form-control" />
							<form:errors path='horaEntrada' cssStyle="color: red;"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="matriculaFuncionario">Matrícula do Funcionário<span style="color: red;">*</span></label>
							<form:input path='matriculaFuncionario' type='text' class="form-control" />
							<form:errors path='matriculaFuncionario' cssStyle="color: red;"/>
                        </div>
                        <div class="form-group col s6">
							<label for="dataEscala">Data da Escala</label>
							<form:input path='dataEscala' id="dataEntrada" type='date' class="form-control" />
							<form:errors path='dataEscala' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
							<label for="horaExtra">Hora extra</label>
							<form:checkbox path='horaExtra' class="form-control" id="horaExtra" onchange="validarHoraExtra()"/>
							<form:errors path='horaExtra' cssStyle="color: red;"/>
                        </div>
                        <div class="form-group col s6">
							<label for="limiteHoraExtra">Limite de Hora Extra</label>
							<form:input path='limiteHoraExtra' type='number' disabled="true" class="form-control" />
							<form:errors path='limiteHoraExtra' cssStyle="color: red;"/>
                        </div>
                    </div>
                    
            </div>
            <div class="card-action">
                <button type="submit" href="#" class="btn btn-success  green darken-1 btn-large">Cadastrar</button>
                <a href="#" class="btn btn-default btn-large  blue-grey darken-1">Cancelar</a>
            </div>
        </div>
    </div>
</div>



<%-- 











<div class="form-group">
	<label for="codigoVeiculo">Código do Veículo<span style="color: red;">*</span></label>
	<form:input path='codigoVeiculo' type='text' class="form-control" placeholder="Ex: 123wEr3" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 20 caracteres"/>
	<form:errors path='codigoVeiculo' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="itinerario">Itinerário<span style="color: red;">*</span></label>
	<form:input path='itinerario' type='text' class="form-control" />
	<form:errors path='itinerario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="horaEntrada">Hora da entrada</label>
	<form:input path='horaEntrada' id="horaEntrada" type="time" class="form-control" />
	<form:errors path='horaEntrada' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="matriculaFuncionario">Matrícula do Funcionário<span style="color: red;">*</span></label>
	<form:input path='matriculaFuncionario' type='text' class="form-control" />
	<form:errors path='matriculaFuncionario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="dataEscala">Data da Escala</label>
	<form:input path='dataEscala' id="dataEntrada" type='date' class="form-control" />
	<form:errors path='dataEscala' />
</div>
<div class="form-group">
	<label for="horaExtra">Hora extra</label>
	<form:checkbox path='horaExtra' class="form-control" id="horaExtra" onchange="validarHoraExtra()"/>
	<form:errors path='horaExtra' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="limiteHoraExtra">Limite de Hora Extra</label>
	<form:input path='limiteHoraExtra' type='number' disabled="true" class="form-control" />
	<form:errors path='limiteHoraExtra' cssStyle="color: red;"/>
</div> --%>