/**
 * This function is responsible for displaying the information obtained from the server regarding weather forecast
 */
function getWeatherForecast() {
    // Define the endpoint to connect to.
    fetch('http://localhost:8080/rest/recipe')
        // catch the response and put this in a json format.
        .then(response => {
            return response.json()
        })
        // with the response from above, the data object makes it possible to interact
        // with the json object.
        .then(data => {

            console.log(data);

            // Change the title of the recipe
            document.getElementsByTagName('h1')[0].innerHTML = data.name;
            // Change the description of the recipe
            document.getElementsByTagName('h2')[0].innerHTML = data.description

            var ingredients = [];

            ingredients = data.ingredients;

            // Create the ingredients
            var list = document.createElement('ul');
            ingredients.forEach(ingredient => {

                const item = document.createElement('li');
                var ingredientDescription = ingredient.amount + " " + ingredient.measurement.descriptionDutch + " " + ingredient.ingredient.nameDutch;

                item.textContent = ingredientDescription;
                list.appendChild(item);
            });
            //Append the found elements to the html file
            document.getElementById('ingredients').appendChild(list);

            var steps = [];
            steps = data.steps;

            var stepList = document.createElement('ol');
            steps.forEach(step => {
                const item = document.createElement('li');
                item.textContent = step.description;
                stepList.appendChild(item);
            });

            document.getElementById("steps").appendChild(stepList);

            // if errors happen, then this step is executed.
        }).catch(err => {
        console.log(err)
        console.log('something went wrong earlier...');
    });
}
