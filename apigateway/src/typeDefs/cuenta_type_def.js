const { gql } = require('apollo-server');

const cuentaTypeDefs = gql`
    type Cuenta {
        usuarioId: String!
    }
    
    type Mutation {
        crearCuenta(cuentaId: String!): Cuenta
    }

    type Query {
        cuentaByUsuarioId(usuarioId: String!): Cuenta
    }
`;

module.exports = cuentaTypeDefs; 
