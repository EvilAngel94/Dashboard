var isAlreadyExecuted = false

/**
 * This function is responsible for displaying the information obtained from the server regarding weather forecast
 */
function getWeatherForecast() {
    if (!isAlreadyExecuted) {
        fetch('http://localhost:8080/rest/weather')
            .then(response => {
                return response.json()
            }).then(
            weatherForecast => {
                const weatherRow = document.getElementById('row-details')
                weatherRow.className = 'row-detail'

                const forecast = weatherForecast.weatherForecast;

                // Creation of the home element
                const homePictureLocation = weatherForecast.homeWeatherPicture
                const location = forecast.homeLocation
                const temperature = forecast.homeTemperature
                const feelsLikeTemp = forecast.homeTemperatureFeelsLike
                createInfoBox(weatherRow, homePictureLocation, location, temperature, feelsLikeTemp);

                // Creation of the work element
                const workPictureLocation = weatherForecast.workWeatherPicture
                const locationWork = forecast.workLocation
                const temperatureWork = forecast.workTemperature
                const temperatureFeelsLikeWork = forecast.workTemperatureFeelsLike
                createInfoBox(weatherRow, workPictureLocation, locationWork, temperatureWork, temperatureFeelsLikeWork)
                isAlreadyExecuted = true
            }
        ).catch(error => {
            console.log(error)
            console.log('Something somewhere went wrong. What could it be...?')
        })
    } else {
        document.getElementById('row-details').removeChild('info-box')
        isAlreadyExecuted = false;
    }
}

function createInfoBox(weatherRow, weatherPicture, location, temperature, feelsLikeTemp) {
    const infoBox = document.createElement('div')
    infoBox.className = 'info-box'
    weatherRow.append(infoBox)

    createImageElement(weatherPicture, infoBox);
    createInfoBoxElement(location, temperature, feelsLikeTemp, infoBox);
}

function createImageElement(weatherPicture, infoBox) {
    const imgElement = document.createElement('img')
    imgElement.src = weatherPicture
    imgElement.className = 'info-box-img'
    infoBox.append(imgElement)
}

function createInfoBoxElement(location, temperature, feelsLikeTemp, infoBox) {
    const contentInfoBox = document.createElement('ul')
    contentInfoBox.className = 'info-box-content'

    const locationElement = document.createElement('li')
    locationElement.textContent = location
    contentInfoBox.append(locationElement)

    const temperatureElement = document.createElement('li')
    temperatureElement.textContent = "Temperature: " + temperature
    contentInfoBox.append(temperatureElement)

    const feelsLikeTempElement = document.createElement('li')
    feelsLikeTempElement.textContent = "Temperature feels like: " + feelsLikeTemp
    contentInfoBox.append(feelsLikeTempElement)

    infoBox.append(contentInfoBox)
}

