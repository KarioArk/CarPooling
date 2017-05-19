'use strict';

angular.module('carPooling', ['TestService','TestController']).config(['$stateProvider', function($stateProvider){
	$stateProvider.state('jab-ui-app', {
		url: '',
		templateUrl: '/UserSignUp.html',
		controller: 'TestController',
		controllerAs: 'testController'
	});
}]);