let isAlreadyExecuted = false

/**
 * This function is responsible for displaying the information obtained from the server regarding weather forecast
 */
function getWeatherForecast() {
    if (!isAlreadyExecuted) {
        fetch("http://localhost:8080/rest/weather")
            .then(response => {
                return response.json();
            }).then(
            (data) => {
                const weatherRow = document.getElementById("row-details");
                weatherRow.className = "row-detail";
                weatherRow.classList.remove("closed");

                const weatherForecast = new WeatherForecast(data.weatherForecast, data.homeWeatherPicture, data.workWeatherPicture);

                // Creation of the home element
                createInfoBox(
                    weatherRow,
                    weatherForecast.homePictureLocation,
                    weatherForecast.homeLocation,
                    weatherForecast.homeTemp,
                    weatherForecast.homeFeelsLikeTemp
                );

                // Creation of the work element
                createInfoBox(
                    weatherRow,
                    weatherForecast.workPictureLocation,
                    weatherForecast.workLocation,
                    weatherForecast.workTemp,
                    weatherForecast.workFeelsLikeTemp
                );
                isAlreadyExecuted = true;
            }
        ).catch(error => {
            return error;
        });
    } else {
        let infoBoxes = document.getElementsByClassName("info-box");
        for (let i = infoBoxes.length; i > 0; i--) {
            infoBoxes[i - 1].remove();
        }

        const weatherRow = document.getElementById("row-details");
        weatherRow.className = "closed";
        isAlreadyExecuted = false;
    }
}

class WeatherForecast {
    /**
     * @param forecast.homeLocation: String
     * @param forecast.workLocation: String
     * @param forecast.homeTemperature: Double
     * @param forecast.homeTemperatureFeelsLike: Double
     * @param forecast.workTemperature: Double
     * @param forecast.workTemperatureFeelsLike: Double
     */
    constructor(forecast, homeLocationPicture, workLocationPicture) {
        this.homePictureLocation = homeLocationPicture;
        this.workPictureLocation = workLocationPicture;
        this.homeLocation = forecast.homeLocation;
        this.homeTemp = forecast.homeTemperature;
        this.homeFeelsLikeTemp = forecast.homeTemperatureFeelsLike;
        this.workLocation = forecast.workLocation;
        this.workTemp = forecast.workTemperature;
        this.workFeelsLikeTemp = forecast.workTemperatureFeelsLike;
    }
}

function createInfoBox(weatherRow, weatherPicture, location, temperature, feelsLikeTemp) {
    const infoBox = document.createElement("div");
    infoBox.className = "info-box";
    weatherRow.append(infoBox);

    createImageElement(weatherPicture, infoBox);
    createInfoBoxElement(location, temperature, feelsLikeTemp, infoBox);
}

function createImageElement(weatherPicture, infoBox) {
    const imgElement = document.createElement("img");
    imgElement.src = weatherPicture;
    imgElement.className = "info-box-img";
    infoBox.append(imgElement);
}

function createInfoBoxElement(location, temperature, feelsLikeTemp, infoBox) {
    const contentInfoBox = document.createElement("ul");
    contentInfoBox.className = "info-box-content";

    const locationElement = document.createElement("li");
    locationElement.textContent = location;
    contentInfoBox.append(locationElement);

    const temperatureElement = document.createElement("li");
    temperatureElement.textContent = "Temperature: " + temperature;
    contentInfoBox.append(temperatureElement);

    const feelsLikeTempElement = document.createElement("li");
    feelsLikeTempElement.textContent = "Temperature feels like: " + feelsLikeTemp;
    contentInfoBox.append(feelsLikeTempElement);

    infoBox.append(contentInfoBox);
}

