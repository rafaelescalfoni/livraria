<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tabela paginada</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	
	<style type="text/css">
table { 
    border-spacing: 0px;
    border-collapse: separate;
    width: 100%;
    border-bottom: 1px solid #aaa;
    text-align: center;
}

thead td {
    margin: 0;
    padding: 0;
    padding: 2px;
}

thead th {
    margin: 0;
    padding: 5px;
    border-bottom: 1px solid #aaa;
}

div {
    padding-top: 10px;
    text-align: center;
}

table tbody tr:nth-child(2n+1) {
background:lightgray;
}
	</style>

<script type="text/javascript">
var dados = ${data}; 
var tamanhoPagina = 3; // coloque aqui o número máximo de linhas a serem exibidas
var pagina = 0;

function paginar() {
    $('table > tbody > tr').remove();
    var tbody = $('table > tbody');
    for (var i = pagina * tamanhoPagina; i < dados.length && i < (pagina + 1) *  tamanhoPagina; i++) {
        tbody.append(
            $('<tr>')
                .append($('<td>').append(dados[i][0]))
                .append($('<td>').append(dados[i][1]))
                .append($('<td>').append(dados[i][2]))
                //aqui você coloca novas colunas, caso precise...
        )
    }
    $('#numeracao').text('Página ' + (pagina + 1) + ' de ' + Math.ceil(dados.length / tamanhoPagina));
}

function ajustarBotoes() {
    $('#proximo').prop('disabled', dados.length <= tamanhoPagina || pagina >= Math.ceil(dados.length / tamanhoPagina) - 1);
    $('#anterior').prop('disabled', dados.length <= tamanhoPagina || pagina == 0);
}

$(function() {
    $('#proximo').click(function() {
        if (pagina < dados.length / tamanhoPagina - 1) {
            pagina++;
            paginar();
            ajustarBotoes();
        }
    });
    $('#anterior').click(function() {
        if (pagina > 0) {
            pagina--;
            paginar();
            ajustarBotoes();
        }
    });
    paginar();
    ajustarBotoes();
});

</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Título</th>
				<th>Gênero</th>
				<th>Autor</th>
				<!-- coloque aqui os títulos da tabela -->
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2" align="center">Nenhum dado ainda...</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button id="anterior" disabled>&lsaquo; Anterior</button>
		<span id="numeracao"></span>
		<button id="proximo" disabled>Próximo &rsaquo;</button>
	</div>
</body>
</html>
