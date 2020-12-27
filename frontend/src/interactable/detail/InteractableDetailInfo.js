class InteractableDetailInfo {

  constructor(homeLocation, homeTemperature, homeTemperatureFeelsLike, homeWeatherType, workLocation, workTemperature, workTemperatureFeelsLike, workWeatherType) {
    this.homeLocation = homeLocation;
    this.homeTemperature = homeTemperature;
    this.homeTemperatureFeelsLike = homeTemperatureFeelsLike;
    this.homeWeatherType = homeWeatherType;
    this.workLocation = workLocation;
    this.workTemperature = workTemperature;
    this.workTemperatureFeelsLike = workTemperatureFeelsLike;
    this.workWeatherType = workWeatherType
  }

  static from(rawdata){
    
  }
}

export default InteractableDetailInfo;