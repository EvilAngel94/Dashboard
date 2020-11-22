<template>
  <div id="editor">
    <ckeditor :editor="editor" v-model="editorData" :config="editorConfig"/>
  </div>
</template>

<script>
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

export default {
  name: 'app',
  data() {
    return {
      editor: ClassicEditor,
      editorData: '',
      editorConfig: {}
    }
  },
  created() {
    this.editorData = this.pollAndSaveEditorData();
  },
  methods: {
    pollAndSaveEditorData() {
      this.editorData = setInterval(() => {
        this.$store.commit('saveEditorData', this.editorData);
        this.editorData = this.$store.getters.EDITOR_DATA;
      }, 2500);
    }
  }
}
</script>

<style>
/* This is the property to change the text editor */
.ck-editor__editable_inline {
  height: 880px;
  width: 100%;
}
</style>