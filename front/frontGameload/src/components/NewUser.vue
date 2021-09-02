<template>
  <div class="wrapper__login">

    <div class="logo"><img src="../assets/Logos/logoLightblue.png" alt="GameApp"></div>

		<div class="contain content1">

      <div class="cabecero">
        <h2>{{ msg1 }}</h2>
        <p>Es rápido y fácil.</p>
      </div>
      <div id="NewUser" class="newuser">
        <form class="newform" v-on:submit.prevent="proccessUser">
          <input
            type="text"
            v-model="createUserUser.username"
            placeholder="Usuario"
          />
          <br />
          <input
            type="text"
            v-model="createUserUser.name"
            placeholder="Nombre"
          />
          <br />
          <input
            type="password"
            v-model="createUserUser.password"
            placeholder="Contraseña"
          />
          <br />
          <input
            type="email"
            v-model="createUserUser.email"
            placeholder="Email"
          />
          <br />
          <input
            type="text"
            v-model="createUserUser.address"
            placeholder="Dirección"
          />
          <br />
          <button type="submit">Crear cuenta</button>
        </form>
      </div>
		</div>
	</div>
</template>

<script>
import gql from "graphql-tag";

export default {
  name: "NewUser",

  data: function () {
    return {
      createUserUser: {
        username: "",
        name: "",
        password: "",
        email: "",
        address: "",
      },
    };
  },

  methods: {
    proccessUser: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation Mutation($createUserUser: UserInput!) {
              createUser(user: $createUserUser) {
                username
                name
                password
                email
                address
              }
            }
          `,
          variables: {
            createUserUser: this.createUserUser,
          },
        })
        .then((result) => {
          alert("Usuario creado de manera correcta")
        })
        .catch((error) => {
            alert("Error");
        });
    },
  },
};



</script>

<style scope>
.wrapper__login {
  align-items:center;
  background: var(--secundary-color);
  display: flex;
  flex-flow:column;
  justify-content:center;
  min-height: 100%;
  width: 100%;
  color: var(--primary-color);
}

.content1 {
  display: flex;
  flex-flow:column;
  padding-bottom: 100px;
  text-align: center;
  width: 430px;
}
.registro { 
  display: flex;
}
.logo {
  background: #f1f1f1;
  border-radius: 50%;
  height: 9em;
  width: 9em;
}
.logo img {
  padding: 5px 0 0 40px;
  width: 7em;
}
.cabecero {
  margin: 0 auto;
}
.cabecero h2 {
  font-family: var(--ff-secondary);
  font-size: 1em;
  font-weight: 700;
  letter-spacing: var(--spacing);
}
.cabecero p {
  float: left;
  padding: 16px 0;
  width: 96%;
}
.close {
  display:flex;
  position: absolute;
  float: right;
  right: 20px;
  top: 100px
}
.cabecero p {
  display: flex;
  margin-bottom: 0px;
}
.col {
  display: inline-block;
  width: 49%;
  margin-bottom: 10px;
  padding: 0 5px;
  vertical-align: top;
  text-align: left;
}  
.form .resaltado {
  color:var(--light-blue);
}


.newform h2{
    color: #283747;

}

.newform form{
    width: 50%;
    
}

.newform input{
    height: 40px;
    width: 100%;

    box-sizing: border-box;
    padding: 10px 20px;
    margin: 5px 0;

    border: 1px solid #283747;
    
}

.newform button{
    width: 100%;
    height: 40px;

    color: #E5E7E9;
    background: #283747;
    border: 1px solid #E5E7E9;

    border-radius: 5px;
    padding: 10px 25px;
    margin: 5px 0;
}

.newform button:hover{
    color: #E5E7E9;
    background: crimson;
    border: 1px solid #283747;
}
 
@media (max-width: 480px){
  .logo { display: none;}
  .logo img { display: none;}
  .cabecero p { font-size: 16px;}
  .form input[type="text"].small {width: 29%;}
}
</style>