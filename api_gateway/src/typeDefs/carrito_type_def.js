const { gql } = require('apollo-server');

const carritoTypeDefs = gql`
    type Carrito {
        carrito_id: String!
        usuarioId: String!
        productoId: String!
        productoCantidad: Int!
        productoPrecio: Double
    }

    type Producto {
        producto_id: String!
        categoria: String
        codigo: String
        nombre: String
        precio: Double
        inventario: Int
        imagen: String
    }

    type Query {
        carritoByUsuarioId(usuarioId: String!): [Carrito]
    }

    type Mutation {
        eliminarCarritoByUsuarioId(usuarioId: String!): Int
    }

    type Mutation {
        eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId: String!, productoId: String!): Int
    }
    
    type Mutation {
        agregarCarritoByUsuarioId(usuarioId: String!, producto: Producto): Carrito
    }

    type Mutation {
        aumentarProductoByCarrito(carrito: Carrito!, cantidad: Int!): Carrito
    }

    type Mutation {
        disminuirProductoByCarrito(carrito: Carrito!): Carrito
    }

`;

module.exports = carritoTypeDefs;