import { browser, by, element } from 'protractor';

describe('Prueba inicio', function () {
  it('Prueba inicio', function () {
    browser.get('http://localhost:4200/');
    expect(browser.getTitle()).toEqual('AlquilerVehiculosFront');
    browser.sleep(1000);
  });
})

describe('registrarVehiculos', function () {
  it('registrarVehiculos', function () {
    browser.get('http://localhost:4200/administrar-vehiculos');
    browser.sleep(3000);

    element(by.name('placa')).sendKeys('ASD123');
    element(by.name('modelo')).sendKeys('Audi');
    element(by.name('marca')).sendKeys('R8');
    element(by.name('color')).sendKeys('Gris');
    element(by.name('precio')).sendKeys(500000);
    element(by.id('Guardar')).click();
    browser.sleep(2000);

    expect(browser.switchTo().alert().getText()).toEqual('El vehiculo ha sido registrado');
    browser.switchTo().alert().accept();
  });
})

describe('buscarVehiculos', function () {
  it('buscarVehiculos', function () {
    browser.get('http://localhost:4200/administrar-vehiculos');
    browser.sleep(3000);

    element(by.name('placa')).sendKeys('ASD123');
    element(by.id('Buscar')).click();
    browser.sleep(3000);

    expect(element(by.name('modelo')).getAttribute('value')).toEqual('Audi');
  });
})

describe('registrarUsuarios', function () {
  it('registrarUsuarios', function () {
    browser.get('http://localhost:4200/administrar-usuarios');
    browser.sleep(3000);

    element(by.name('cedula')).sendKeys(1094);
    element(by.name('nombres')).sendKeys('Jairo Andres');
    element(by.name('apellidos')).sendKeys('Rios Franco');
    element(by.name('fechaNacimiento')).sendKeys('25/04/1993');
    element(by.id('Guardar')).click();
    browser.sleep(2000);

    expect(browser.switchTo().alert().getText()).toEqual('El usuario ha sido registrado');
    browser.switchTo().alert().accept();
  });
})

describe('buscarUsuarios', function () {
  it('buscarUsuarios', function () {
    browser.get('http://localhost:4200/administrar-usuarios');
    browser.sleep(3000);

    element(by.name('cedula')).sendKeys(1094);
    element(by.id('Buscar')).click();
    browser.sleep(3000);

    expect(element(by.name('nombres')).getAttribute('value')).toEqual('Jairo Andres');
  });
})

describe('alquilarVehiculo', function () {
  it('alquilarVehiculo', function () {
    browser.get('http://localhost:4200/administrar-alquiler');
    browser.sleep(3000);

    element(by.name('cedula')).sendKeys(1094);
    element(by.id('buscarUsuario')).click();
    browser.sleep(3000);

    element(by.name('placa')).sendKeys('ASD123');
    element(by.id('buscarVehiculo')).click();
    browser.sleep(3000);

    element(by.name('fechaInicio')).sendKeys('12/04/2019');
    element(by.name('fechaFin')).sendKeys('13/04/2019');

    element(by.id('alquilar')).click();
    browser.sleep(2000);

    expect(browser.switchTo().alert().getText()).toEqual('El vehiculo ha sido alquilado');
    browser.switchTo().alert().accept();
  });
})

describe('devolverVehiculo', function () {
  it('devolverVehiculo', function () {
    browser.get('http://localhost:4200/administrar-alquiler');
    browser.sleep(3000);

    element(by.name('placa')).sendKeys('ASD123');
    element(by.id('devolverVehiculo')).click();
    browser.sleep(3000);

    expect(browser.switchTo().alert().getText()).toEqual('El vehiculo ha sido devuelto');
    browser.switchTo().alert().accept();
  });
})
