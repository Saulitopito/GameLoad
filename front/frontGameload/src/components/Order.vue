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
  </div>
</template>

<script>
import gql from "graphql-tag";

export default {
  name: "Order",

  data: function () {
    return {
      usuarioId: localStorage.getItem("user_id"),
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