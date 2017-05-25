var app = angular.module('palavraFiel',["ngRoute"]);

app.controller('getNoticia', function($scope, $http){
	$scope.listarNoticias = function(){		
		$http.get("noticias/listar").then(function(response){
			$scope.jsonNoticias = response.data;
		});
	}
	
		
});


