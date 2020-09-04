<template>
  <div class="column-left">
    <div class="ribbon">
      <!-- change size and use titels -->
      <label>
        <select>
          <option value="H1">Title</option>
          <option value="H2">Heading 1</option>
          <option value="H3">Heading 2</option>
          <option value="H4">Heading 3</option>
        </select>
      </label>
      <!-- font size -->
      <label>
        <select>
          <option value="3">14</option>
          <option value="4">16</option>
          <option value="5">18</option>
        </select>
      </label>
    </div>
    <div id="editor" contenteditable="true" spellcheck="false"></div>
  </div>
</template>

<script>
export default {
  name: "Editor"
}
</script>

<style scoped>

</style>