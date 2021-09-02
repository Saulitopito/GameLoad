<template>
  <div id="Order">
    <table>
      <tr>
        <th>Fecha</th>
        <th>Codigo orden</th>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio</th>
      </tr>

      <tr v-for="ord in ordenByUsuarioId" :key="ord.producto_id">
        <td>{{ ord.fechaCompra.substring(0, 10)}}</td>
        <td>{{ ord.codigoOrden}}</td>
        <td>{{ ord.productoNombre}}</td>
        <td>{{ ord.productoCantidad}}</td>
        <td>${{ ord.productoPrecio }} COP</td>
      </tr>
    </table>
    <h2>Total: $ {{ total() }} COP</h2>
    <button class="confirm" v-on:click="confirmOrden(ordenByUsuarioId[0].codigoOrden)">Confirmar orden</button>
    <br>
    <button class="confirm" v-on:click="eliminarOrden(ordenByUsuarioId[0].codigoOrden)">Eliminar orden</button>
  </div>
</template>

<script>
import gql from "graphql-tag";

export default {
  name: "Order",

  data: function () {
    return {
      usuarioId: localStorage.getItem("user_id"),
      confirmarOrdenUsuarioId: "null",
      confirmarOrdenOrdenId: "null",
      eliminarOrdenByCodigoOrdenUsuarioId: "null",
      eliminarOrdenByCodigoOrdenCodigoOrden: "null",
      ordenByUsuarioId: [],
    };
  },

  created: function () {
    this.username = this.$route.params.username;
  },

  apollo: {
    ordenByUsuarioId: {
      query: gql`
        query Query($ordenByUsuarioIdUsuarioId: String!) {
            ordenByUsuarioId(usuarioId: $ordenByUsuarioIdUsuarioId) {
                orden_id
                codigoOrden
                usuarioId
                fechaCompra
                productoId
                productoCantidad
                productoPrecio
                productoNombre
                estado
            }
        }
      `,
      variables() {
        return {
          ordenByUsuarioIdUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
        };
      },
    },
  },

  methods:{
    total: function(){
      let suma = 0;
      this.ordenByUsuarioId.forEach((item) => {
        suma += item.productoPrecio;
      });
      return suma;
    },

    confirmOrden: async function(codigoOrden){
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation confirmarOrdenByCodigoOrdenMutation($confirmarOrdenUsuarioId: String!, $confirmarOrdenOrdenId: String!) {
              confirmarOrdenByCodigoOrden(usuarioId: $confirmarOrdenUsuarioId, codigoOrden: $confirmarOrdenOrdenId)
            }
          `,  
          variables:{
            confirmarOrdenUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
            confirmarOrdenOrdenId: codigoOrden,
          },
        })
        .then((result) => {
          alert("Orden confirmada")
        })
        .catch((error) => {
            alert("Error");
        });
    },

    eliminarOrden: async function(codigoOrden) {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($eliminarOrdenByCodigoOrdenUsuarioId: String!, $eliminarOrdenByCodigoOrdenCodigoOrden: String!) {
              eliminarOrdenByCodigoOrden(usuarioId: $eliminarOrdenByCodigoOrdenUsuarioId, codigoOrden: $eliminarOrdenByCodigoOrdenCodigoOrden) 
            }
          `,  
        variables:{
          eliminarOrdenByCodigoOrdenUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
          eliminarOrdenByCodigoOrdenCodigoOrden: codigoOrden,
        },
        })
        .then((result) => {
          alert("Orden elimanada")
        })
        .catch((error) => {
            alert("Error");
        });
    },
  },
};

</script>


<style>
#Order {
  width: 100%;
  height: 120%;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#Order table {
  width: 50%;
  border-collapse: collapse;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
}

#Order table td,
#Order table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Order table tr:nth-child(even) {
  background-color: #f2f2f2;
}

#Order table tr:hover {
  background-color: #ddd;
}

#Order table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: crimson;
  color: white;
}
</style>