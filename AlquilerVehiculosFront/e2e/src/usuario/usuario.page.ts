import { browser, by, element } from 'protractor';

var UsuarioPage = function () {

  var cedula = element(by.name('cedula'));
  var nombres = element(by.name('nombres'));
  var apellidos = element(by.name('apellidos'));
  var fechaNacimiento = element(by.name('fechaNacimiento'));
  var guardar = element(by.id('Guardar'));
  var buscar = element(by.id('Buscar'));

  this.get = function () {
     browser.get('http://localhost:4200/administrar-usuarios');
  };

  this.setCedula = function (valor) {
     cedula.sendKeys(valor);
  };

  this.setNombres = function (valor) {
     nombres.sendKeys(valor);
  };

  this.getNombres = function () {
   return nombres.getAttribute('value');
  }

  this.setApellidos = function (valor) {
     apellidos.sendKeys(valor);
  };

  this.setFechaNacimiento = function (valor) {
    fechaNacimiento.sendKeys(valor);
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
module.exports = new UsuarioPage();

