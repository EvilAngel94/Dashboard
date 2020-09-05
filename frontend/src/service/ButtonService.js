import axios from "axios";

const BUTTON_URL = "http://localhost:8080/api/button";

class ButtonService {
  getAllButtons() {
    return axios.get(BUTTON_URL);
  }
}

export default new ButtonService();