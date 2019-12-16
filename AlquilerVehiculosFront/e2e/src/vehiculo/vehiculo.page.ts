import { browser, by, element } from 'protractor';

var VehiculoPage = function () {

  var placa = element(by.name('placa'));
  var modelo = element(by.name('modelo'));
  var marca = element(by.name('marca'));
  var color = element(by.name('color'));
  var precio = element(by.name('precio'));
  var guardar = element(by.id('Guardar'));
  var buscar = element(by.id('Buscar'));

  this.get = function () {
    browser.get('http://localhost:4200/administrar-vehiculos');
  };

  this.setPlaca = function (valor) {
    placa.sendKeys(valor);
  };

  this.setModelo = function (valor) {
    modelo.sendKeys(valor);
  };

  this.getModelo = function () {
    return modelo.getAttribute('value');
  };

  this.setMarca = function (valor) {
    marca.sendKeys(valor);
  }

  this.setColor = function (valor) {
    color.sendKeys(valor);
  };

  this.setPrecio = function (valor) {
    precio.sendKeys(valor);
  };

  this.sleep = function (tiempo) {
    browser.sleep(tiempo);
  };

  this.guardar = function () {
    guardar.click();
  };

  this.buscar = function () {
    buscar.click();
  };

  this.alertaTexto = function () {
    return browser.switchTo().alert().getText();
  }

  this.alertaAceptar = function () {
    browser.switchTo().alert().accept();
  }

};
module.exports = new VehiculoPage();

