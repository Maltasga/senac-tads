app.controller("tarefasCtrl", function ($scope, $http) {
    $scope.tarefas = [{
        id: 1,
        feito: false,
        prazo: "03/11/2017",
        tarefa: "inscrição randonneurs litoral"
    }];

    $scope.possuiTarefas = $scope.tarefas.length > 0;

    $scope.onclickFeito = function (event, id) {
        let index = $scope.tarefas.findIndex(x => x.id == id);
        $scope.tarefas[index].feito = event.currentTarget.checked;
    }
});