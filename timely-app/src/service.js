import axios from "axios";
axios.defaults.baseURL = "http://localhost:8081";
axios.defaults.headers['Access-Control-Allow-Origin'] = '*';

export const startTimer = () => {
    return axios.post("/timely/set-time-start")
}

export const stopTimer = (projectName, id) => {
    return axios.post("/timely/set-time-stop?projectName=" + projectName + "&id=" + id)
}

export const getData = () => {
    return axios.get("timely/project-status", {crossDomain:true})
}