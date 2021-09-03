<template>
  <div id="Order">
    <div class="contenedor_factura">
      <h3>Querido usuario {{ username }}, </h3>
      <p>Gracias por elegirnos para realizar sus compras, esta es su orden:</p>
      <table>
        <th>Fecha</th>
        <th>Codigo orden</th>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio</th>
        <tr v-for="ord in ordenByUsuarioId" :key="ord.producto_id">
          <td>{{ ord.fechaCompra.substring(0, 10)}}</td>
          <td>{{ ord.codigoOrden.substring(0,5)}}</td>
          <td>{{ ord.productoNombre}}</td>
          <td>{{ ord.productoCantidad}}</td>
          <td>${{ ord.productoPrecio }} COP</td>
        </tr>
      </table>
      <h2>Total: $ {{ total() }} COP</h2>
    </div>
    <div class="botones">
      <button class="confirm" v-on:click="confirmOrden(ordenByUsuarioId[0].codigoOrden)">Confirmar orden</button>
      <button class="confirm-del" v-on:click="eliminarOrden(ordenByUsuarioId[0].codigoOrden)">Eliminar orden</button>
    </div>
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
.contenedor_factura{
  width: 70%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
  margin-bottom: 1vh;
}

.botones{
  display: inline-block;
}

.confirm-del{
  width: 15vw;
  height: 5vh;
  color: white;
  border-radius: 10px;
  margin: 10px;
  background: crimson;
}

.confirm-del:hover{
  background-color:gray;
}
#Order {
  width: 100%;
  height: 120%;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#Order table {
  width: 90%;
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