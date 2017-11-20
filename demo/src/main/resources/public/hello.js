//$(document).ready(function() {
//	$.ajax({
//		url : "http://localhost:8080/user/7"
//	}).then(function(data, status, jqxhr) {
//		$('.userId').append(data.id);
//		$('.userName').append(data.name);
//		console.log(jqxhr);
//	});
//});

 angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/user/7').
        then(function(response) {
            $scope.user = response.data;
        });
});

