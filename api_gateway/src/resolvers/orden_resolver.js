const ordenResolver = {
    Query: {
        ordenByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.ordenByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        },
        ordenByCodigoOrden: (_, {usuarioId}, {codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.ordenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        },
        totalValorOrdenByCodigoOrden: (_, {usuarioId}, {codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.totalValorOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        }
    },
    Mutation: {
        crearOrden: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.crearOrden(usuarioId);
            }
            else {
                return null;
            }
        },
        eliminarOrdenByCodigoOrden: (_, {usuarioId}, {codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.eliminarOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        },
        confirmarOrdenByCodigoOrden: (_, {usuarioId}, {codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.carritoAPI.confirmarOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        }
    }
}

module.exports = ordenResolver;