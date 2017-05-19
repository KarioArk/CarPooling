var app = angular.module('offerRideController', [ 'ngMaterial', 'ngMessages' ]);

app.controller('offerRide', function($scope) {

	$scope.seats = [ "1", "2", "3" ];

	function dateController($scope) {
		$scope.myDate = new Date();
		$scope.minDate = new Date($scope.myDate.getFullYear(), $scope.myDate
				.getMonth() - 2, $scope.myDate.getDate());
		$scope.maxDate = new Date($scope.myDate.getFullYear(), $scope.myDate
				.getMonth() + 2, $scope.myDate.getDate());
		$scope.onlyWeekendsPredicate = function(date) {
			var day = date.getDay();
			return day === 0 || day === 6;
		}
	}
});
