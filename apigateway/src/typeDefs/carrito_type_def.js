const { gql } = require('apollo-server');

const carritoTypeDefs = gql`
    type Carrito {
        carrito_id: String!
        usuarioId: String!
        productoId: String!
        productoNombre: String!
        productoCantidad: Int!
        productoPrecio: Float
    }

    input CarritoInput {
        carrito_id: String!
        usuarioId: String!
        productoId: String!
        productoNombre: String!
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
        eliminarCarritoByUsuarioId(usuarioId: String!): String
    }

    type Mutation {
        eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId: String!, productoId: String!): String
    }
    
    type Mutation {
        agregarCarritoByUsuarioId(usuarioId: String!, producto: ProductoInput): Carrito
    }

    type Mutation {
        aumentarProductoByCarrito(carrito: CarritoInput!, cantidad: Int!): Carrito
    }

    type Mutation {
        disminuirProductoByCarrito(carrito: CarritoInput!): Carrito
    }

`;

module.exports = carritoTypeDefs;