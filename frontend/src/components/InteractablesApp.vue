<template>
  <!--  <div class="row">-->
  <!--    &lt;!&ndash; https://stackoverflow.com/questions/54408841/vue-js-insert-block-for-evvery-6th-loop-element &ndash;&gt;-->
  <!--    <Interactable-->
  <!--            v-for="interactable in interactables"-->
  <!--            :key="interactable.id"-->
  <!--            :Interactable="interactable"-->
  <!--    />-->
  <!--  </div>-->
  <div id="app">
    <div class="row" :key="i" v-for="i in Math.ceil(interactables.length / 3)">
      <div :key="offer" v-for="offer in interactables.slice((i-1)*3, i*3)">
        <Interactable
            v-for="interactable in interactables"
            :key="interactable.id"
            :Interactable="offer"
        />
      </div>
    </div>
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