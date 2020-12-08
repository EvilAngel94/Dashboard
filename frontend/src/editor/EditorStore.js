import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import EditorDataService from "@/editor/EditorDataService";

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
  getters: {
    EDITOR_DATA: EditorDataService.getEditorData
  }
});