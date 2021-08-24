const carritoResolver = {
    Query: {
        carritoByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.carritoByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        }
    },
    Mutation: {
        eliminarCarritoByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.eliminarCarritoByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        },
        eliminarProductoCarritoByUsuarioIdAndProductoId: (_, {usuarioId}, {productoId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken){
                return dataSources.carritoAPI.eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId, productoId);
            }
        },
        agregarCarritoByUsuarioId: (_, {usuarioId}, {producto}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.agregarCarritoByUsuarioId(usuarioId, producto);
            }
            else {
                return null;
            }
        },
        aumentarProductoByCarrito: (_, {carrito}, {cantidad}, {dataSources, userIdToken}) => {
            if(carrito.usuarioId == userIdToken) {
                return dataSources.carritoAPI.aumentarProductoByCarrito(carrito, cantidad);
            }
            else {
                return null;
            }
        },
        disminuirProductoByCarrito: (_, {carrito}, {dataSources, userIdToken}) => {
            if(carrito.usuarioId == userIdToken) {
                return dataSources.carritoAPI.disminuirProductoByCarrito(carrito);
            }
            else {
                return null;
            }
        }
    }
}

module.exports = carritoResolver;