<template>
  <div class="row-element">
    <div class="row-element-img">
      <img
          :src="require(`@/assets/image/button/${Interactable.placeholderSrc}`)"
          @mouseover="Interactable.placeholderSrc = Interactable.gif"
          @mouseleave="Interactable.placeholderSrc = Interactable.src"
          v-bind:alt="Interactable.title"/>
    </div>
    <div class="row-element-title">
      {{ Interactable.title }}
    </div>
  </div>
</template>

<script>
  export default {
    name: "Interactable",
    props: [
      "Interactable"
    ]
  }
</script>

<style scoped>
  .row-element {
    background-color: #d0bdf4;
    border-radius: 25%;
    border: solid #4f2f4f 2px;
    display: inline-block;
    height: 300px;
    outline: none;
    padding: 4px;
    position: relative;
    width: 300px;
  }

  .row-element-img {
    text-align: center;
  }

  .row-element-title {
    text-align: center;
    font-size: 28px;
  }

  .row-element:hover {
    cursor: pointer;
  }
</style>