import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

//This Component represent the Home Page of the WebApplication

export default function Home() {
  
  const [users, setUsers] = useState([]);    //Here the Object is Created using UseState()

  const { id } = useParams();

  useEffect(() => {
    loadUsers();
  }, []);

  //axios : It's used to conneect to the BackEnd Server.
  //async : It provides a React component and a Hook for declarative promise resolution and data fetching.
  //await :  It's usually used to unwrap promises by passing a Promise as the expression .
  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/taskdetails");
    setUsers(result.data);
  };

  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8080/task/${id}`);
    loadUsers();
  };

  //The return Statement represent the table of the Task which contain info of Task such as ID, Title, EndDate, Status etc.
  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">Title</th>
              <th scope="col">EndDate</th>
              <th scope="col">Status</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
    //Map is used to Dynamically adding the Task to the Table
          <tbody>
            {users.map((user, index) => (
              <tr key={index}>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{user.title}</td>
                <td>{user.endDate}</td>
                <td>{user.status}</td>
                <td>
              //Below are the 3 links tags which are used to View Task info, Edit task info and Delete a task
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/viewtask/${user.id}`}
                  >
                    View
                  </Link>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/edittask/${user.id}`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteUser(user.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
