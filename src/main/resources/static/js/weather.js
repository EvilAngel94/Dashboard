/**
 * This function is responsible for displaying the information obtained from the server regarding weather forecast
 */
function getWeatherForecast() {

    fetch('http://localhost:8080/rest/weather')
        .then(response => {
            return response.json()
        }).then(
        weatherForecast => {
            console.log(weatherForecast)

            const weatherRow = document.getElementById('row-details')
            weatherRow.className = 'row-detail'

            const infoBox = document.createElement('div')
            infoBox.className = 'info-box'
            weatherRow.append(infoBox)

            const img = document.createElement('img')
            img.src = weatherForecast.homeWeatherPicture
            img.className = 'info-box-img'
            infoBox.append(img)

            const paragraph = document.createElement('p')
            paragraph.className = 'info-box-p'
            const textToDisplay = weatherForecast.weatherForecast.homeLocation + " /nTemerature feel: " + weatherForecast.weatherForecast.homeTemperatureFeelsLike + "/nThe actual temp is: " + weatherForecast.weatherForecast.homeTemperature
            paragraph.textContent = textToDisplay
            infoBox.append(paragraph)

            const infoBox2 = document.createElement('div')
            infoBox2.className = 'info-box'
            weatherRow.append(infoBox2)

            const imgWork = document.createElement('img')
            imgWork.src = weatherForecast.workWeatherPicture
            imgWork.className = 'info-box-img'
            infoBox2.append(imgWork)

        }
    ).catch(error => {
        console.log(error)
        console.log('Something somewhere went wrong. What could it be..?')
    })

}

