import { browser, by, element } from 'protractor';

var AlquilerPage = function () {

  var cedula = element(by.name('cedula'));
  var placa = element(by.name('placa'));
  var fechaInicio = element(by.name('fechaInicio'));
  var fechaFin = element(by.name('fechaFin'));
  var alquilar = element(by.id('alquilar'));
  var devolverVehiculo = element(by.id('devolverVehiculo'));
  var buscarUsuario = element(by.id('buscarUsuario'));
  var buscarVehiculo = element(by.id('buscarVehiculo'));

  this.get = function () {
    browser.get('http://localhost:4200/administrar-alquiler');
  };

  this.setCedula = function (valor) {
    cedula.sendKeys(valor);
  };

  this.setPlaca = function (valor) {
    placa.sendKeys(valor);
  };

  this.setFechaInicio = function (valor) {
    fechaInicio.sendKeys(valor);
  }

  this.setFechaFin = function (valor) {
    fechaFin.sendKeys(valor);
  };

  this.sleep = function (tiempo) {
    browser.sleep(tiempo);
  };

  this.alquilar = function () {
    alquilar.click();
  };

  this.devolverVehiculo = function () {
    devolverVehiculo.click();
  };

  this.buscarUsuario = function () {
    buscarUsuario.click();
  };

  this.buscarVehiculo = function () {
    buscarVehiculo.click();
  };

  this.alertaTexto = function () {
    return browser.switchTo().alert().getText();
  }

  this.alertaAceptar = function () {
    browser.switchTo().alert().accept();
  }

};
module.exports = new AlquilerPage();

