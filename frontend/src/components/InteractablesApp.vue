<template>
  <div id="app">
    <div class="row" :key="row" v-for="row in createRows">
      <div :key="interactableRow" v-for="interactableRow in row">
        <Interactable :Interactable="interactableRow"/>
      </div>
    </div>
  </div>
</template>

<script>
import Interactable from "../views/InteractableView";
import InteractableDataService from "@/dataservice/InteractableDataService";

const maxInteractablesOnARow = 3;
const chunk = (arr, size) =>
    arr.reduce((previousValue, _, index) =>
        (index % size) ? previousValue : [...previousValue, arr.slice(index, index + size)], []);

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
      InteractableDataService.getAllInteractables()
          .then(response => {
            this.interactables = response.data;
          });
    }
  },
  computed: {
    createRows() {
      return chunk(this.interactables, maxInteractablesOnARow);
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
  height: 320px;
  justify-content: space-evenly;
  margin: 6px;
}
</style>