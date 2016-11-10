var App = angular.module('services', []);

App.service('EnvioService', function($http){
	var parametro = {};

	  var addParametro = function(newObj) {
		  parametro = newObj;
	  };

	  var getParametro = function(){
	      return parametro;
	  };

	  return {
		  addParametro: addParametro,
		  getParametro: getParametro
	  };

})