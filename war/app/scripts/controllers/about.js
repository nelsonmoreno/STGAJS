'use strict';

/**
 * @ngdoc function
 * @name warApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the warApp
 */
angular.module('StarterApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
