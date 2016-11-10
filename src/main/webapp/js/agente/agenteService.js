App.factory('AgenteService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'agente');
		},
		create: function(item){
			return $http.post(API+'agente', item);
		},
		update: function(item, id){
			return $http.put(API+'agente/'+id, item);	
		},
		delete: function(id){
			return $http.delete(API+'agente/'+id);
		}
	}
})