<template>
  <div id="editor">
    <vue-editor v-model="editorData" :editorToolbar="customToolbar"></vue-editor>
  </div>
</template>

<script>
import {VueEditor} from "vue2-editor";

export default {
  name: "app",
  components: {
    VueEditor
  },
  data() {
    return {
      editorData: "",
      customToolbar: [
        ["bold", "italic", "underline"],
        [
          {
            "size":
              ["small", false, "large", "huge"]
          }
        ],
        [
          {"color": []},
          {"background": []}
        ],
        [
          {"align": ""},
          {"align": "center"},
          {"align": "right"},
          {"align": "justify"}
        ],
        [
          {list: "ordered"},
          {list: "bullet"}
        ],
        ["image", "code-block"]
      ]
    }
  },
  created() {
    this.SaveEditorData();
  },
  methods: {
    SaveEditorData() {
      setInterval(() => {
        this.$store.commit("saveEditorData", this.editorData);
      }, 2000);
    }
  }
}
</script>

<style>
</style>