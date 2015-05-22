app.controller('LoginCtrl', function($scope, $location) {
  $scope.user = {
    name: '',
    email: '',
    phone: '',
    address: 'Mountain View, CA'
  };

  $scope.go = function(path) {
    $location.path(path);
  };
});
