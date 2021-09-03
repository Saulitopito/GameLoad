<template>
  <div id="app" class="app">
    <div class="header">
      <h1><img src="./assets/Frame.svg"></h1>
  
      <nav>
        <button v-on:click="$router.push({name:'root'})" v-if="!is_auth"> Inicio </button>
        <button v-on:click="$router.push({name:'user_auth'})" v-if="!is_auth"> Iniciar Sesión </button>
        <button v-on:click="$router.push({name:'newuser'})" v-if="!is_auth"> Registrarse </button>
        <button v-on:click="init" v-if="is_auth" > Inicio </button>
        <button v-on:click="products" v-if="is_auth" > Productos </button>
        <button v-on:click="car" v-if="is_auth" > Mi Carrito </button>
        <button v-on:click="order" v-if="is_auth" > Ordenes </button>
        <button v-on:click="logOut" v-if="is_auth" > Cerrar Sesión </button>
      </nav>
    </div>.

    <div class="main-component">
      <h2>Hola</h2>
      <router-view v-on:log-in="logIn"></router-view>
    </div>

    <div class="all-footer">

      <figure class="logo-footer">
          <img src="./assets/Logos/logoWhite.png" alt="Logo">
      </figure>
    
      <div class="info">
        <a href="#">Tienda</a>
        <a href="#">Mas reciente</a>
        <a href="#">Accesorios premium</a>
        <a href="#">Suscripción</a>
      </div>

      <div class="servicio">
        <a href="#">Servicio al cliente</a>
        <a href="#">pedidos@gamesload.com</a>
        <a href="#">Cll 78 # 40-5 Bogotá, Colombia</a>
        <a href="#">(+57) 369 874 21 45  -  478 214 21</a>
      </div>

      <div class="socilamedia">
        <h2>Follow us</h2>
        <i id="facebook" class="fab fa-facebook"></i>
        <i id="youtube" class="fab fa-youtube"></i>
        <i id="insta" class="fab fa-instagram"></i>
      </div>
    </div>
  </div>
</template>

<script>

import gql from 'graphql-tag'
export default {
  name: 'App',
  data: function(){
    return{
      productosDisponibles: [],
      is_auth: false
    }
},

created: function(){
  this.updateAccessToken();
},

methods:{

  updateAccessToken: async function(){
    if(localStorage.getItem('refresh_token')==null){
      this.$router.push({name: "user_auth"})
      this.is_auth = false
      return;
  }

  await this.$apollo
    .mutate({
      mutation: gql`
        mutation ($refreshTokenRefresh: String!) {
          refreshToken(refresh: $refreshTokenRefresh) {
            access
          }
        }
      `,
    variables: {
      refreshTokenRefresh: localStorage.getItem('refresh_token')
    }
  })
  .then((result) => {
    localStorage.setItem('access_token', result.data.refreshToken.access)
    this.is_auth = true
  })
  .catch((error) => {
      alert("Su sesión expiró, vuelva a iniciar sesión.")
      this.$router.push({name: "user_auth"})
      this.is_auth = false
      localStorage.clear();
    });
  },

  logIn: async function(data, username){
    localStorage.setItem('access_token', data.access)
    localStorage.setItem('refresh_token', data.refresh)
    localStorage.setItem('user_id', data.user_id)
    localStorage.setItem('current_username', username)
    
    await this.updateAccessToken();
    if(this.is_auth) this.init();
  },

  init: function(){
    this.$router.push({
      name: "user",
      params:{ username: localStorage.getItem("current_username") }
    })
  },

  account: function () {
    this.$router.push({
      name: "account",
      params: { username: localStorage.getItem("current_username") },
    });
  },

  products: function () {
    this.$router.push({
      name: "products",
      params: { username: localStorage.getItem("current_username") },
    });
  },

  newuser: function () {
    this.$router.push({
      name: "newuser"
    });
  },

  car: function () {
    this.$router.push({
      name: "car",
      params: { username: localStorage.getItem("current_username") },
    });
  },

  order: function () {
    this.$router.push({
      name: "order",
      params: { username: localStorage.getItem("current_username") },
    });
  },

  logOut: async function(){
    localStorage.removeItem('access_token')
    localStorage.removeItem('refresh_token')
    localStorage.removeItem('user_id')
    localStorage.removeItem('current_username')
      
    await this.updateAccessToken();
    },
  },
};
</script>

<style>
  :root {
  --primary-color: #0D0D0D;
  --palette-pink: #EE05F2 ;
  --heavy-blue: #0378A6;
  --medium-blue: #04ADBF;
  --light-blue: #04D9C4;
  --secundary-color: #fff;
  --size: 18px;
  --ff-primary: 'Roboto', sans-serif;
  --ff-secondary: 'Oswald', sans-serif;
  --transition: all 0.3s linear;
  --spacing: 0.1rem;
  --radius: 0.25rem;
  --light-shadow: 0 5px 15px rgba();
  --dark-shadow: 0 5px 15px rgba();
  --max-width: 1170px;
  --fixed-width: 620px;
  }
  body{
    margin: 0 0 0 0;
  }

  .header{
    position: fixed;
    left: 0px;
    top: 0px;
    width: 100%;
    height: 100px;
    margin: 0%;
    padding: 0;

    background-color:var(--primary-color) ;
    color:#E5E7E9  ;

    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .header h1{
    width: 20%;
    text-align: center;
  }

  .header nav {
    height: 100%;
    width: 40%;

    display: flex;
    justify-content: space-around;
    align-items: center;

    font-size: 20px;
  }

  .header nav button{
    color: #E5E7E9;
    background: #283747;
    border: 1px solid #E5E7E9;

    border-radius: 5px;
    padding: 10px 20px;
  }

  .header nav button:hover{
    color: #283747;
    background: #E5E7E9;
    border: 1px solid #E5E7E9;
  }

  .main-component{
    height: 75vh;
    margin: 0%;
    padding: 0%;
    display: flex;
    background: #FDFEFE ;
  }

 .all-footer{
    align-items: center;
    background: var(--primary-color);
    bottom: 0;
    color:var(--secundary-color);
    display: flex;
    grid-gap: 80px;
    height: auto;
    justify-content: center;
    padding: 20px 0;
    position: absolute;
    width: 100%;
  }
  .logo-footer img {
    height: 80px;
    margin: 0 20px;
    vertical-align: bottom;
    align-items: flex-start;
  }
  .all-footer a {
    text-decoration: none;
    color: var(--secundary-color);
    text-transform: uppercase;
    display: flex;
    font-weight: 500;
    align-items: center;
    padding: 0 20px;
  }
  .socilamedia i {
    font-size: 30px;cursor: pointer;
  }
  .sponsor {
    display: flex;
  }
  .sponsor img {
    height: 5%;  
  }
</style>