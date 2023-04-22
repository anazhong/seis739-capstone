const caloricForm = document.getElementById('caloric-form');
const entryForm = document.getElementById('entry-form');
const entryList = document.getElementById('entry-list');
const result = document.getElementById('result');

caloricForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const age = parseInt(document.getElementById('age').value);
    const height = parseInt(document.getElementById('height').value);
    const weight = parseInt(document.getElementById('weight').value);
    const sex = document.getElementById('sex').value;

    const maintenance = calculateMaintenance(age, height, weight, sex);
    result.textContent = `Daily Caloric Maintenance: ${maintenance} calories`;

    // const apiUrl = 'http://localhost:8080/caloric-maintenance';

    // const data = {
    //     age,
    //     height,
    //     weight,
    //     sex,
    //     maintenance
    // };

    // // Send data to API
    // fetch(apiUrl, {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify(data)
    // });
});

entryForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const date = document.getElementById('date').value;
    const calories = parseInt(document.getElementById('calories').value);

    const apiUrl = 'http://localhost:8080/calorie-entry';

    const data = {
        date,
        calories
    };

    // Add entry to API
    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ date, calories }),
    }).then(() => {
        addEntryToList(date, calories);
        e.target.reset();
    }).catch((error) => {
        console.error('Error adding entry:', error);
    });
});

// Load calorie entries from the API when the page is loaded
window.addEventListener('DOMContentLoaded', () => {
    const apiUrl = '/calorie-entries';

    // Fetch calorie entries from the API
    fetch(apiUrl)
        .then((response) => response.json())
        .then((entries) => {
            entries.forEach(({ date, calories }) => {
                addEntryToList(date, calories);
            });
        });
});

// Add a new entry to the entry list
function addEntryToList(date, calories) {
    const entry = document.createElement('li');
    entry.textContent = `${date}: ${calories} calories`;

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', () => {
        const apiUrl = `/calorie-entry/${entryList.ATTRIBUTE_NODE}`;

        // Delete entry from API

        // fetch(apiUrl, {
        //     method: 'DELETE'
        // }).then(() => {
        //     entryList.removeChild(entry);
        // });

        const response = fetch('/delete-calorie-entry', {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({ date, calories }),
          });
      
          if (response.ok) {
            console.log('Entry deleted successfully');
            // Refresh the entries list or perform other UI updates here
            entryList.removeChild(entry);
          } else {
            console.error('Error deleting entry:', response.status);
            entryList.removeChild(entry);
          }
    });

    entry.appendChild(deleteButton);
    entryList.appendChild(entry);
}

function calculateMaintenance(age, height, weight, sex) {
    let bmr;

    if (sex === 'male') {
        bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    } else {
        bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }

    // Assuming a sedentary lifestyle (1.2 times BMR)
    return Math.round(bmr * 1.2);
}
