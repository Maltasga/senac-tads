let app = angular.module("loja", ["ngRoute"]);

app.config(($routeProvider) => {
    $routeProvider
            .when("/", {
                "templateUrl": "views/principal.html",
                controller: "lojaCtrl"
            })
            .when("/produto/:id", {
                "templateUrl": "views/produto.html",
                controller: "lojaCtrl"
            })
            .otherwise({
                "redirectTo": "http://i0.kym-cdn.com/photos/images/newsfeed/000/096/044/trollface.jpg?1296494117"
            });
});

app.controller("lojaCtrl", function ($scope, $http, $routeParams) {
    $scope.min = 0;
    $scope.max = 10000;

    $http({
        url: "produtos.json",
        method: "get"
    }).then(response => {
        $scope.produtos = response.data;

        $scope.queryId = $routeParams.id;
    });

    $scope.filtro = function (valor, indice, vetor) {
        return valor.preco >= $scope.min && valor.preco <= $scope.max;
    }
});