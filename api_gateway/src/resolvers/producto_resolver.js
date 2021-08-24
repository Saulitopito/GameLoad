const productoResolver = {
    Query: {
        productosDisponibles: () => {
            return dataSources.carritoAPI.productosDisponibles();
        },
        productosById: (_, {productoId}, {dataSources}) => {
            return dataSources.carritoAPI.productosById(productoId);
        },
        productosByCategoria: (_, {productoCategoria}, {dataSources}) => {
            return dataSources.carritoAPI.productosByCategoria(productoCategoria);
        }
    }
}

module.exports = productoResolver;