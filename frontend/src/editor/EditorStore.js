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
  actions: {
    getEditorData(context, data) {
      context.commit("EDITOR_DATA", data);
    }
  }
});

export default store;