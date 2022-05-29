var express = require("express");
var router = express.Router();

var medidaController = require("../controllers/medidaController");

router.get("/ultimas/", function(req, res) {
    medidaController.buscarUltimasMedidas(req, res);
});

router.get("/tempo-real/", function(req, res) {
    medidaController.buscarMedidasEmTempoReal(req, res);
})
  

router.get("/buscarMediaUmidade/", function(req, res) {
    medidaController.buscarMediaConsumoPC(req, res);
})

router.get("/QtdSistemas/", function(req, res) {
    medidaController.buscarQtdSistemas(req, res);
})

module.exports = router;