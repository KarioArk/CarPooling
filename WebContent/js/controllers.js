var app = angular.module('TestController', []);

app.controller('myCtrl', function($scope, $http, $location) {

	$scope.user = {
			cdsid : "",
			mobileNumber : "",
			gender : ""
	};

	$scope.getRoutes = function()
	{
		$http.get("rest/users").then(function(response) {
			$scope.User = response.data;
		});		
	};
	
	$scope.offerRide = function(){
		$location.path("offerRide.html");
		}
	
	$scope.SendData = function() {

		console.log("posting data....");

		/*
		 * var data = $.param({ fName: $scope.firstName, lName: $scope.lastName
		 * });
		 */
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}

		$http.post('rest/users/userService', angular.toJson($scope.user),
				config).success(function(response) {
			$scope.PostDataResponse = response.data;
		}).error(function() {
			$scope.PostDataResponse = "Data: " + response.data;
		});
	};
});
/*
 * app.controller('MyCtrl1', ['$scope', 'UserFactory', function ($scope,
 * UserFactory) { console.log("Before method"); UserFactory.get({}, function
 * (userFactory) { console.log("Before Scope"); $scope.firstName =
 * userFactory.firstName; console.log("afer Scope"); console.log($scope); })
 * this.getName = function () { console.log("Before Scope"); $scope.firstName =
 * UserFactory.firstName; console.log("afer Scope"); console.log($scope); };
 * }]);
 */

