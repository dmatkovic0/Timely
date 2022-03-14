import React, {useState} from "react";
import "./modalContent.css";

export default function ModalContent({ handleStopTimer, closeModal }) {

  const [projectName, setProjectName] = useState("")
  
  const handleChange = (event) => {
    setProjectName(event.target.value)
  }

  return (
    <div className="modalWrapper">
      <div className="modalHeaderWrapper">
        <h2 className="modalTitle">Stop timer</h2>
        <button className="closeModalButton" onClick={closeModal} />
      </div>
      <form style={{ display: "flex", flexDirection: "column" }} onSubmit={() => handleStopTimer(projectName)}> 
        <label className="inputLabel" htmlFor="projectInput">
          Project name:*
        </label>
        <input
          value={projectName}
          onChange={handleChange}
          id="projectInput"
          name="projectInput"
          className="projectInput"
          type="text"
          placeholder="Enter project name"
          required
        ></input>
        <button className="button-46" type="submit" >
          Stop timer
        </button>
      </form>
    </div>
  );
}
