<template>
  <div id="app">
    <dashboard/>
  </div>
</template>

<script>
import Dashboard from "@/components/Dashboard";

export default {
  name: 'App',
  components: {Dashboard}
}
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
