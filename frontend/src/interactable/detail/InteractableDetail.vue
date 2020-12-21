<template>
  <div>
    <div class="column-left">
      <Editor @autoSaveEditorData="autoSaveEditorData"/>
    </div>
    <div class="column-right">
      <h2>Hello new page!</h2>
      <p>
        {{ test }}
      </p>
      <img :src="require(`@/assets/logo.png`)" :alt="test">
      <router-link :to="{name: 'Dashboard'}">
        <h3>Go back to Dashboard</h3>
      </router-link>
    </div>
  </div>
</template>

<script>
import Editor from "@/editor/Editor";

export default {
  name: "InteractableDetail",
  components: {
    Editor
  },
  props: ['slug'],
  data() {
    return {
      detailData: null,
      test: this.slug
    }
  },
  methods: {
    autoSaveEditorData(editorData) {
      this.$store.commit("saveEditorData", editorData);
    },
    obtainTheDetails(details) {
      this.$store.dispatch("obtainInteractableDetails", details)
    }
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