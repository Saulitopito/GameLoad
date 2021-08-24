const { gql } = require('apollo-server')

const ordenTypeDefs = gql`
    type Orden {
        orden_id: String!
        codigoOrden: String!
        usuarioId: String!
        fechaCompra: DateTime
        productoId: String!
        productoCantidad: Int!
        productoPrecio: Double
        estado: String!
    }

    type Mutation {
        crearOrden(usuarioId: String!): [Orden]
    }

    type Mutation {
        eliminarOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): Int
    }

    type Query {
        ordenByUsuarioId(usuarioId: String!): [Orden]
    }

    type Query {
        ordenByCodigoOrden(usuarioId: String!, codigoOrden: String!): [Orden]
    }

    type Query {
        totalValorOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): Double
    }

    type Mutation {
        confirmarOrdenByCodigoOrden(usuarioId: String!, codigoOrden: String!): Int
    }
`;

module.exports = ordenTypeDefs;