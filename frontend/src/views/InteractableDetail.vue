<template>
  <div class="column-right">
    <h2>Hello new page!</h2>
    <img :src="require(`@/assets/logo.png`)">
  </div>
</template>

<script>
export default {
  name: "InteractableDetail"
}
</script>

<style scoped>
.column-right {
  float: right;
  height: 95vh;
  padding: 5px;
  width: 64%;
}
</style>