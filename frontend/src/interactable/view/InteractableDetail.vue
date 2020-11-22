<template>
  <div>
    <div class="column-left">
      <Editor/>
    </div>
    <div class="column-right">
      <h2>Hello new page!</h2>
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
  data() {
    return {
      test: "test"
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