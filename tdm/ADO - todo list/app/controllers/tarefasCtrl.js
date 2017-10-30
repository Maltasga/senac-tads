app.controller("tarefasCtrl", function ($scope, $location, $routeParams) {
    function Model(i, p, t, f) {
        this.id = i;
        this.prazo = p;
        this.tarefa = t;
        this.feito = f;

        this.getDataStr = function () {
            var dia = "",
                mes = "",
                ano = 0;
            dia = (function (d) {
                if (d < 9) return "0" + d;
                return "" + d;
            })(this.prazo.getDate());
            mes = (function (m) {
                m += 1;
                if (m < 9) return "0" + m;
                return "" + m;
            })(this.prazo.getMonth());
            ano = this.prazo.getFullYear();
            return dia + "/" + mes + "/" + ano;
        }
    };

    function stringToDate(str) {
        return new Date(str.split("/").reverse())
    }

    function atualizaModelTarefas() {
        $scope.tarefas = todo_storage.getAll();
        $scope.possuiTarefas = $scope.tarefas.length > 0;
    }

    atualizaModelTarefas($scope);
    $scope.produtoEdicao = null;
    $scope.tarefaModel = new Model();

    $scope.onclickFeito = function (event, task) {
        todo_storage.editar({
            id: task.id,
            prazo: task.prazo,
            tarefa: task.tarefa,
            feito: event.currentTarget.checked
        });
        atualizaModelTarefas();
    }

    $scope.onclickNovaTarefa = function (event) {
        var _model = new Model(Math.floor(Math.random() * 1000), $scope.tarefaModel.getDataStr(), $scope.tarefaModel.tarefa, false);
        todo_storage.salvar(_model);
        $scope.tarefaModel = new Model();
        atualizaModelTarefas();
    }

    $scope.onclickEditar = function (event) {
        var _model = new Model($scope.produtoEdicao.id, $scope.produtoEdicao.prazo, $scope.produtoEdicao.tarefa, $scope.produtoEdicao.feito);
        $scope.produtoEdicao = null;
        todo_storage.editar({
            id: _model.id,
            prazo: _model.getDataStr(),
            tarefa: _model.tarefa,
            feito: _model.feito
        });
        atualizaModelTarefas();
        window.location = "#!/tarefas";
    }
    let indexObjEdicao = $scope.tarefas.findIndex(x => x.id == $routeParams.guid);
    if (indexObjEdicao > -1) {
        $scope.produtoEdicao = $scope.tarefas[indexObjEdicao];
        $scope.produtoEdicao.prazo = stringToDate($scope.produtoEdicao.prazo)
    }
});