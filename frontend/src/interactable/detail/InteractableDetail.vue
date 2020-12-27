<template>
  <div>
    <div class="column-left">
      <Editor @autoSaveEditorData="autoSaveEditorData"/>
    </div>
    <div class="column-right">
      <h2>Hello new page!</h2>
      <p>
        {{ detailSlug }}
      </p>
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
          this.detailData = response.data;
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
</style>