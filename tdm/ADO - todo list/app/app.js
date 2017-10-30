let app = angular.module("todo-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when(
            "/tarefas", {
                controller: "tarefasCtrl",
                templateUrl: "app/views/lista-tarefas.html"
            }
        )
        .when(
            "/tarefa/:guid", {
                controller: "tarefasCtrl",
                templateUrl: "app/views/editar-tarefa.html"
            }
        )
        .otherwise({
            redirectTo: "/tarefas"
        })
});