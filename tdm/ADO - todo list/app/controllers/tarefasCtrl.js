app.controller("tarefasCtrl", function ($scope, $routeParams) {
    function Model(i, p, t, f) {
        this.id = i;
        this.prazo = p;
        this.tarefa = t;
        this.feito = f;
    };

    function atualizaModelTarefas() {
        $scope.tarefas = todo_storage.getAll();
        $scope.possuiTarefas = $scope.tarefas.length > 0;
    }

    atualizaModelTarefas($scope);
    $scope.produtoEdicao = null;
    $scope.tarefaModel = new Model();

    $scope.onclickFeito = function (event, task) {
        task.feito = event.currentTarget.checked
        todo_storage.editar(task);
        atualizaModelTarefas();
    }

    $scope.onclickNovaTarefa = function (event) {
        var _model = new Model(Math.floor(Math.random() * 1000), getDataStr($scope.tarefaModel.prazo), $scope.tarefaModel.tarefa, false);
        todo_storage.salvar(_model);
        $scope.tarefaModel = new Model();
        atualizaModelTarefas();
    }

    $scope.onclickEditar = function (event) {
        todo_storage.editar({
            id: $scope.produtoEdicao.id,
            prazo: getDataStr($scope.produtoEdicao.prazo),
            tarefa: $scope.produtoEdicao.tarefa,
            feito: $scope.produtoEdicao.feito
        });
        $scope.produtoEdicao = null;
        atualizaModelTarefas();
        window.location = "#!/tarefas";
    }
    let indexObjEdicao = $scope.tarefas.findIndex(x => x.id == $routeParams.guid);
    if (indexObjEdicao > -1) {
        $scope.produtoEdicao = $scope.tarefas[indexObjEdicao];
        $scope.produtoEdicao.prazo = stringToDate($scope.produtoEdicao.prazo)
    }
});