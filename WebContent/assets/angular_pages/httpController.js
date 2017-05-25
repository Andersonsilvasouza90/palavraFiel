var app = angular.module('HttpRequisicao',["ngRoute"]);

app.controller('getResposta', function($scope, $http){
	$scope.pegarResposta = function(){		
		$http.get("pegarResposta").then(function(response){
			document.getElementById("txtResposta1").value = response.data;
		});
	}
	
		
});


