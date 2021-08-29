const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class CarritoAPI extends RESTDataSource {
  constructor() {
    super();
    this.baseURL = serverConfig.account_api_url;    
  }

  async productosDisponibles(){
    return await this.get('/productos');
  }

  async productosById(productoId){
    return await this.get(`/productos/${productoId}`);
  }

  async productosByCategoria(productoCategoria){
    return await this.get(`/productos/categoria/${productoCategoria}`);
  }

  async crearCuenta(cuentaId){
    return await this.post(`/cuentas/${cuentaId}`);
  }

  async cuentaByUsuarioId(usuarioId){
    return await this.get(`/cuentas/${usuarioId}`);
  }

  async carritoByUsuarioId(usuarioId){
    return await this.get(`/carrito/${usuarioId}`);
  }

  async eliminarCarritoByUsuarioId(usuarioId){
    return await this.delete(`/carrito/${usuarioId}`);
  }

  async eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId, productoId){
    return await this.delete(`/carrito/producto/${usuarioId}/${productoId}`);
  }

  async agregarCarritoByUsuarioId(usuarioId, producto){
    producto = new Object(JSON.parse(JSON.stringify(producto)));
    return await this.post(`/carrito/${usuarioId}`, producto);
  }

  async aumentarProductoByCarrito(carrito, cantidad){
    carrito = new Object(JSON.parse(JSON.stringify(carrito)));
    return await this.put(`/carrito/aumentar`, carrito, cantidad);
  }

  async disminuirProductoByCarrito(carrito){
    carrito = new Object(JSON.parse(JSON.stringify(carrito)));
    return await this.put(`/carrito/disminuir`, carrito);
  }

  async crearOrden(usuarioId){
    return await this.post(`/orden/${usuarioId}`);
  }

  async eliminarOrdenByCodigoOrden(usuarioId, codigoOrden){
    return await this.delete(`/orden/${usuarioId}/${codigoOrden}`);
  }

  async ordenByUsuarioId(usuarioId){
    return await this.get(`/ordenes/${usuarioId}`);
  }

  async ordenByCodigoOrden(usuarioId, codigoOrden){
    return await this.get(`/orden/${usuarioId}/${codigoOrden}`);
  }

  async totalValorOrdenByCodigoOrden(usuarioId, codigoOrden){
    return await this.get(`/orden/total/${usuarioId}/${codigoOrden}`);
  }

  async confirmarOrdenByCodigoOrden(usuarioId, codigoOrden){
    return await this.put(`/orden/confirmar/${usuarioId}/${codigoOrden}`)
  }

}

module.exports = CarritoAPI;