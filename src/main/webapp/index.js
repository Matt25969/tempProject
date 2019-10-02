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
                    rej(reason);
                }
            }
            req.open(url, method)
            req.send(body);
        }
    );
}

function getAllRiders() {
    let searchURL = url + "Riders/GetRiders"
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;

            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");

            th1.innerHTML = "Rider ID";
            th2.innerHTML = "First Name";
            th3.innerHTML = "Last Name";
            th4.innerHTML = "Rider Number";
            th5.innerHTML = "Rider Team ID";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);
            headerRow.appendChild(th4);
            headerRow.appendChild(th5);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {

                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");

                td1.innerText = resParse[i].riderID;
                td2.innerText = resParse[i].firstName;
                td3.innerText = resParse[i].lastName;
                td4.innerText = resParse[i].riderNumber;
                td5.innerText = resParse[i].riderTeamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);

                table.appendChild(tableRow);

            }
        })
}

function getTeams() {
    let searchURL = url + "Teams/GetTeams"
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;

            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");

            th1.innerHTML = "Team ID";
            th2.innerHTML = "Team Name";
            th3.innerHTML = "Motorcycle Brand";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {

                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");

                td1.innerText = resParse[i].teamID;
                td2.innerText = resParse[i].teamName;
                td3.innerText = resParse[i].motorcycleBrand;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);

                table.appendChild(tableRow);

            }
        })
}

function getRaceLog() {
    let searchURL = url + "RaceLog/GetRaceLog"
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;

            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");
            const th6 = document.createElement("th");
            const th7 = document.createElement("th");

            th1.innerHTML = "Entry ID";
            th2.innerHTML = "Race Number";
            th3.innerHTML = "Race Location";
            th4.innerHTML = "Rider ID";
            th5.innerHTML = "Team ID";
            th6.innerHTML = "Race Position";
            th7.innerHTML = "Race Points";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);
            headerRow.appendChild(th4);
            headerRow.appendChild(th5);
            headerRow.appendChild(th6);
            headerRow.appendChild(th7);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {

                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");
                const td6 = document.createElement("td");
                const td7 = document.createElement("td");

                td1.innerText = resParse[i].entryID;
                td2.innerText = resParse[i].raceNumber;
                td3.innerText = resParse[i].raceLocation;
                td4.innerText = resParse[i].riderID;
                td5.innerText = resParse[i].teamID;
                td6.innerText = resParse[i].racePosition;
                td7.innerText = resParse[i].racePoints;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);
                tableRow.appendChild(td6);
                tableRow.appendChild(td7);

                table.appendChild(tableRow);

            }
        })
}

function getChampionship() {
    let searchURL = url + "Championship/GetChampionship"
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;

            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");

            th1.innerHTML = "Championship Position";
            th2.innerHTML = "Rider Total Points";
            th3.innerHTML = "Rider ID";
            th4.innerHTML = "Team ID";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);
            headerRow.appendChild(th4);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {

                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");

                td1.innerText = resParse[i].championshipPosition;
                td2.innerText = resParse[i].riderTotalPoints;
                td3.innerText = resParse[i].riderID;
                td4.innerText = resParse[i].teamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);

                table.appendChild(tableRow);

            }
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

function modifyPage() {
    window.location.href = "modify.html"
}

