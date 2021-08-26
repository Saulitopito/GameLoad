//Se llama al typedef (esquema) de cada submodulo
const cuentaTypeDefs = require('./cuenta_type_def');
const productoTypeDefs = require('./producto_type_def');
const carritoTypeDefs = require('./carrito_type_def');
const ordenTypeDefs = require('./orden_type_def');
const usuariosTypeDefs = require('./usuarios_type_def');

//Se unen
const schemasArrays = [cuentaTypeDefs, productoTypeDefs, carritoTypeDefs, ordenTypeDefs, usuariosTypeDefs];

//Se exportan
module.exports = schemasArrays; 