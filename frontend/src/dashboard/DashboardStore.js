import Vue from "vue";
import Vuex from "vuex";
import EditorDataService from "@/editor/EditorDataService";

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    EDITOR_DATA: ''
  },
  mutations: {
    saveEditorData(state, data) {
      EditorDataService.storeEditorData(data)
        .then(r => state.EDITOR_DATA = r.data);
    }
  },
  actions: {
    obtainEditorContent() {
      return EditorDataService.getEditorData();
    }
  }
});