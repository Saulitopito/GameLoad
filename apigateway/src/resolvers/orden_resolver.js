const ordenResolver = {
    Query: {
        ordenByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.ordenByUsuarioId(usuarioId);
            }
            else {
                return null;
            }
        },
        ordenByCodigoOrden: (_, {usuarioId, codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.ordenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        },
        totalValorOrdenByCodigoOrden: (_, {usuarioId, codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.totalValorOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        }
    },
    Mutation: {
        crearOrden: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.crearOrden(usuarioId);
            }
            else {
                return null;
            }
        },
        eliminarOrdenByCodigoOrden: (_, {usuarioId, codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                return dataSources.CarritoAPI.eliminarOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        },
        confirmarOrdenByCodigoOrden: (_, {usuarioId, codigoOrden}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) {
                console.log(usuarioId, userIdToken);
                return dataSources.CarritoAPI.confirmarOrdenByCodigoOrden(usuarioId, codigoOrden);
            }
            else {
                return null;
            }
        }
    }
}

module.exports = ordenResolver;