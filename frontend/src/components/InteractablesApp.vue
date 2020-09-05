<template>
  <div class="row">
    <Interactable
            v-for="interactable in interactables"
            :key="interactable.id"
            :Interactable="interactable"
    />
  </div>
</template>

<script>
  import Interactable from "./Interactable";

  export default {
    name: "InteractablesApp",
    components: {
      Interactable
    },
    data() {
      return {
        interactables: [
          {
            id: 1,
            title: "Todoist",
            source: "todo-interaction-btn.gif",
          },
          {
            id: 2,
            title: "Sketching",
            source: "sketching-interaction-btn.gif"
          }
        ]
      }
    },
    // methods: {
    //   allButtons() {
    //     InteractableService.getAllInteractables()
    //       .then(response => {
    //         this.interactables = response.data;
    //       });
    //   }
    // },
    // created() {
    //   this.allButtons();
    // }
  }
</script>

<style scoped>
  .row {
    border-radius: 8px;
    display: flex;
    height: 220px;
    justify-content: space-evenly;
    margin: 10px;
  }
</style>