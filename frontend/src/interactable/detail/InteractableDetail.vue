<template>
  <div>
    <div class="column-left">
      <Editor @autoSaveEditorData="autoSaveEditorData"/>
    </div>
    <div class="column-right">
      <h2 v-if="detailSlug === 'weather'">Welcome to the weather forecast</h2>
      <div class="row-detail">
        <p class="row-detail-text">
          <!-- Create some sort of list in this -->
          {{ detailData.homeLocation }}
          {{ detailData.homeTemperature }}
          {{ detailData.homeTemperatureFeelsLike }}
          {{ detailData.homeLocation }}
        </p>
      </div>
      <img :src="require(`@/assets/logo.png`)" :alt="slug">
      <router-link :to="{name: 'Dashboard'}">
        <h3>Go back to Dashboard</h3>
      </router-link>
    </div>
  </div>
</template>

<script>
import Editor from "@/editor/Editor";
import InteractableDataService from "@/interactable/dataservice/InteractableDataService";
import InteractableDetailInfo from "./InteractableDetailInfo";

export default {
  name: "InteractableDetail",
  components: {
    Editor
  },
  props: ['slug'],
  data() {
    return {
      detailData: null,
      detailSlug: this.slug
    }
  },
  methods: {
    autoSaveEditorData(editorData) {
      this.$store.commit("saveEditorData", editorData);
    },
    obtainTheDetails(details) {
      this.detailData = InteractableDataService.getInteractableDetail(details)
        .then((response) => {
          this.detailData = InteractableDetailInfo.from(response.data);
        });
    }
  },
  created() {
    this.obtainTheDetails(this.detailSlug);
  }
}
</script>

<style scoped>
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

.row-detail {
  background-color: #a0d2eb;
  border-radius: 8px;
  border: solid #4f2f4f 2px;
  display: flex;
  height: 250px;
  margin: 10px;
  padding: 4px;
  width: 90%;
}

.row-detail-text {
  background-color: #a0d2eb;
  border: solid #8458b3 1px;
  height: 90%;
  justify-content: space-between;
  margin: 5px;
  width: 70%;
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