<template>
  <div id="Carrito">
    <table>
      <tr>
        <th>Producto Id</th>
        <th>Nombre del producto</th>
        <th>Cantidad</th>
        <th>Precio</th>
        <th>Disminuir</th>
        <th>Eliminar</th>
      </tr>

      <tr v-for="product in carritoByUsuarioId" :key="product.producto_id">
        <td>{{ product.productoId}}</td>
        <td>{{ product.productoNombre}}</td>
        <td>{{ product.productoCantidad}}</td>
        <td>${{ product.productoPrecio }} COP</td>
        <td><button v-on:click="remove(product)"><i class="fas fa-minus"></i></button></td>
        <td><button v-on:click="del(product.productoId)"><i class="fas fa-trash"></i></button></td>
      </tr>
    </table>
    <h2>Total: $ {{ total() }} COP</h2>
    <button class="confirm" v-on:click="confirm">Confirmar carrito</button>
  </div>
</template>

<script>
import gql from "graphql-tag";

export default {
  name: "Car",

  data: function () {
    return {
      usuarioId: localStorage.getItem("user_id"),
      carritoByUsuarioId: [],
      crearOrdenUsuarioId: "null",
      disminuirProductoByCarritoCarrito: {
        carrito_id: "",
        usuarioId: "",
        productoId: "",
        productoNombre: "",
        productoCantidad: "",
        productoPrecio: "",
      },
      eliminarProductoCarritoByUsuarioIdAndProductoIdProductoId: {
        productoId: "",
      },
    };
  },

  created: function () {
    this.username = this.$route.params.username;
  },

  apollo: {
    carritoByUsuarioId: {
      query: gql`
        query Query($carritoByUsuarioIdUsuarioId: String!) {
          carritoByUsuarioId(usuarioId: $carritoByUsuarioIdUsuarioId) {
            carrito_id
            usuarioId
            productoId
            productoNombre
            productoCantidad
            productoPrecio
          }
        }
      `,
      variables() {
        return {
          carritoByUsuarioIdUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
        };
      },
    },
  },

  methods:{
    total: function(){
      let suma = 0;
      this.carritoByUsuarioId.forEach((item) => {
        suma += (item.productoCantidad * item.productoPrecio);
      });
      return suma;
    },

    confirm: async function(){
    await this.$apollo
      .mutate({
        mutation: gql`
          mutation CrearOrdenMutation($crearOrdenUsuarioId: String!) {
            crearOrden(usuarioId: $crearOrdenUsuarioId) {
              fechaCompra
              codigoOrden
              usuarioId
              productoCantidad
              productoPrecio
              estado
            }
          }
        `,  
        variables:{
          crearOrdenUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
        },
      })
      .then((result) => {
        alert("Carrito confirmado")
      })
      .catch((error) => {
          alert("Error");
      });
    },

    remove: async function(producto){
    this.disminuirProductoByCarritoCarrito.carrito_id = producto.carrito_id
    this.disminuirProductoByCarritoCarrito.usuarioId = producto.usuarioId
    this.disminuirProductoByCarritoCarrito.productoId = producto.productoId
    this.disminuirProductoByCarritoCarrito.productoNombre = producto.productoNombre
    this.disminuirProductoByCarritoCarrito.productoCantidad = producto.productoCantidad
    this.disminuirProductoByCarritoCarrito.productoPrecio = producto.productoPrecio
    await this.$apollo
      .mutate({
        mutation: gql`
          mutation ($disminuirProductoByCarritoCarrito: CarritoInput!) {
            disminuirProductoByCarrito(carrito: $disminuirProductoByCarritoCarrito) {
              carrito_id
              usuarioId
              productoId
              productoNombre
              productoCantidad
              productoPrecio
            }
          }
        `,  
        variables:{
          disminuirProductoByCarritoCarrito: this.disminuirProductoByCarritoCarrito,
        },
      })
      .then((result) => {
        alert("Reducción de producto exitoso")
      })
      .catch((error) => {
          alert("Error");
      });
    },

    del: async function(productoId){
    this.eliminarProductoCarritoByUsuarioIdAndProductoIdProductoId.productoId = productoId
    await this.$apollo
      .mutate({
        mutation: gql`
          mutation Mutation($eliminarProductoCarritoByUsuarioIdAndProductoIdUsuarioId: String!, $eliminarProductoCarritoByUsuarioIdAndProductoIdProductoId: String!) {
            eliminarProductoCarritoByUsuarioIdAndProductoId(usuarioId: $eliminarProductoCarritoByUsuarioIdAndProductoIdUsuarioId, productoId: $eliminarProductoCarritoByUsuarioIdAndProductoIdProductoId)
          }
        `,  
        variables:{
          eliminarProductoCarritoByUsuarioIdAndProductoIdUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
          eliminarProductoCarritoByUsuarioIdAndProductoIdProductoId: productoId,
        },
      })
      .then((result) => {
        alert("Producto eliminado de forma exitosa")
      })
      .catch((error) => {
          alert("Error");
      });
    },
  },
};

</script>

<style>
#Carrito {
  width: 100%;
  height: 120%;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#Carrito table {
  width: 50%;
  border-collapse: collapse;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
  text-align: center;
  align-items: center;
}

#Carrito table td,
#Carrito table th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

#Carrito table tr:nth-child(even) {
  background-color: #f2f2f2;
}

#Carrito table tr:hover {
  background-color: #ddd;
}

#Carrito table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: crimson;
  color: white;
}

.confirm{
  width: 15vw;
  height: 5vh;
  background: #00669F;
  color: white;
  border-radius: 10px;
  margin: 10px;
}

.confirm:hover{
    background-color:gray;
}
</style>