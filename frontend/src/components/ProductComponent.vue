<template>
  <div>
    {{ ProductComponent.title }}
  </div>
</template>

<script>
  export default {
    name: "Product",
    props: ['ProductComponent']
  }
</script>

<style scoped>

</style>