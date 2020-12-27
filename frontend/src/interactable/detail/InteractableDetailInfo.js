class InteractableDetailInfo {

  constructor(homeLocation, homeTemperature, homeTemperatureFeelsLike, homeWeatherType, workLocation, workTemperature, workTemperatureFeelsLike, workWeatherType, homeWeatherPicture, workWeatherPicture) {
    this.homeLocation = homeLocation;
    this.homeTemperature = homeTemperature;
    this.homeTemperatureFeelsLike = homeTemperatureFeelsLike;
    this.homeWeatherType = homeWeatherType;
    this.workLocation = workLocation;
    this.workTemperature = workTemperature;
    this.workTemperatureFeelsLike = workTemperatureFeelsLike;
    this.workWeatherType = workWeatherType
    this.homeWeatherPicture = homeWeatherPicture;
    this.workWeatherPicture = workWeatherPicture;
  }

  static from(rawData) {
    // debugger; // eslint-disable-line no-debugger
    const weatherData = rawData.weatherForecast;
    this.homeLocation = weatherData.homeLocation;
    this.homeTemperature = weatherData.homeTemperature;
    this.homeTemperatureFeelsLike = weatherData.homeTemperatureFeelsLike;
    this.homeWeatherType = weatherData.homeWeatherType;
    this.workLocation = weatherData.workLocation;
    this.workTemperature = weatherData.workTemperature;
    this.workTemperatureFeelsLike = weatherData.workTemperatureFeelsLike;
    this.workWeatherType = weatherData.workWeatherType;
    this.homeWeatherPicture = rawData.homeWeatherPicture;
    this.workWeatherPicture = rawData.workWeatherPicture;
    return InteractableDetailInfo;
  }
}

export default InteractableDetailInfo;