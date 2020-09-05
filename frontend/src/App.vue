<template>
  <div id="app">
    <instructorApp />
  </div>
</template>

<script>
  import InstructorApp from "@/components/InstructorApp";

  export default {
    name: 'App',
    components: {
      InstructorApp
    }
  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  @import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)

</style>
