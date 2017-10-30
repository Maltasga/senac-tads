window.todo_storage = (function () {
    "use strict";

    var NOME_STORAGE_ITEM = "tarefas";

    function init() {
        if (getAll() == null)
            sessionStorage.setItem(NOME_STORAGE_ITEM, "[]");
    }

    function insertStorage(arrTarefas) {
        if (!Array.isArray(arrTarefas))
            throw new Error("Deve ser um Array");

        sessionStorage.setItem(NOME_STORAGE_ITEM, JSON.stringify(arrTarefas));
    }

    function getAll() {
        return JSON.parse(sessionStorage.getItem(NOME_STORAGE_ITEM));
    }

    function getIndexById(id) {
        return getAll().findIndex(x => x.id == id);
    }

    function getById(id) {
        var item = null,
            arrResult = getAll().filter(element => element.id == id);

        if (arrResult.length)
            item = arrResult[0];

        return item;
    }

    function addItem(item) {
        var db = getAll();
        db.push(item);
        insertStorage(db);
    }

    function editItem(item) {
        var db = getAll();
        db[getIndexById(item.id)] = item;
        insertStorage(db);
    }

    function geraId() {
        var booleanExiste = function () {
                return getAll().filter(elem => elem.id == intNovoId).length > 0;
            },
            intRandon = function () {
                return Math.floor(Math.random() * 200);
            },
            intNovoId = intRandon()

        while (booleanExiste()) {
            intNovoId = intRandon();
        }
        return intNovoId;
    }

    init()

    return {
        salvar: function (item) {
            item.id = geraId();
            addItem(item);
        },
        editar: function (item) {
            var entity = getById(item.id);
            entity.tarefa = item.tarefa;
            entity.prazo = item.prazo
            entity.feito = item.feito;
            editItem(entity);
        },
        getById: getById,
        getAll: getAll,
        excluir: function (id) {
            var db = getAll();
            db.splice(getIndexById(id), 1);
            insertStorage(db);
        }
    };
})();