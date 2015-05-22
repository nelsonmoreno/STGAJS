app.controller('RegistroCtrl', function($scope, $location, userService) {
  $scope.user = {
    name: '',
    email: '',
    phone: '',
    disclamer: 'No',
    address: ''
  };

  $scope.go = function(path) {
    $location.path(path);
  };

  $scope.doRegister = function() {
    userService.persist($scope.user, function(response) {
      if (null != response) {
        console.log(response);
        if (response == "FAILURE") {
          console.log('fallo...!');
        } else {
          console.log('exito...!');
          $scope.go('/registroexitoso');
        }
      }
    });
  };

});
