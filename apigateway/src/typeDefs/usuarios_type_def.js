const { gql } = require('apollo-server');

const usuariosTypeDefs = gql`
    type Tokens {
        refresh: String!
        access: String!
    }

    type Access {
        access: String!
    }

    type User {
        username: String!
        name: String!
        password: String!
        email: String!
        address: String!
    }

    input UserInput {
        username: String!
        name: String!
        password: String!
        email: String!
        address: String!
    }

    input CredentialsInput {
        username: String!
        password: String!
    }
    
    extend type Mutation {
        authenticate(credentials: CredentialsInput!): Tokens!
        refreshToken(refresh: String!): Access!
    }

    type Mutation {
        createUser(user: UserInput!): User!
    }
`;

module.exports = usuariosTypeDefs;