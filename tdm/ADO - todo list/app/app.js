let app = angular.module("todo-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            redirectTo: "/tarefas"
        })
        .when(
            "/tarefas", {
                controller: "tarefasCtrl",
                templateUrl: "app/views/lista-tarefas.html"
            }
        )
});