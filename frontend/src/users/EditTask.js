import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

//In this Component User can Edit the Task
export default function EditTask() {
  let navigate = useNavigate();   //Used to Navigate to the HomePage

  const { id } = useParams();

  const [user, setUser] = useState({
    title: "",
    endDate: "",
    status: "",
  });

  const { title, endDate, status } = user;  //An Object is Created

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/task/${id}`, user);
    navigate("/");
  };

  //loadUSer() is used to Load the info of a task
  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/task/${id}`);
    setUser(result.data);
  };

  //In the return statement user have to update the existing Information of a task.
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Title
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="title"
                value={title}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                EndDate
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your username"
                name="endDate"
                value={endDate}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                Status
              </label>
              <select
              name="status"
              value={status}
              onChange={event => onInputChange(event)}
              defaultValue={""}
              >
                <option></option>
                <option>Active</option>
                <option>Pending</option>
                <option>Completed</option>
              </select>
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
