import React from "react";
import "./table.css";

export default function table({tableData}) {
  const tableHeaders = ["Project", "Start", "Stop", "Duration"];

  function convertTime(time) {
    var sec_num = parseInt(time, 10); 
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    return hours+':'+minutes+':'+seconds;
}

  return (
    <table>
      <thead>
        <tr className="tableHeaderElement">
          {tableHeaders.map((header) => (
            <th>{header}</th>
          ))}
        </tr>
      </thead>
      <tbody className="body">
      {tableData.map((rowdata) => (
        <tr className="row">
          <td className="tableDataElement">{rowdata.project}</td>
          <td className="tableDataElement">{rowdata.start}</td>
          <td className="tableDataElement">{rowdata.stop}</td>
          <td className="tableDataElement">{rowdata.duration === null ? null : convertTime(rowdata.duration/1000)}</td>
        </tr> ))}
      </tbody>
    </table>
  );
}