function getRider() {
    let riderID = document.getElementById("getInput").value;
    let searchURL = url + "Riders/GetSingleRider/" + riderID
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow2 = document.createElement("tr");
            let table = document.getElementById("table");

            let resParse = JSON.parse(res);

            const headerRow2 = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");

            th1.innerHTML = "Rider ID";
            th2.innerHTML = "First Name";
            th3.innerHTML = "Last Name";
            th4.innerHTML = "Rider Number";
            th5.innerHTML = "Rider Team ID";

            headerRow2.appendChild(th1);
            headerRow2.appendChild(th2);
            headerRow2.appendChild(th3);
            headerRow2.appendChild(th4);
            headerRow2.appendChild(th5);

            table.appendChild(headerRow2);

            const tableRow = document.createElement("tr");
            const td1 = document.createElement("td");
            const td2 = document.createElement("td");
            const td3 = document.createElement("td");
            const td4 = document.createElement("td");
            const td5 = document.createElement("td");

            td1.innerText = resParse.riderID;
            td2.innerText = resParse.firstName;
            td3.innerText = resParse.lastName;
            td4.innerText = resParse.riderNumber;
            td5.innerText = resParse.riderTeamID;

            tableRow.appendChild(td1);
            tableRow.appendChild(td2);
            tableRow.appendChild(td3);
            tableRow.appendChild(td4);
            tableRow.appendChild(td5);

            table.appendChild(tableRow);
        })
}

function getSingleTeam() {
    let teamID = document.getElementById("getInput").value;
    let searchURL = url + "Teams/GetSingleTeam/" + teamID
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow2 = document.createElement("tr");
            let table = document.getElementById("table");

            let resParse = JSON.parse(res);

            const headerRow2 = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            

            th1.innerHTML = "Team ID";
            th2.innerHTML = "Team Name";
            th3.innerHTML = "Motorcycle Brand";
            

            headerRow2.appendChild(th1);
            headerRow2.appendChild(th2);
            headerRow2.appendChild(th3);
            

            table.appendChild(headerRow2);

            const tableRow = document.createElement("tr");
            const td1 = document.createElement("td");
            const td2 = document.createElement("td");
            const td3 = document.createElement("td");
            
            td1.innerText = resParse.teamID;
            td2.innerText = resParse.teamName;
            td3.innerText = resParse.motorcycleBrand;
           

            tableRow.appendChild(td1);
            tableRow.appendChild(td2);
            tableRow.appendChild(td3);
            

            table.appendChild(tableRow);
        })
}

function getSingleRaceLogEntry() {
    let entryID = document.getElementById("getInput").value;
    let searchURL = url + "RaceLog/GetRaceLogEntry/" + entryID
    clearTable()
    poll("GET", searchURL)

        .then(res => {
            clearTable()
            const tableRow2 = document.createElement("tr");
            let table = document.getElementById("table");

            let resParse = JSON.parse(res);

            const headerRow2 = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");
            const th6 = document.createElement("th");
            const th7 = document.createElement("th");
            

            th1.innerHTML = "Entry ID";
            th2.innerHTML = "Race Number";
            th3.innerHTML = "Race Location";
            th4.innerHTML = "Rider ID";
            th5.innerHTML = "Team ID";
            th6.innerHTML = "Race Position";
            th7.innerHTML = "Race Points";
            

            headerRow2.appendChild(th1);
            headerRow2.appendChild(th2);
            headerRow2.appendChild(th3);
            headerRow2.appendChild(th4);
            headerRow2.appendChild(th5);
            headerRow2.appendChild(th6);
            headerRow2.appendChild(th7);
            

            table.appendChild(headerRow2);

            const tableRow = document.createElement("tr");
            const td1 = document.createElement("td");
            const td2 = document.createElement("td");
            const td3 = document.createElement("td");
            const td4 = document.createElement("td");
            const td5 = document.createElement("td");
            const td6 = document.createElement("td");
            const td7 = document.createElement("td");
            
            td1.innerText = resParse.entryID;
            td2.innerText = resParse.raceNumber;
            td3.innerText = resParse.raceLocation;
            td4.innerText = resParse.riderID;
            td5.innerText = resParse.teamID;
            td6.innerText = resParse.racePosition;
            td7.innerText = resParse.racePoints;
           

            tableRow.appendChild(td1);
            tableRow.appendChild(td2);
            tableRow.appendChild(td3);
            tableRow.appendChild(td4);
            tableRow.appendChild(td5);
            tableRow.appendChild(td6);
            tableRow.appendChild(td7);
            

            table.appendChild(tableRow);
        })
}

function getTeam() {

}

function getRaceLogEntry() {

}