import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    EDITOR_DATA: ''
  },
  mutations: {
    saveEditorData(state, data) {
      state.EDITOR_DATA = data;
      console.log(state.EDITOR_DATA);
    }
  },
  getters: {
    EDITOR_DATA: state => state.EDITOR_DATA
  }
});