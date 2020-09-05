<template>
  <div id="app">
    <ckeditor :editor="editor" v-model="editorData" :config="editorConfig" class="editor"/>
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
    }
  }
</script>

<style scoped>
  .editor {
    background-color: #e5eaf5;
    border: 2px solid mediumpurple;
    font-family: Roboto, serif;
    font-size: 16px;
    height: 95%;
    width: 100%;
  }
</style>