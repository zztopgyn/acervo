angular.module("acervo").controller("artistaCtrl", function ($scope, $http) {
		$scope.novoArtista = function (artista) {
			$http.post("artista/novo", artista).success(function (resultadoDoResponse) {
				$scope.artista = resultadoDoResponse;
			});
		};		
	});
