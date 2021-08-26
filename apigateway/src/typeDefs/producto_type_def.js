const { gql } = require('apollo-server');

const productoTypeDefs = gql`
    type Producto {
        producto_id: String!
        categoria: String!
        codigo: String!
        nombre: String!
        precio: Float!
        inventario: Int!
        imagen: String
    }
    
    type Query {
        productosDisponibles: [Producto]
    }

    type Query {
        productosById(productoId: String!): Producto
    }

    type Query {
        productosByCategoria(productoCategoria: String!): [Producto]
    }
`;

module.exports = productoTypeDefs; 