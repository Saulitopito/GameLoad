const cuentaResolver = require('./cuenta_resolver');
const productoResolver = require('./producto_resolver');
const carritoResolver = require('./carrito_resolver');
const ordenResolver = require('./orden_resolver');
const usuariosResolver = require('./usuarios_resolver');

const lodash = require('lodash');

const resolvers = lodash.merge(cuentaResolver, productoResolver, carritoResolver, ordenResolver, usuariosResolver);

module.exports = resolvers;