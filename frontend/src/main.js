import Vue from "vue";
import App from "./App.vue";
import router from "./router/router";
import CKEditor from "@ckeditor/ckeditor5-vue";
import {store} from "./editor/EditorStore";

Vue.config.productionTip = false;
Vue.use(CKEditor);

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');
