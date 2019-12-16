var menuPage = require('./menu/menu.page');
var vehiculoPage = require('./vehiculo/vehiculo.page');
var usuarioPage = require('./usuario/usuario.page');
var alquilerPage = require('./alquiler/alquiler.page');

describe('Prueba inicio', function () {
  it('Prueba inicio', function () {
    menuPage.get();
    expect(menuPage.getTitle()).toEqual('AlquilerVehiculosFront');
    menuPage.sleep(1000);
  });
})


describe('registrarVehiculos', function () {
  it('registrarVehiculos', function () {
    vehiculoPage.get();
    vehiculoPage.sleep(3000);

    vehiculoPage.setPlaca('ASD123');
    vehiculoPage.setModelo('Audi');
    vehiculoPage.setMarca('R8');
    vehiculoPage.setColor('Gris');
    vehiculoPage.setPrecio(500000);

    vehiculoPage.guardar();
    vehiculoPage.sleep(2000);

    expect(vehiculoPage.alertaTexto()).toEqual('El vehiculo ha sido registrado');
    vehiculoPage.alertaAceptar();
  });
})

describe('buscarVehiculos', function () {
  it('buscarVehiculos', function () {
    vehiculoPage.get();
    vehiculoPage.sleep(3000);

    vehiculoPage.setPlaca('ASD123');

    vehiculoPage.buscar();
    vehiculoPage.sleep(3000);

    expect(vehiculoPage.getModelo()).toEqual('Audi');
  });
})

describe('registrarUsuarios', function () {
  it('registrarUsuarios', function () {
    usuarioPage.get();
    usuarioPage.sleep(3000);

    usuarioPage.setCedula(1094);
    usuarioPage.setNombres('Jairo Andres');
    usuarioPage.setApellidos('Rios Franco');
    usuarioPage.setFechaNacimiento('25/04/1993');

    usuarioPage.guardar();
    usuarioPage.sleep(2000);

    expect(usuarioPage.alertaTexto()).toEqual('El usuario ha sido registrado');
    usuarioPage.alertaAceptar();
  });
})

describe('buscarUsuarios', function () {
  it('buscarUsuarios', function () {
    usuarioPage.get();
    usuarioPage.sleep(3000);

    usuarioPage.setCedula(1094);
    usuarioPage.buscar();
    usuarioPage.sleep(3000);

    expect(usuarioPage.getNombres()).toEqual('Jairo Andres');
  });
})


describe('alquilarVehiculo', function () {
  it('alquilarVehiculo', function () {
    alquilerPage.get();
    alquilerPage.sleep(3000);

    alquilerPage.setCedula(1094);
    alquilerPage.buscarUsuario();
    alquilerPage.sleep(3000);

    alquilerPage.setPlaca('ASD123');
    alquilerPage.buscarVehiculo();
    alquilerPage.sleep(3000);

    alquilerPage.setFechaInicio('12/04/2019');
    alquilerPage.setFechaFin('13/04/2019');

    alquilerPage.alquilar();
    alquilerPage.sleep(2000);

    expect(alquilerPage.alertaTexto()).toEqual('El vehiculo ha sido alquilado');
    alquilerPage.alertaAceptar();
  });
})


describe('devolverVehiculo', function () {
  it('devolverVehiculo', function () {
    alquilerPage.get();
    alquilerPage.sleep(3000);

    alquilerPage.setPlaca('ASD123');
    alquilerPage.devolverVehiculo();
    alquilerPage.sleep(3000);

    expect(alquilerPage.alertaTexto()).toEqual('El vehiculo ha sido devuelto');
    alquilerPage.alertaAceptar();
  });
})
