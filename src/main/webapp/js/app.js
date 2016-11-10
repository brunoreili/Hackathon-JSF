var App = angular.module('App', [
'ngRoute',
'controllers',
'services'
]);

App.config(function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})

	.when('/create', {
		templateUrl: 'views/create.html',
		controller: 'CreateCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
});

App.value('API', 'http://localhost:8080/primefaces-app/service/');