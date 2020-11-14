<template>
  <div id="app">
    <router-view :key="$route.path"/>
  </div>
</template>

<script>
export default { name: 'App' }
</script>

<style>
* {
  box-sizing: border-box;
}

html {
  background-color: #e5eaf5;
  height: 100%;
  overflow: hidden;
  width: 100%;
}

body {
  font-family: Roboto, serif;
  font-size: 22px;
  height: 100%;
  width: 100%;
}
</style>
