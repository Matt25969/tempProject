let url = "http://35.246.189.98:8888/MotoGPManager/start/"

const poll = (url, method, body) => {

    return new Promise(
        function (res, rej) {
            const req = new XMLHttpRequest();
            req.onload = () => {
                if (req.status === 200) {
                    res(req.response);
                } else {
                    const reason = new Error('Rejected');
                    window.alert("Failure, please try again")
                    rej(reason);
                }
            }
            req.open(url, method)
            req.send(body);
        }
    );
}

function homePage() {
    window.location.href = "index.html"
}

function deleteRider() {
    let riderID = document.getElementById("deleteRiderBox").value;
    let searchURL = url + "Riders/DeleteRider/" + riderID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function deleteTeam() {
    let teamID = document.getElementById("deleteTeamBox").value;
    let searchURL = url + "Teams/DeleteTeam/" + teamID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function deleteRaceLogEntry() {
    let raceLogEntryID = document.getElementById("deleteRaceLogEntryBox").value;
    let searchURL = url + "RaceLog/DeleteRaceLogEntry/" + raceLogEntryID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function clearTable() {
    if (table.rows.length > 1) {

        let tableSize = table.rows.length;
        for (i = tableSize; i > 0; i--) {
            table.deleteRow(i - 1);
        }
    }
}

function createRider() {
    let searchURL = url + "Riders/CreateRider"

    let tempRiderID = document.getElementById("riderIDBox").value;
    let tempFirstName = document.getElementById("firstNameBox").value;
    let tempLastName = document.getElementById("lastNameBox").value;
    let tempRaceNumber = document.getElementById("raceNumberBox").value;
    let tempTeamID = document.getElementById("teamIDBox").value;

    let jsonToSend = "{\"firstName\":\"" + tempFirstName + "\",\"lastName\":\"" + tempLastName + "\",\"riderNumber\":" + tempRaceNumber + ",\"riderTeamID\":" + tempTeamID + "}";
   
    poll("POST", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}

function createTeam() {
    let searchURL = url + "Teams/CreateTeam"

    let tempTeamID = document.getElementById("teamIDBox0").value;
    let tempTeamName = document.getElementById("teamNameBox0").value;
    let tempMotorcycleBrand = document.getElementById("motorcycleBrandBox0").value;
   
    let jsonToSend = "{\"teamName\":\"" + tempTeamName + "\",\"motorcycleBrand\":\"" + tempMotorcycleBrand + "\"}";
   
    poll("POST", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}

function createRaceLogEntry() {
    let searchURL = url + "RaceLog/CreateRaceLogEntry"

    let tempEntryID = document.getElementById("entryIDBox1").value;
    let tempRaceNumber = document.getElementById("raceNumberBox1").value;
    let tempRaceLocation = document.getElementById("raceLocationBox1").value;
    let tempRiderID = document.getElementById("riderIDBox1").value;
    let tempTeamID = document.getElementById("teamIDBox1").value;
    let tempRacePosition = document.getElementById("racePositionBox1").value;
    let tempRacePoints = document.getElementById("racePointsBox1").value;

    
    let jsonToSend = "{\"raceNumber\":" + tempRaceNumber + ", \"raceLocation\":\""+ tempRaceLocation + "\", \"riderID\":" + tempRiderID + ", \"teamID\":" + tempTeamID + ", \"racePosition\":" + tempRacePosition + ", \"racePoints\":" + tempRacePoints + "}"
   console.log(jsonToSend);

    poll("POST", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}

function updateRider() {
    let tempRiderID = document.getElementById("riderIDBox").value;
    let searchURL = url + "Riders/UpdateRider/" + tempRiderID;

    let tempFirstName = document.getElementById("firstNameBox").value;
    let tempLastName = document.getElementById("lastNameBox").value;
    let tempRaceNumber = document.getElementById("raceNumberBox").value;
    let tempTeamID = document.getElementById("teamIDBox").value;

    let jsonToSend = "{\"firstName\":\"" + tempFirstName + "\",\"lastName\":\"" + tempLastName + "\",\"riderNumber\":" + tempRaceNumber + ",\"riderTeamID\":" + tempTeamID + "}";
   
    poll("PUT", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}

function updateTeam() {
    let tempTeamID = document.getElementById("teamIDBox0").value;
    let searchURL = url + "Teams/UpdateTeam/" + tempTeamID;

    let tempTeamName = document.getElementById("teamNameBox0").value;
    let tempMotorcycleBrand = document.getElementById("motorcycleBrandBox0").value;
   
    let jsonToSend = "{\"teamName\":\"" + tempTeamName + "\",\"motorcycleBrand\":\"" + tempMotorcycleBrand + "\"}";
   
    poll("PUT", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}

function updateRaceLogEntry() {
    let tempEntryID = document.getElementById("entryIDBox1").value;
    let searchURL = url + "RaceLog/UpdateRaceLogEntry/" + tempEntryID;

    let tempRaceNumber = document.getElementById("raceNumberBox1").value;
    let tempRaceLocation = document.getElementById("raceLocationBox1").value;
    let tempRiderID = document.getElementById("riderIDBox1").value;
    let tempTeamID = document.getElementById("teamIDBox1").value;
    let tempRacePosition = document.getElementById("racePositionBox1").value;
    let tempRacePoints = document.getElementById("racePointsBox1").value;

    
    let jsonToSend = "{\"raceNumber\":" + tempRaceNumber + ", \"raceLocation\":\""+ tempRaceLocation + "\", \"riderID\":" + tempRiderID + ", \"teamID\":" + tempTeamID + ", \"racePosition\":" + tempRacePosition + ", \"racePoints\":" + tempRacePoints + "}"
   console.log(jsonToSend);

    poll("PUT", searchURL, jsonToSend)

        .then(res => {
            window.alert(res)
        })
}