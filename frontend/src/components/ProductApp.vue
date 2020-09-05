<template>
  <section>
    <ProductComponent
            v-for="product in products"
            :key="product.color"
            :ProductComponent="product"
    />
  </section>
</template>

<script>
  import ProductComponent from "./ProductComponent";

  export default {
    name: "ProductApp",
    components: {
      ProductComponent
    },
    data() {
      return {
        products: [
          {
            title: 'Nike Air',
            color: 'green',
            bgText: 'NIKE',
            src: './asserts/image/button/todo-btn.png'
          },
          {
            title: 'Adidas Air',
            color: 'yellow',
            bgText: 'ADIDAS',
            src: './asserts/image/button/sketching-btn.png'
          }
        ]
      }
    }
  }
</script>

<style scoped>

</style>