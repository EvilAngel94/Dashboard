<template>
  <div class="row">
    <!-- https://stackoverflow.com/questions/54408841/vue-js-insert-block-for-every-6th-loop-element -->
    <Interactable
            v-for="interactable in interactables"
            :key="interactable.id"
            :Interactable="interactable"
    />
  </div>
</template>

<script>
import Interactable from "./Interactable";
import InteractableService from "@/service/InteractableService";

export default {
    name: "InteractablesApp",
    components: {
      Interactable
    },
    data() {
      return {
        interactables: []
      }
    },
    methods: {
      allButtons() {
        InteractableService.getAllInteractables()
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
  .row {
    border-radius: 8px;
    display: flex;
    height: 220px;
    justify-content: space-evenly;
    margin: 10px;
  }
</style>