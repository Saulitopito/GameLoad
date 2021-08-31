const { gql } = require('apollo-server')

const ordenTypeDefs = gql`
    type Orden {
        orden_id: String!
        codigoOrden: String!
        usuarioId: String!
        fechaCompra: String
        productoId: String!
        productoNombre: String!
        productoCantidad: Int!
        productoPrecio: Float
        estado: String!
    }

    type Mutation {
        crearOrden(usuarioId: String!): [Orden]
    }

    type Mutation {
        eliminarOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): String
    }

    type Query {
        ordenByUsuarioId(usuarioId: String!): [Orden]
    }

    type Query {
        ordenByCodigoOrden(usuarioId: String!, codigoOrden: String!): [Orden]
    }

    type Query {
        totalValorOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): Float
    }

    type Mutation {
        confirmarOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): String
    }
`;

module.exports = ordenTypeDefs;