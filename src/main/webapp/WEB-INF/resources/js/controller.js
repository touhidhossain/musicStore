/**
 * Created by root on 10/4/16.
 */
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {
    $scope.refreshCart = function (cartId){
        $http.get('/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };
    
    $scope.clearCart = function () {
        $http.delete('/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };
    
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    $scope.addToCart = function (productID) {
        $http.put('/rest/cart/add/'+productID).success(function (data) {
            $scope.refreshCart($http.get('/rest/cart/get/cartId'));
            alert("Product successfully added to the cart.");
        });
    };

    $scope.removeFromCart = function (productID) {
        $http.put('/rest/cart/remove/'+productID).success(function (data) {
            $scope.refreshCart($http.get('/rest/cart/get/cartId'));
        });
    };
});
