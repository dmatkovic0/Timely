import "./App.css";
import { useEffect } from "react";
import { startTimer, stopTimer, getData} from "./service";
import Table from "./table";
import { useState } from "react";

import Modal from "react-modal";

import ModalContent from "./modalContent";

function App() {
  const [tableShown, setTableShown] = useState(false);
  const [modalOpen, setModalOpen] = useState(false);
  const [tableData, setTableData] = useState([]);

  useEffect(() => { getData().then((response) => setTableData(response.data)) }, [])

  const handleOpenTable = () => {
    setTableShown(true);
    startTimer().then(() => getData().then((response) => setTableData(response.data)));
  };

  const handleStopClick = () => {
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
  };

  const handleStopTimer = (projectName) => {
    setModalOpen(false);
    stopTimer(projectName, tableData[tableData.length - 1].id).then(() => getData().then((response) => setTableData(response.data)));
  };

  const customStyles = {
    content: {
      top: "50%",
      left: "50%",
      right: "auto",
      bottom: "auto",
      width: "30%",
      marginRight: "-50%",
      transform: "translate(-50%, -50%)",
      backgroundColor: "#454442",
      borderRadius: "16px",
    },
  };

  return (
    <div className="App">
      <div className="titleWrapper">
        <div className="clockIcon" />
        <h1 className="appTitle">Timely</h1>
      </div>
      {tableData.length !== 0 && tableData[tableData.length - 1].stop === null ? (
        <button className="button-46" onClick={handleStopClick}>
          Stop
        </button>
      ) : (
        <button className="button-46" onClick={handleOpenTable}>
          Start
        </button>
      )}
      {tableData.length > 0 ? <Table tableData={tableData} /> : null}
      <Modal
        isOpen={modalOpen}
        onRequestClose={closeModal}
        style={customStyles}
      >
        <ModalContent
          handleStopTimer={handleStopTimer}
          closeModal={closeModal}
        />
      </Modal>
    </div>
  );
}

export default App;
