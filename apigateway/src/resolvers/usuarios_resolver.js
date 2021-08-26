const usuariosResolver = {
    Mutation: {
        authenticate: (_, { credentials }, { dataSources }) => dataSources.UsuariosAPI.authRequest(credentials),
        refreshToken: (_, { refresh }, { dataSources }) => dataSources.UsuariosAPI.refreshToken(refresh),
        createUser: (_, {user}, {dataSources}) => dataSources.UsuariosAPI.createUser(user)
    }
};

module.exports = usuariosResolver;