const usuariosResolver = {
    Mutation: {
        authenticate: (_, { credentials }, { dataSources }) => dataSources.usuariosAPI.authRequest(credentials),
        refreshToken: (_, { refresh }, { dataSources }) => dataSources.usuariosAPI.refreshToken(refresh),
        createUser: (_, {user}, {dataSources}) => dataSources.usuariosAPI.createUser(user)
    }
};

module.exports = usuariosResolver;