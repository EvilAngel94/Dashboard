const store = new Vuex.Store({
  state: {
    EDITOR_DATA: ''
  },
  mutations: {
    saveEditorData(data) {
      state.EDITOR_DATA = data;
      console.log(state.EDITOR_DATA);
    }
  }
})