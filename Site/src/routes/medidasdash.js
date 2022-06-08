var express = require("express");
var router = express.Router();

var medidaController = require("../controllers/medidasDashController");

router.get("/ultimas/", function(req, res) {
    medidaController.buscarUltimasMedidas(req, res);
});

router.get("/tempo-real/", function(req, res) {
    medidaController.buscarMedidasEmTempoReal(req, res);
})
  

router.get("/buscarMediaUmidade/", function(req, res) {
    medidaController.buscarMediaConsumoPC(req, res);
})

router.get("/QtdSistemasWind/", function(req, res) {
    medidaController.buscarQtdSistemasWind(req, res);
})
router.get("/QtdSistemasLinux/", function(req, res) {
    medidaController.buscarQtdSistemasLinux(req, res);
})

module.exports = router;