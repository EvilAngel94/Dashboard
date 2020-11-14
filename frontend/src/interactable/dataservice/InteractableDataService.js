import axios from "axios";

const INTERACTABLE_URL = "http://localhost:1997/api/interactable";

class InteractableDataService {
  getAllInteractables() {
    return axios.get(INTERACTABLE_URL);
  }
}

export default new InteractableDataService();