<template>
  <div class="container">
    <router-view :key="$route.path"/>
  </div>
</template>

<script>
export default {name: 'App'}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap");

* {
  box-sizing: border-box;
  /* Works on FireFox */
  scrollbar-width: thin;
  scrollbar-color: #d0bdf4 #e5eaf5;
}

/* Works on Chrome, Edge, and Safari */
*::-webkit-scrollbar {
  width: 6px;
}

*::-webkit-scrollbar-track {
  background: #e5eaf5;
}

*::-webkit-scrollbar-thumb {
  background-color: #d0bdf4;
  border: 3px solid #d0bdf4;
}

html {
  background-color: #e5eaf5;
  height: 100%;
  overflow: hidden;
  width: 100%;
  overflow: -moz-scrollbars-vertical;
  overflow-y: scroll;
}

body {
  font-family: Roboto, serif;
  font-size: 22px;
  height: 100%;
  width: 100%;
}

.container::after {
  clear: both;
  content: "";
  display: table;
  height: 100%;
  width: 100%;
}
</style>
