<template>
  <div id="app">
    <div class="row" :key="row" v-for="row in createRows">
      <div v-for="interactable in row" :key="interactable.id">
        <div v-if="isNotEmpty(interactable.slug)" class="row-element">
          <router-link :to="{name: 'InteractableDetail', params: {slug: interactable.slug}}">
            <div class="row-element-img">
              <img
                :src="require(`@/assets/image/button/${interactable.placeholderSrc}`)"
                @mouseover="interactable.placeholderSrc = interactable.gif"
                @mouseleave="interactable.placeholderSrc = interactable.src"
                v-bind:alt="interactable.title"
              />
            </div>
          </router-link>
          <div class="row-element-title">
            {{ interactable.title }}
          </div>
        </div>
        <div v-else class="row-element">
          <div class="row-element-img">
            <img
              :src="require(`@/assets/image/button/${interactable.placeholderSrc}`)"
              @mouseover="interactable.placeholderSrc = interactable.gif"
              @mouseleave="interactable.placeholderSrc = interactable.src"
              v-bind:alt="interactable.title"
              @click="redirect(interactable.redirectionUrl);"
            />
          </div>
          <div class="row-element-title">
            {{ interactable.title }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import InteractableDataService from "@/interactable/dataservice/InteractableDataService";

const maxInteractablesOnARow = 3;
const chunk = (arr, size) =>
  arr.reduce((previousValue, _, index) =>
    (index % size) ? previousValue : [...previousValue, arr.slice(index, index + size)], []);

export default {
  name: "InteractablesApp",
  components: {},
  data() {
    return {
      interactables: [],
      interactable: {
        redirectionUrl: String,
        placeholderSrc: String,
        src: String,
        slug: String,
        gif: String,
        title: String
      }
    }
  },
  methods: {
    allButtons() {
      InteractableDataService.getAllInteractables()
        .then(response => {
          this.interactables = response.data;
        });
    },
    redirect: function (url) {
      if (url !== "") {
        window.open(url, "_blank");
      }
    },
    isNotEmpty(slug) {
      return slug !== "";
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

.row-element {
  background-color: #d0bdf4;
  border-radius: 25%;
  border: solid #4f2f4f 2px;
  display: inline-block;
  height: 300px;
  outline: none;
  padding: 4px;
  position: relative;
  width: 300px;
}

.row-element-img {
  text-align: center;
}

.row-element-title {
  text-align: center;
  font-size: 28px;
}

.row-element:hover {
  cursor: pointer;
}
</style>