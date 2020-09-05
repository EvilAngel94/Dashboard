import axios from "axios";

const INTERACTABLE_URL = "http://localhost:8080/api/interactable";

class InteractableService {
  getAllInteractables() {
    return axios.get(INTERACTABLE_URL);
  }
}

export default new InteractableService();