<template>
  <div id="editor">
    <vue-editor
      v-model="editorData"
      :editorToolbar="customToolbar"
    />
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
  methods: {
    initializeTheEditor() {
      setInterval(() => {
        this.$emit("autoSaveEditorData", this.editorData);
      }, 1000);

      this.$store.dispatch("obtainEditorContent").then((data) => {
        this.editorData = data.data.editorData
      });
    }
  },
  created() {
    this.initializeTheEditor()
  }
}
</script>
<style>
#editor {
  border: solid #4f2f4f 2px;
  background-color: #e5eaf5;
  height: 95vh;
}

#quill-container {
  height: 90vh;
  border: solid #4f2f4f;
  border-left: 0;
  border-right: 0;
}

.ql-toolbar {
  background-color: #d0bdf4;
}
</style>