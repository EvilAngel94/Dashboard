import axios from "axios";

const BASE_URL = "http://localhost:1997/api"

class InteractableDataService {
  getAllInteractables() {
    return axios.get(BASE_URL + "/interactable");
  }

  getInteractableDetail(nameOfTheInteractableToLoad) {
    return axios.get(BASE_URL + "/detail", {params: {detailName: nameOfTheInteractableToLoad}});
  }
}

export default new InteractableDataService();