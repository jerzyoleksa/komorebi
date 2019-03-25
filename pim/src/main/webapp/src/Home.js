import React, { Component } from "react";
import MyComponent from "./MyComponent";

class Home extends Component {
	
	state = {
		    contacts: []
		  };
	
	componentDidMount() {
	    fetch("https://randomuser.me/api/?format=json&results=10")
	      .then(res => res.json())
	      .then(json => this.setState({ contacts: json.results }));
	  }	
	
  render() {
    return (
      <div>
        <h2>HELLO</h2>
        <p>Cras facilisis urna ornare ex volutpat, et
        convallis erat elementum. Ut aliquam, ipsum vitae
        gravida suscipit, metus dui bibendum est, eget rhoncus nibh
        metus nec massa. Maecenas hendrerit laoreet augue
        nec molestie. Cum sociis natoque penatibus et magnis
        dis parturient montes, nascetur ridiculus mus.</p>
 
        <p>Duis a turpis sed lacus dapibus elementum sed eu lectus.</p>
        
        <MyComponent />
        
      </div>
    );
  }
}
 
export default Home;