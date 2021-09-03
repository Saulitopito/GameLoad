<template>
  <div class="card" v-for="product in productosDisponibles" :key="product.producto_id"> 
    <h4>{{ product.nombre}}</h4>
    <div class="imagen_juego">
      <img v-bind:src="product.imagen">
    </div>
    <p>${{ product.precio}} COP</p>
    <button v-on:click="add(product.producto_id)">Agregar <i class="fas fa-shopping-cart carrito"></i></button>
  </div>
</template>

<script>
import gql from "graphql-tag";

export default {
  name: "Products",

  data: function () {
    return {
      productosDisponibles: [],
      agregarCarritoByUsuarioIdProducto: {
        producto_id: "",
      },
    };
  },

  created: function () {
    this.username = this.$route.params.username;
  },

  apollo: {
    productosDisponibles: {
      query: gql`
        query Query {
          productosDisponibles {
            producto_id
            categoria
            codigo
            nombre
            precio
            imagen
          }
        }
      `,
      variables() {
        return {
          productosDisponibles: localStorage.getItem("user_id"),
        };
      },
    },
  },

  methods:{
    add: async function(producto_id){
    this.agregarCarritoByUsuarioIdProducto.producto_id = producto_id
    await this.$apollo
      .mutate({
        mutation: gql`
          mutation ($agregarCarritoByUsuarioIdUsuarioId: String!, $agregarCarritoByUsuarioIdProducto: ProductoInput) {
            agregarCarritoByUsuarioId(usuarioId: $agregarCarritoByUsuarioIdUsuarioId, producto: $agregarCarritoByUsuarioIdProducto) {
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
          agregarCarritoByUsuarioIdUsuarioId: localStorage.getItem("user_id").replace(/^(0+)/g, ''),
          agregarCarritoByUsuarioIdProducto: this.agregarCarritoByUsuarioIdProducto,
        },
      })
      .then((result) => {
        alert("Producto agregado de forma correcta")
      })
      .catch((error) => {
          alert("Error");
      });
    },
  }
  
};

</script>

<style>
.card{
  border-radius: 10px;
  margin: 170px 30px;
  height: 40vh;
  width: 15vw;
  justify-content: space-between;
  text-align: center;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  transition: .4s;
}

.card p{
  font-weight: 400;
  font-size: 1rem;
}

.card:hover{
  -webkit-transform: scale(1.05);
  transform: scale(1.05);
}

.card button{
  width: 15vw;
  height: 3vh;
  background: #2183a2;
  color: white;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}

.card button:hover{
  background-color:gray;
}

#Productos {
  width: 100%;
  height: 120%;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#Productos table {
  width: 50%;
  border-collapse: collapse;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
}

#Productos table td,
#Productos table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Productos table tr:nth-child(even) {
  background-color: #f2f2f2;
}

#Productos table tr:hover {
  background-color: #ddd;
}

#Productos table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: crimson;
  color: white;
}
</style>