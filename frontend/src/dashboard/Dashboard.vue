<template>
  <div>
    <div class="column-left">
      <Editor/>
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
  height: 150px;
  margin: 10px;
  padding: 4px;
  width: 70%;
}

.info-box {
  background-color: #a0d2eb;
  border: solid #8458b3 1px;
  height: 90%;
  justify-content: space-between;
  margin: 5px;
  width: 50%;
}

.info-box-img {
  display: inline-block;
  float: left;
  size: auto;
}

.info-box-content {
  display: inline-block;
  font-family: Roboto, serif;
  font-size: 14px;
  list-style-type: none;
}

.hidden {
  display: none;
}
</style>