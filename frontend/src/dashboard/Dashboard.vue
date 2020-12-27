<template>
  <div>
    <div class="column-left">
      <Editor @autoSaveEditorData="autoSaveEditorData"/>
    </div>
    <div class="column-right">
      <InteractableApp/>
    </div>
  </div>
</template>

<script>
import InteractableApp from "@/interactable/component/InteractablesApp";
import Editor from "@/editor/Editor";

export default {
  name: "Dashboard",
  components: {
    Editor,
    InteractableApp
  },
  methods: {
    autoSaveEditorData(editorData) {
      this.$store.commit("saveEditorData", editorData);
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