<template>
  <div class="container">
    <div class="column-right">
      <!--      <script async src="https://cse.google.com/cse.js?cx=9a90fb5e12c20eb49"></script>-->
      <div class="gcse-search"></div>
      <div v-for="button in interactables" v-bind:key="button.id" class="row">
        <div class="row-element">
<!--          <card :-->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import ButtonService from '../service/InteractableService';

  export default {
    name: "Dashboard",
    data() {
      return {
        interactables: [],
        test: [
          {
            name: "todoist",
            img: "../assets/image/button/todo-btn.png",
            src: "https://www.todoist.com"
          }
        ]
      }
    },
    methods: {
      allButtons() {
        ButtonService.getAllInteractables()
          .then(response => {
            this.interactables = response.data;
          });
      }
    },
    created() {
      this.allButtons();
    }
  }
</script>

<style scoped>

  .column-right {
    float: right;
    height: 95vh;
    padding: 5px;
    width: 64%;
  }

  .row {
    border-radius: 8px;
    display: flex;
    height: 220px;
    justify-content: space-evenly;
    margin: 10px;
  }

  .row-element {
    background-color: #d0bdf4;
    border-radius: 25%;
    border: solid #4f2f4f 2px;
    display: inline-block;
    height: 220px;
    outline: none;
    padding: 4px;
    position: relative;
    width: 220px;
  }

  .row-element:hover {
    cursor: pointer;
  }

  .container::after {
    clear: both;
    content: "";
    display: table;
    height: 100%;
    width: 100%;
  }

  .row-detail {
    background-color: #a0d2eb;
    border-radius: 8px;
    border: solid #4f2f4f 2px;
    display: flex;
    height: 150px;
    margin: 10px;
    padding: 4px;
    width: 70%;
  }

  .info-box {
    background-color: #a0d2eb;
    border: solid #8458b3 1px;
    height: 90%;
    justify-content: space-between;
    margin: 5px;
    width: 50%;
  }

  .info-box-img {
    display: inline-block;
    float: left;
    size: auto;
  }

  .info-box-content {
    display: inline-block;
    font-family: Roboto, serif;
    font-size: 14px;
    list-style-type: none;
  }

  .hidden {
    display: none;
  }

</style>