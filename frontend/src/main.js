import Vue from "vue";
import Vuex from "vuex";
import App from "./App.vue";
import router from "./router/router";
import CKEditor from "@ckeditor/ckeditor5-vue";

Vue.config.productionTip = false;
Vue.use(CKEditor);
Vue.use(Vuex);

new Vue({
    router,
    render: (h) => h(App),
}).$mount('#app');
