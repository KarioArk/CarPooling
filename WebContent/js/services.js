var services = angular.module('TestService', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/RestWLPTest/rest/users', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});