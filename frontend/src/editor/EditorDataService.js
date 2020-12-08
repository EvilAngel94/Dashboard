import axios from "axios";

const EDITOR_BASE_URL = "http://localhost:1997/api/editor";

class EditorDataService {
  getEditorData() {
    return axios.get(EDITOR_BASE_URL + "/data");
  }

  storeEditorData(content) {
    return axios.put(EDITOR_BASE_URL + "/store", null, {params: {dataToStore: content}});
  }
}

export default new EditorDataService();