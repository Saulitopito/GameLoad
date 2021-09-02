<template>
  
<div class="all-footer">

    <figure class="logo-footer">
        <img src="../assets/Logos/logoWhite.png" alt="Logo">
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
      <a href="#">Cll 78 #40-5 Bogotá, Colombia</a>
      <a href="#">(+57)369 874 21 45  -  478 214 21</a>
    </div>

    <div class="socilamedia">
      <h2>Follow us</h2>
      <i id="facebook" class="fab fa-facebook"></i>
      <i id="youtube" class="fab fa-youtube"></i>
      <i id="insta" class="fab fa-instagram"></i>
    </div>

    <!-- <div class="sponsor">
      <img src="./assets/footer/textonly.png" alt="Encuentra" height="30px">
      <img src="./assets/footer/logops.png" alt="Logo PS" height="30px">
      <img src="./assets/footer/logonswitch.png" alt="Logo Nintendo" height="30px">
      <img src="./assets/footer/logoxbox.png" alt="Logo XBox" height="30px">
    </div> -->
  </div>

 
</template>

<script scope>
export default {
  name: 'Footer'
}
</script>

<style>
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
