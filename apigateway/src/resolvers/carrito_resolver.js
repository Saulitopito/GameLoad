const carritoResolver = {
    Query: {
        carritoByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.carritoByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        }
    },
    Mutation: {
        eliminarCarritoByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.eliminarCarritoByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        },
        eliminarProductoCarritoByUsuarioIdAndProductoId: (_, {usuarioId, productoId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken){
                return dataSources.CarritoAPI.eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId, productoId);
            }
        },
        agregarCarritoByUsuarioId: (_, {usuarioId, producto}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.agregarCarritoByUsuarioId(usuarioId, producto);
            }
            else {
                return null;
            }
        },
        aumentarProductoByCarrito: (_, {carrito, cantidad}, {dataSources, userIdToken}) => {
            if(carrito.usuarioId == userIdToken) {
                return dataSources.CarritoAPI.aumentarProductoByCarrito(carrito, cantidad);
            }
            else {
                return null;
            }
        },
        disminuirProductoByCarrito: (_, {carrito}, {dataSources, userIdToken}) => {
            if(carrito.usuarioId == userIdToken) {
                return dataSources.CarritoAPI.disminuirProductoByCarrito(carrito);
            }
            else {
                return null;
            }
        }
    }
}

module.exports = carritoResolver;