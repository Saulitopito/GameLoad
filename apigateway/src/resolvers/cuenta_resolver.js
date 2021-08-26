const cuentaResolver = {
    Query: {
        cuentaByUsuarioId: (_, {usuarioId}, {dataSources, userIdToken}) => {
            if(usuarioId == userIdToken) 
                return dataSources.CarritoAPI.cuentaByUsuarioId(usuarioId);
            else
                return null;
        },
    },
    Mutation: {
        crearCuenta: (_, {cuentaId}, {dataSources}) => {
            return dataSources.CarritoAPI.crearCuenta(cuentaId);
        }
    }
};

module.exports = cuentaResolver;