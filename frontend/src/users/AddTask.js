import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddTask() {
  let navigate = useNavigate();  //It's used to Navigate to the Home Page.

  const [user, setUser] = useState({    
    title: "",
    endDate: "",
    status: "",
  });

  const { title, endDate, status } = user;    //Here the Object is Created using UseState().

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/task", user);
     navigate("/");  //Navigate to the HomePage
  };

  //In the Return statement it contain a Table ehich is used to add the Info of the Task (such as Title, EndDate and Status)
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register Task</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Title
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your Title"
                name="title"
                value={title}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                EndDate
              </label>
              <input
                type={"date"}    //It represent Date Picker
                className="form-control"
                placeholder="yyyy-MM-dd"
                name="endDate"
                value={endDate}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                Status
              </label>
              {/* <input
                type={"text"}
                className="form-control "
                placeholder="Enter your status"
                name="email"
                value={email}
                required
                onChange={(e) => onInputChange(e)}
              /> */}
              <select              
              name="status"
              value={status}
              onChange={event => onInputChange(event)}
              defaultValue={""}
              >
                //<Option> tag reprensent Dropdown List
                <option>--select--</option>    
                <option>Active</option>
                <option>Pending</option>
                <option>Completed</option>
              </select>
            </div>
              //Below are the Two Buttons Submit and Cancel, whem clicked on submit it
              //store the info of a task to the Database
              //and Cancel buttton Navigate user to the Home Page
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
