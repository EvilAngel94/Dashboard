<template>
  <div class="container">
    <div class="column-right">
<!--      <script async src="https://cse.google.com/cse.js?cx=9a90fb5e12c20eb49"></script>-->
      <div class="gcse-search"></div>
      <div class="row">
        <img class="row-element"
             src="../assets/image/button/weather-forecast-btn.png"
             alt="Weather Forecast"
             onmouseover="setInteractiveGif(this, './image/button/interactive/weather-forecast-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/weather-forecast-btn.png')"
             onclick="getWeatherForecast()">
        <img class="row-element"
             src="../assets/image/button/pers-mail-btn.png"
             alt="Mail"
             onmouseover="setInteractiveGif(this, './image/button/interactive/pers-mail-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/pers-mail-btn.png')"
             onclick="goToMail()">
        <img class="row-element"
             src="../assets/image/button/work-mail-btn.png"
             alt="WorkMail"
             onmouseover="setInteractiveGif(this, './image/button/interactive/work-mail-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/work-mail-btn.png')"
             onclick="goToWorkMail()">
      </div>
      <div id="row-details" class="closed"></div>
      <div class="row">
        <img alt="Google Drive"
             class="row-element"
             onclick="goToDrive()"
             onmouseover="setInteractiveGif(this, './image/button/interactive/google-drive-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/google-drive-btn.png')"
             src="../assets/image/button/google-drive-btn.png">
        <img class="row-element"
             src="../assets/image/button/sketching-btn.png"
             alt="Sketching"
             onmouseover="setInteractiveGif(this, './image/button/interactive/sketching-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/sketching-btn.png')"
             onclick="goToSketching()">
        <img class="row-element"
             src="../assets/image/button/todo-btn.png"
             alt="Todoist"
             onmouseover="setInteractiveGif(this, './image/button/interactive/todo-interaction-btn.gif')"
             onmouseout="setOriginalPicture(this, '../image/button/todo-btn.png')"
             onclick="goToTodoist()">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Dashboard",
  data() {
    return {
      target: "_blank"
    }
  },
  methods: {
    setInteractiveGif(value, path) {
      value.src = path;
    },
    setOriginalPicture(value, path) {
      value.src = path;
    },
    goToMail() {
      window.open("https://www.gmail.com", this.target);
    },
    goToWorkMail() {
      window.open("https://www.outlook.com", this.target);
    },
    goToTodoist() {
      window.open("https://www.todoist.com", this.target);
    },
    goToSketching() {
      window.open("https://www.autodraw.com/", this.target);
    },
    goToDrive() {
      window.open("https://drive.google.com/drive/my-drive", this.target);
    }
  }
}
</script>

<style scoped>
.column-right {
  float: right;
  height: 95vh;
  padding: 5px;
  width: 64%;
}

.row {
  border-radius: 8px;
  display: flex;
  height: 220px;
  justify-content: space-evenly;
  margin: 10px;
}

.row-element {
  background-color: #d0bdf4;
  border-radius: 25%;
  border: solid #4f2f4f 2px;
  display: inline-block;
  height: 220px;
  outline: none;
  padding: 4px;
  position: relative;
  width: 220px;
}

.row-element:hover {
  cursor: pointer;
}

</style>