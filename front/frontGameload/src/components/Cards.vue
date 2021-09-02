<template>
  <div class="product">
    <div class="product-content">
      <div class="product-image-wrap">
        <img :src="product.src"/>
        <img src="../assets/products/batman-arkham-knight.jpg" />
      </div>
      <div class="product-detail">
        <p>{{product.category}}</p>
        <h2>{{ product.title }}</h2>
        <h3>{{ product.price }}</h3>
        <button class="comprar">Añadir al carrito</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'product',
  props: ['product']
}
</script>

<style>
    .product
    {width: 100%; color:var(--primary-color); overflow: hidden;}
    .product-content 
    {position: relative;padding: 25px;overflow: hidden;}
    .product-image-wrap 
    {position: relative;z-index: 1;}
    .product-image-wrap img
    { max-width: 250px;}
    .product-detail 
    {padding: 25px;margin: 0px -25px -25px; border-radius: 0 0 20px 20px ;}
    .product-detail p
    {color: var(--medium-blue); }
    .product-detail h2 
    {font-size: 24px;font-weight: 700;}
    .product-detail h3 
    {padding-bottom: 10px; font-size: 12px;}
    .product-detail .comprar
    {background: var(--heavy-blue);border: none;  padding: 5px; font-weight: 700;color: var(--secundary-color); margin: 10px 0 10px;}
    .product-detail .comprar:hover{background: var(--medium-blue);}
    .product:hover
    {box-shadow: 0px 0px 16px rgba(0, 0, 0, 0.25);}
</style>
