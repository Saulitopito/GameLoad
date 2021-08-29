const productoResolver = {
    Query: {
        productosDisponibles: (_, {}, {dataSources}) => {
            return dataSources.CarritoAPI.productosDisponibles();
        },
        productosById: (_, {productoId}, {dataSources}) => {
            return dataSources.CarritoAPI.productosById(productoId);
        },
        productosByCategoria: (_, {productoCategoria}, {dataSources}) => {
            return dataSources.CarritoAPI.productosByCategoria(productoCategoria);
        }
    }
}

module.exports = productoResolver;