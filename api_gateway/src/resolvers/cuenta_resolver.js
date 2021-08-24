const cuentaResolver = {
    Query: {
        cuentaByUsuarioId: (_, {userId}, {dataSources, userIdToken}) => {
            if(userId == userIdToken) 
                return dataSources.carritoAPI.cuentaByUsuarioId(userId);
            else
                return null;
        },
    },
    Mutation: {
        crearCuenta: (_, {cuentaId}, {dataSources}) => {
            return dataSources.carritoAPI.crearCuenta(cuentaId);
        }
    }
};

module.exports = cuentaResolver;