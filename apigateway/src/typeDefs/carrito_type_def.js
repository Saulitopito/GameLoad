const { gql } = require('apollo-server');

const carritoTypeDefs = gql`
    type Carrito {
        carrito_id: String!
        usuarioId: String!
        productoId: String!
        productoCantidad: Int!
        productoPrecio: Float
    }

    input CarritoInput {
        carrito_id: String!
        usuarioId: String!
        productoId: String!
        productoCantidad: Int!
        productoPrecio: Float
    }

    input ProductoInput {
        producto_id: String!
    }

    type Query {
        carritoByUsuarioId(usuarioId: String!): [Carrito]
    }

    type Mutation {
        eliminarCarritoByUsuarioId(usuarioId: String!): Int
    }

    extend type Mutation {
        eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId: String!, productoId: String!): Int
    }
    
    extend type Mutation {
        agregarCarritoByUsuarioId(usuarioId: String!, producto: ProductoInput): Carrito
    }

    extend type Mutation {
        aumentarProductoByCarrito(carrito: CarritoInput!, cantidad: Int!): Carrito
    }

    extend type Mutation {
        disminuirProductoByCarrito(carrito: CarritoInput!): Carrito
    }

`;

module.exports = carritoTypeDefs;