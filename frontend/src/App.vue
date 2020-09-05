<template>
  <div id="app">
    <div class="container">
      <div class="column-left">

      </div>
      <div class="column-right">
        <InteractableApp/>
      </div>
    </div>
  </div>
</template>

<script>

  import InteractableApp from "./components/InteractablesApp";

  export default {
    name: 'App',
    components: {
      InteractableApp
    }
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

  .container::after {
    clear: both;
    content: "";
    display: table;
    height: 100%;
    width: 100%;
  }

  .column-left {
    float: left;
    height: 95vh;
    padding: 5px;
    width: 35%;
  }

  .column-right {
    float: right;
    height: 95vh;
    padding: 5px;
    width: 64%;
  }
</style>
