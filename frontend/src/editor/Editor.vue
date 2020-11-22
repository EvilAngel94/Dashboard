<template>
  <div id="editor">
    <ckeditor :editor="editor" v-model="editorData" :config="editorConfig"/>
  </div>
</template>

<script>
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import getDataFromEditor from './EditorStore';

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
    this.editorData = getDataFromEditor();
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