<template>
  <div>
    <div class="column-left">
      <Editor @autoSaveEditorData="autoSaveEditorData"/>
    </div>
    <div class="column-right">
      <h2 v-if="detailSlug === 'weather'">Welcome to the weather forecast</h2>
      <div class="row-detail">
        <img class="info-box-img"
             :src="require(`@/assets/${detailData.homeWeatherPicture}`)"
             :alt="detailData.homeWeatherPicture"/>
        <ul class="row-detail-text">
          <li>Location: {{ detailData.homeLocation }}</li>
          <li>Temperature: {{ detailData.homeTemperature }}</li>
          <li>Feel like temp: {{ detailData.homeTemperatureFeelsLike }}</li>
        </ul>
      </div>
      <div class="row-detail">
        <img class="info-box-img"
             :src="require(`@/assets/${detailData.workWeatherPicture}`)"
             :alt="detailData.workWeatherPicture"/>
        <ul class="row-detail-text">
          <li>Location: {{ detailData.workLocation }}</li>
          <li>Temperature: {{ detailData.workTemperature }}</li>
          <li>Feel like temp: {{ detailData.workTemperatureFeelsLike }}</li>
        </ul>
      </div>
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
  height: 90%;
  justify-content: space-between;
  margin: 5px;
  width: 70%;
  display: inline-block;
  list-style-type: none;
}

.info-box-img {
  display: inline-block;
  float: left;
  size: auto;
}

.hidden {
  display: none;
}
</style>